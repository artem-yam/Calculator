package com.epam.jtc.calculator.model;

public enum SupportedNumberSystemEnum {
    DECIMAL("10"), HEXADECIMAL("16");

    private final String radix;

    SupportedNumberSystemEnum(String radix) {
        this.radix = radix;
    }

    public String getRadix() {
        return radix;
    }
}
