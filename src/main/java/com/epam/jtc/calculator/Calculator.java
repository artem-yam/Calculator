package com.epam.jtc.calculator;

import com.epam.jtc.calculator.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.calculatorEngine.DecimalCalculator;
import com.epam.jtc.calculator.calculatorEngine.HexadecimalCalculator;
import com.epam.jtc.calculator.utils.input.ConsoleInfoInput;
import com.epam.jtc.calculator.utils.input.InfoInput;
import com.epam.jtc.calculator.utils.output.ConsoleInfoOutput;
import com.epam.jtc.calculator.utils.output.InfoOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private static final String UNSUPPORTED_OPERATION =
            "Unsupported operation %s";
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w]+[()\\s]*";


    private InfoOutput infoOutput = new ConsoleInfoOutput();
    private InfoInput infoInput = new ConsoleInfoInput();
    private CalculatorEngine calculationEngine = null;

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.processCalculation();

        calculator.infoInput.closeResource();
    }

    public InfoInput getInfoInput() {
        return infoInput;
    }

    public void processCalculation() {

        do {
            infoOutput.showRadixRequest();

            selectCalculationEngine(infoInput.getNextLine());
        } while (calculationEngine == null);

        infoOutput.showExpressionRequest();

        while (infoInput.canRead()) {
            String expression;

            do {
                expression = infoInput.getNextLine();
            } while (expression.isEmpty());

            calculate(expression);

            infoOutput.showExpressionRequest();
        }
    }

    private void selectCalculationEngine(String inputedRadix) {
        SupportedRadixEnum radix = null;

        for (SupportedRadixEnum supportedRadix : SupportedRadixEnum.values()) {
            if (inputedRadix.equals(supportedRadix.getRadix())) {
                radix = supportedRadix;
                break;
            }
        }


        if (radix == null) {
            infoOutput.showUnsupportedRadixError(inputedRadix);
        } else {
            switch (radix) {
                case HEXADECIMAL:
                    calculationEngine = new HexadecimalCalculator();
                    break;
                case DECIMAL:
                    calculationEngine = new DecimalCalculator();
                    break;
            }
        }

    }

    private void calculate(String expression) {
        List<String> values = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        getValuesAndOperations(values, operations, expression);

        String result = values.get(0);

        for (int i = 1; i < operations.size(); i++) {

            result = calculate(result, values.get(i), operations.get(i));

            infoOutput.showOperationResult(result);
        }
    }

    private void getValuesAndOperations(List<String> values,
                                        List<String> operations,
                                        String expression) {
        String[] s2 = expression.split(REGEX_TO_SPLIT_OPERATIONS_VALUES);
        String[] s3 = expression.split(REGEX_TO_SPLIT_OPERATIONS_SIGNS);

        Collections.addAll(values, s2);
        Collections.addAll(operations, s3);

        if (s3.length > s2.length) {
            operations.remove(operations.size() - 1);
        }
    }

    private String calculate(String x, String y, String operation) {
        String result = "";

        try {
            switch (operation) {
                case "+":
                    result = calculationEngine.add(x, y);
                    break;
                case "-":
                    result = calculationEngine.subtract(x, y);
                    break;
                case "*":
                    result = calculationEngine.multiply(x, y);
                    break;
                case "/":
                    result = calculationEngine.divide(x, y);
                    break;
                default:
                    result = String.format(UNSUPPORTED_OPERATION, operation);
                    break;
            }
        } catch (NumberFormatException numberFormatException) {
            infoOutput.showErrors(numberFormatException);
        }

        return result;
    }

}
