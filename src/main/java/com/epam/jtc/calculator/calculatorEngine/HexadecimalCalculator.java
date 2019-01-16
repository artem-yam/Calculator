package com.epam.jtc.calculator.calculatorEngine;

public class HexadecimalCalculator implements CalculatorEngine {

    @Override
    public String add(String x, String y) {
        long result = Long.parseLong(x, 16) + Long.parseLong(y, 16);
        return Long.toHexString(result);
    }

    @Override
    public String subtract(String x, String y) {
        long result = Long.parseLong(x, 16) - Long.parseLong(y, 16);
        return Long.toHexString(result);
    }

    @Override
    public String multiply(String x, String y) {
        long result = Long.parseLong(x, 16) * Long.parseLong(y, 16);
        return Long.toHexString(result);
    }

    @Override
    public String divide(String x, String y) {
        long result = Long.parseLong(x, 16) / Long.parseLong(y, 16);
        return Long.toHexString(result);
    }
}

