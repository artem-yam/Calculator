package com.epam.jtc.calculator.model.calculatorEngine;

public class DecimalLongCalculator extends BasicLongCalculator {

    private static final int radix = 10;

    public DecimalLongCalculator() {
        super(radix);
    }

    @Override
    public String add(String x, String y) {
        return Long.toString(add(parseToLong(x), parseToLong(y)));
    }

    @Override
    public String subtract(String x, String y) {
        return Long.toString(subtract(parseToLong(x), parseToLong(y)));
    }

    @Override
    public String multiply(String x, String y) {
        return Long.toString(multiply(parseToLong(x), parseToLong(y)));
    }

    @Override
    public String divide(String x, String y) {
        return Long.toString(divide(parseToLong(x), parseToLong(y)));
    }
}