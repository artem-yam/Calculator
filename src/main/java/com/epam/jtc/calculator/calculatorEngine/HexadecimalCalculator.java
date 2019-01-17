package com.epam.jtc.calculator.calculatorEngine;

public class HexadecimalCalculator implements CalculatorEngine {

    private static final int radix = 16;

    @Override
    public String add(String x, String y) {
        long result = Long.parseLong(x, radix) + Long.parseLong(y, radix);
        return Long.toHexString(result);
    }

    @Override
    public String subtract(String x, String y) {
        long result = Long.parseLong(x, radix) - Long.parseLong(y, radix);
        return Long.toHexString(result);
    }

    @Override
    public String multiply(String x, String y) {
        long result = Long.parseLong(x, radix) * Long.parseLong(y, radix);
        return Long.toHexString(result);
    }

    @Override
    public String divide(String x, String y) {
        long result = Long.parseLong(x, radix) / Long.parseLong(y, radix);
        return Long.toHexString(result);
    }
}

