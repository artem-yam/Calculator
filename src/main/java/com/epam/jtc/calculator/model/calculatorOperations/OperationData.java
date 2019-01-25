package com.epam.jtc.calculator.model.calculatorOperations;

public class OperationData {

    private String x;
    private String y;
    private OperationType operationType;

    public OperationData(String x, String y, OperationType operation) {
        this.x = x;
        this.y = y;
        this.operationType = operation;
    }

    public OperationData() {

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

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

}
