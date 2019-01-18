package com.epam.jtc.calculator.calculatorEngine;

public class HexadecimalLongCalculator extends BasicLongCalculator {

    private static final int radix = 16;

    public HexadecimalLongCalculator() {
        super(radix);
    }

    @Override
    public String add(String x, String y) {
        return Long.toHexString(super.add(parseToLong(x), parseToLong(y)));
    }

    @Override
    public String subtract(String x, String y) {
        return Long.toHexString(super.subtract(parseToLong(x), parseToLong(y)));
    }

    @Override
    public String multiply(String x, String y) {
        return Long.toHexString(super.multiply(parseToLong(x), parseToLong(y)));
    }

    @Override
    public String divide(String x, String y) {
        return Long.toHexString(super.divide(parseToLong(x), parseToLong(y)));
    }

}

