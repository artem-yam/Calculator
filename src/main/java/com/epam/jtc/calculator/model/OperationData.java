package com.epam.jtc.calculator.model;

import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;

public class OperationData {

    private static final String STRING_WITH_ZERO = "0";

    private String x;
    private String y;
    private Operations operation;
    private CalculatorEngine calculationEngine;

    public OperationData(String x, String y, Operations operation,
            CalculatorEngine calculationEngine) {
        this.x = x;
        this.y = y;
        this.operation = operation;
        this.calculationEngine = calculationEngine;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public CalculatorEngine getCalculationEngine() {
        return calculationEngine;
    }

    public void setCalculationEngine(CalculatorEngine calculationEngine) {
        this.calculationEngine = calculationEngine;
    }

    public String calculate() {
        String result = "";

        if (x.isEmpty()) {
            result = calculationEngine.add(STRING_WITH_ZERO, y);
        } else if (y.isEmpty()) {
            result = calculationEngine.add(x, STRING_WITH_ZERO);
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

        return result;
    }
}
