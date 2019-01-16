package com.epam.jtc.calculator;

public enum SupportedRadixEnum {
    DECIMAL("10"), HEXADECIMAL("16");

    private final String radix;

    SupportedRadixEnum(String radix) {
        this.radix = radix;
    }

    public String getRadix() {
        return radix;
    }
}
