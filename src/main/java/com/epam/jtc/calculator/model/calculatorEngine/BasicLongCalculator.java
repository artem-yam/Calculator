package com.epam.jtc.calculator.model.calculatorEngine;

abstract class BasicLongCalculator implements CalculatorEngine {

    private final int radix;

    protected BasicLongCalculator(int radix) {
        this.radix = radix;
    }

    protected long addWithParsing(String x, String y) {
        return add(parseToLong(x), parseToLong(y));
    }

    protected long subtractWithParsing(String x, String y) {
        return subtract(parseToLong(x), parseToLong(y));
    }

    protected long multiplyWithParsing(String x, String y) {
        return multiply(parseToLong(x), parseToLong(y));
    }

    public long divideWithParsing(String x, String y) {
        return divide(parseToLong(x), parseToLong(y));
    }

    private long add(long x, long y) {
        return x + y;
    }

    private long subtract(long x, long y) {
        return x - y;
    }

    private long multiply(long x, long y) {
        return x * y;
    }

    private long divide(long x, long y) {
        return x / y;
    }

    private long parseToLong(String stringForParsing) {
        return Long.parseLong(stringForParsing, radix);
    }
}

