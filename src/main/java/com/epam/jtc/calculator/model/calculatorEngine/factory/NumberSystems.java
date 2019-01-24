package com.epam.jtc.calculator.model.calculatorEngine.factory;

public enum NumberSystems {
    DECIMAL("10"), HEXADECIMAL("16"), UNSUPPORTED("");

    private final String radix;

    NumberSystems(String radix) {
        this.radix = radix;
    }

    public String getRadix() {
        return radix;
    }
}
