package com.epam.jtc.calculator.model.calculatorOperations;

public enum OperationType {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), UNSUPPORTED("");

    private final String sign;

    OperationType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
