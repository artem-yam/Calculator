package com.epam.jtc.calculator;

import com.epam.jtc.calculator.model.CalculatorConfigurator;
import com.epam.jtc.calculator.model.Operations;
import com.epam.jtc.calculator.utils.ExpressionReformer;
import com.epam.jtc.calculator.utils.input.ConsoleInfoInput;
import com.epam.jtc.calculator.utils.input.InfoInput;
import com.epam.jtc.calculator.utils.output.ConsoleInfoOutput;
import com.epam.jtc.calculator.utils.output.InfoOutput;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String UNSUPPORTED_OPERATION =
            "Unsupported operation %s";
    private static final String STRING_WITH_ZERO = "0";


    private InfoOutput infoOutput = new ConsoleInfoOutput();
    private InfoInput infoInput = new ConsoleInfoInput();

    private CalculatorConfigurator configuration =
            new CalculatorConfigurator();

    private ExpressionReformer expressionReformer =
            new ExpressionReformer();

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.startCalculations();

        calculator.infoInput.closeResource();
    }

    public InfoInput getInfoInput() {
        return infoInput;
    }

    public void startCalculations() {

        do {
            infoOutput.showRadixRequest();

            try {
                configuration.selectCalculationEngine(infoInput.getNextLine());

            } catch (IllegalArgumentException illegalArgumentException) {
                infoOutput.showError(
                        illegalArgumentException);
            }

        } while (configuration.getCalculationEngine() == null);


        while (infoInput.canRead()) {
            infoOutput.showExpressionRequest();

            String expression = infoInput.getNextLine();

            if (!expression.isEmpty()) {
                try {
                    List<String> results = processExpression(expression);

                    infoOutput.showOperationResults(results);

                } catch (IllegalArgumentException illegalArgumentException) {
                    infoOutput.showError(illegalArgumentException);
                }

            } else {
                infoOutput.showEmptyInputWarning();
            }

        }

    }

    private List<String> processExpression(String expression) {
        List<String> results = new ArrayList<>();

        List<String> arguments = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        expressionReformer.formArgumentsAndOperatorsLists(arguments,
                operators, expression);

        String result = "";

        for (int i = 0; i < arguments.size(); i++) {
            String operation = "";

            if (operators.size() > i) {
                operation = operators.get(i);
            }

            result = calculate(result, arguments.get(i), operation);

            if (!((arguments.size() > 1 && i == 0) || result.isEmpty())) {
                results.add(result);
            }
        }

        return results;
    }


    private String calculate(String x, String y, String suggestedOperation) {
        String result = "";

        Operations operation = Operations.UNSUPPORTED;

        for (Operations supportedOperation :
                Operations
                        .values()) {
            if (supportedOperation.getSign().equals(suggestedOperation)) {
                operation = supportedOperation;
                break;
            }
        }

        try {
            if (x.isEmpty()) {
                result = configuration.getCalculationEngine().add(
                        STRING_WITH_ZERO, y);
            } else if (y.isEmpty()) {
                result = configuration.getCalculationEngine().add(x,
                        STRING_WITH_ZERO);
            } else {

                switch (operation) {
                    case ADD:
                        result = configuration.getCalculationEngine().add(x, y);
                        break;
                    case SUBTRACT:
                        result = configuration.getCalculationEngine().subtract(
                                x, y);
                        break;
                    case MULTIPLY:
                        result = configuration.getCalculationEngine().multiply(
                                x, y);
                        break;
                    case DIVIDE:
                        result = configuration.getCalculationEngine().divide(x,
                                y);
                        break;
                    default:
                        result = String.format(UNSUPPORTED_OPERATION,
                                suggestedOperation);
                        break;
                }

            }
        } catch (NumberFormatException numberFormatException) {
            infoOutput.showError(numberFormatException);
        }

        return result;
    }

}
