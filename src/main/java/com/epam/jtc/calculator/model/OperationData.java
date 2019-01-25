package com.epam.jtc.calculator.model;

public class OperationData {

    private String x;
    private String y;
    private Operations operation;

    public OperationData(String x, String y, Operations operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
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

}
