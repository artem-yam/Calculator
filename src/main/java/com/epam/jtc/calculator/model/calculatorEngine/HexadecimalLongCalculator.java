package com.epam.jtc.calculator.model.calculatorEngine;

public class HexadecimalLongCalculator extends BasicLongCalculator {

    private static final int radix = 16;

    public HexadecimalLongCalculator() {
        super(radix);
    }

    @Override
    public String add(String x, String y) {
        return Long.toHexString(addWithParsing(x, y));
    }

    @Override
    public String subtract(String x, String y) {
        return Long.toHexString(subtractWithParsing(x, y));
    }

    @Override
    public String multiply(String x, String y) {
        return Long.toHexString(multiplyWithParsing(x, y));
    }

    @Override
    public String divide(String x, String y) {
        return Long.toHexString(divideWithParsing(x, y));
    }

}

