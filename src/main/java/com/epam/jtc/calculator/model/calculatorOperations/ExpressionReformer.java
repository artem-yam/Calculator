package com.epam.jtc.calculator.model.calculatorOperations;

import java.util.ArrayList;
import java.util.List;

public class ExpressionReformer {
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w[а-яА-Я]*]+[()\\s]*";
    private static final String UNSUPPORTED_OPERATION =
            "Unsupported operation %s.";
    private static final String TOO_MANY_OPERATORS = "Too many operators! ";

    private ExpressionReformer() {
    }

    public static List<OperationData> formOperationsList(
            String expression, OperationExecutor executor) {

        List<OperationData> operations = new ArrayList<>();

        String[] arguments = expression.split(REGEX_TO_SPLIT_OPERATIONS_VALUES);
        String[] operators = expression.split(REGEX_TO_SPLIT_OPERATIONS_SIGNS);

        if (operators.length > arguments.length) {
            throw new IllegalArgumentException(TOO_MANY_OPERATORS);
        } else {

            String result = "";

            for (int i = 0; i < arguments.length; i++) {
                Operations operation = Operations.UNSUPPORTED;

                if (i == 0) {
                    operation = Operations.ADD;
                } else {
                    for (Operations supportedOperation : Operations.values()) {
                        if (supportedOperation.getSign().equals(operators[i])) {
                            operation = supportedOperation;
                            break;
                        }
                    }
                }

                if (operation == Operations.UNSUPPORTED) {
                    throw new IllegalArgumentException(
                            String.format(UNSUPPORTED_OPERATION, operators[i]));
                }

                OperationData operationData = new OperationData(result,
                        arguments[i], operation);


                if (!(arguments.length > 1 && i == 0)) {
                    operations.add(operationData);
                }


                result = executor.calculate(operationData);
            }


        }

        return operations;
    }

}
