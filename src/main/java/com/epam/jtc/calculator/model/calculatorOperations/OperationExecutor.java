package com.epam.jtc.calculator.model.calculatorOperations;

import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;

public class OperationExecutor {

    private static final String STRING_WITH_ZERO = "0";

    private CalculatorEngine calculationEngine;

    public OperationExecutor(
            CalculatorEngine calculationEngine) {
        this.calculationEngine = calculationEngine;
    }

    public String calculate(OperationData operationData) {
        String result = "";
        String x = operationData.getX();
        String y = operationData.getY();

        // if one of arguments is empty
        if (x.isEmpty() || y.isEmpty()) {
            OperationData defaultOperationData = new OperationData();

            defaultOperationData.setOperationType(OperationType.ADD);

            defaultOperationData.setX(x.isEmpty() ? STRING_WITH_ZERO : x);
            defaultOperationData.setY(y.isEmpty() ? STRING_WITH_ZERO : y);

            operationData = defaultOperationData;
        }

        return execute(operationData);
    }


    private String execute(OperationData operationData) {
        String result = "";
        switch (operationData.getOperationType()) {
            case ADD:
                result = calculationEngine
                        .add(operationData.getX(), operationData.getY());
                break;
            case SUBTRACT:
                result = calculationEngine
                        .subtract(operationData.getX(),
                                operationData.getY());
                break;
            case MULTIPLY:
                result = calculationEngine
                        .multiply(operationData.getX(),
                                operationData.getY());
                break;
            case DIVIDE:
                result = calculationEngine
                        .divide(operationData.getX(), operationData.getY());
                break;
        }

        return result;
    }

}
