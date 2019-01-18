package com.epam.jtc.calculator;

public enum SupportedOperationsEnum {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String sign;

    SupportedOperationsEnum(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
