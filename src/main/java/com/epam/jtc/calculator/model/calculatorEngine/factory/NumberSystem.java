package com.epam.jtc.calculator.model.calculatorEngine.factory;

public enum NumberSystem {
    DECIMAL("10"), HEXADECIMAL("16"), UNSUPPORTED("");

    private final String radix;

    NumberSystem(String radix) {
        this.radix = radix;
    }

    public String getRadix() {
        return radix;
    }
}
