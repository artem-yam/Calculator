package com.epam.jtc.calculator;

import com.epam.jtc.calculator.Output.ConsoleInfoOutput;
import com.epam.jtc.calculator.Output.InfoOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final String UNSUPPORTED_OPERATION =
            "Unsupported operation %s";
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w]+[()\\s]*";


    private InfoOutput infoOutput = new ConsoleInfoOutput();
    private Scanner infoInput = new Scanner(System.in);
    private CalculatorEngine calculationEngine = new DecimalCalculator();

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.processCalculation();

        calculator.infoInput.close();
    }

    private void processCalculation() {
        infoOutput.requestRadix();

        selectCalculationEngine(infoInput.nextLine());

        infoOutput.requestNewExpression();

        while (infoInput.hasNext()) {
            String expression = "";

            while (expression.isEmpty()) {
                expression = infoInput.nextLine().trim();
            }

            calculate(expression);

            infoOutput.requestNewExpression();
        }
    }

    private void selectCalculationEngine(String radix) {
        switch (radix) {
            case "16":
                calculationEngine = new HexadecimalCalculator();
                break;
            default:
                calculationEngine = new DecimalCalculator();
                break;
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
            List<String> operations, String expression) {
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
