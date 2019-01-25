package com.epam.jtc.calculator.utils;

import com.epam.jtc.calculator.model.OperationData;
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

        if (operationData.getX().isEmpty()) {
            result = calculationEngine
                    .add(STRING_WITH_ZERO, operationData.getY());
        } else if (operationData.getY().isEmpty()) {
            result = calculationEngine
                    .add(operationData.getX(), STRING_WITH_ZERO);
        } else {

            switch (operationData.getOperation()) {
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
        }

        return result;
    }

}
