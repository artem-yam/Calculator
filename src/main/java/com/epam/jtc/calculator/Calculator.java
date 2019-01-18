package com.epam.jtc.calculator;

import com.epam.jtc.calculator.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.calculatorEngine.DecimalLongCalculator;
import com.epam.jtc.calculator.calculatorEngine.HexadecimalLongCalculator;
import com.epam.jtc.calculator.utils.input.ConsoleInfoInput;
import com.epam.jtc.calculator.utils.input.InfoInput;
import com.epam.jtc.calculator.utils.output.ConsoleInfoOutput;
import com.epam.jtc.calculator.utils.output.InfoOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO проверить все классы по SOLID
public class Calculator {

    private static final String UNSUPPORTED_OPERATION =
            "Unsupported operation %s";
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w[а-яА-Я]*]+[()\\s]*";
    private static final String STRING_WITH_ZERO = "0";


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
            String expression = infoInput.getNextLine();

            if (expression.isEmpty()) {
                infoOutput.showEmptyInputWarning();
            } else {
                calculate(expression);
            }

            infoOutput.showExpressionRequest();
        }

    }

    //TODO вынести в отдельный класс
    private void selectCalculationEngine(String inputedRadix) {
        SupportedNumberSystemEnum radix = null;

        for (SupportedNumberSystemEnum supportedRadix : SupportedNumberSystemEnum
                .values()) {
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
                    calculationEngine = new HexadecimalLongCalculator();
                    break;
                case DECIMAL:
                    calculationEngine = new DecimalLongCalculator();
                    break;
            }
        }

    }

    private void calculate(String expression) {
        List<String> arguments = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        formArgumentsAndOperatorsLists(arguments, operators, expression);

        if (!arguments.isEmpty()) {

            String result = "";

            for (int i = 0; i < arguments.size(); i++) {
                String operation = "";

                if (operators.size() > i) {
                    operation = operators.get(i);
                }

                result = calculate(result, arguments.get(i),
                        operation);

                if (!((arguments.size() > 1 && i == 0) || result.isEmpty())) {
                    infoOutput.showOperationResult(result);
                }
            }
        }
    }


    private void formArgumentsAndOperatorsLists(List<String> formedArguments,
                                                List<String> formedOperators,
                                                String expression) {
        String[] arguments = expression.split(REGEX_TO_SPLIT_OPERATIONS_VALUES);
        String[] operators = expression.split(REGEX_TO_SPLIT_OPERATIONS_SIGNS);

        if (operators.length > arguments.length) {
            infoOutput.showTooManyOperatorsWarning();
            //  formedOperators.remove(formedOperators.size() - 1);
        } else {
            Collections.addAll(formedArguments, arguments);
            Collections.addAll(formedOperators, operators);
        }
    }

    private String calculate(String x, String y, String suggestedOperation) {
        String result = "";

        SupportedOperationsEnum operation = null;

        for (SupportedOperationsEnum supportedOperation : SupportedOperationsEnum
                .values()) {
            if (suggestedOperation.equals(supportedOperation.getSign())) {
                operation = supportedOperation;
                break;
            }
        }

        try {
            if (x.equals("")) {
                result = calculationEngine.add(STRING_WITH_ZERO, y);
            } else if (y.equals("")) {
                result = calculationEngine.add(x, STRING_WITH_ZERO);
            } else if (operation == null) {
                result = String.format(UNSUPPORTED_OPERATION,
                        suggestedOperation);
            } else {


                switch (operation) {
                    case ADD:
                        result = calculationEngine.add(x, y);
                        break;
                    case SUBTRACT:
                        result = calculationEngine.subtract(x, y);
                        break;
                    case MULTIPLY:
                        result = calculationEngine.multiply(x, y);
                        break;
                    case DIVIDE:
                        result = calculationEngine.divide(x, y);
                        break;
                }

            }
        } catch (NumberFormatException numberFormatException) {
            infoOutput.showException(numberFormatException);
        }


        return result;
    }

}
