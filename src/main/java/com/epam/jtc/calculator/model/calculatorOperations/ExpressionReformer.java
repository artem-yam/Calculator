package com.epam.jtc.calculator.model.calculatorOperations;

import java.util.ArrayList;
import java.util.List;

public class ExpressionReformer {
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w[а-яА-Я]]+[()\\s]*";
    private static final String UNSUPPORTED_OPERATION =
            "Unsupported operation %s.";
    private static final String TOO_MANY_OPERATORS = "Too many operators! ";
    private static final String OPERATOR_ADD = "+";

    private ExpressionReformer() {
    }

    public static List<OperationData> reformToOperationsList(
            String expression, OperationExecutor executor) {

        String[] arguments = expression.split(REGEX_TO_SPLIT_OPERATIONS_VALUES);
        String[] operators = expression.split(REGEX_TO_SPLIT_OPERATIONS_SIGNS);

        if (operators.length <= arguments.length) {

            return formOperationsList(arguments, operators, executor);

        } else {
            throw new IllegalArgumentException(TOO_MANY_OPERATORS);
        }

    }


    private static List<OperationData> formOperationsList(
            String[] arguments,
            String[] operators,
            OperationExecutor executor) {

        List<OperationData> operations = new ArrayList<>();

        String result = "";

        for (int i = 0; i < arguments.length; i++) {

            String operator;
            if (i != 0) {
                operator = operators[i];
            } else {
                operator = OPERATOR_ADD;
            }

            OperationData operationData =
                    formSingleOperation(operator, result,
                            arguments[i]);

            // if expression have more than 1 argument
            // don't add first operation (this argument + 0)
            // to list for output
            if (!(arguments.length > 1 && i == 0)) {
                operations.add(operationData);
            }

            result = executor.calculate(operationData);

        }

        return operations;
    }

    private static OperationData formSingleOperation(
            String operator,
            String argumentX, String argumentY) {

        OperationType operationType = OperationType.UNSUPPORTED;

        for (OperationType supportedOperation : OperationType
                .values()) {
            if (supportedOperation.getSign().equals(operator)) {
                operationType = supportedOperation;
                break;
            }
        }

        if (operationType != OperationType.UNSUPPORTED) {

            return new OperationData(argumentX,
                    argumentY, operationType);

        } else {
            throw new IllegalArgumentException(
                    String.format(UNSUPPORTED_OPERATION, operator));
        }

    }

}
