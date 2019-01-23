package com.epam.jtc.calculator.model;

public enum Operations {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), UNSUPPORTED("");

    private final String sign;

    Operations(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
