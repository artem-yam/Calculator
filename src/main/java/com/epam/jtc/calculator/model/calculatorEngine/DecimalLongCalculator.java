package com.epam.jtc.calculator.model.calculatorEngine;

public class DecimalLongCalculator extends BasicLongCalculator {

    private static final int radix = 10;

    public DecimalLongCalculator() {
        super(radix);
    }

    @Override
    public String add(String x, String y) {
        return Long.toString(addWithParsing(x, y));
    }

    @Override
    public String subtract(String x, String y) {
        return Long.toString(subtractWithParsing(x, y));
    }

    @Override
    public String multiply(String x, String y) {
        return Long.toString(multiplyWithParsing(x, y));
    }

    @Override
    public String divide(String x, String y) {
        return Long.toString(divideWithParsing(x, y));
    }
}