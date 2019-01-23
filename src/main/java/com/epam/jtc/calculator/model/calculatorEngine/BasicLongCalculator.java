package com.epam.jtc.calculator.model.calculatorEngine;

abstract class BasicLongCalculator implements CalculatorEngine {

    private final int radix;

    protected BasicLongCalculator(int radix) {
        this.radix = radix;
    }

    protected long add(long x, long y) {
        return x + y;
    }

    protected long subtract(long x, long y) {
        return x - y;
    }

    protected long multiply(long x, long y) {
        return x * y;
    }

    protected long divide(long x, long y) {
        return x / y;
    }

    protected long parseToLong(String stringForParsing) {
        return Long.parseLong(stringForParsing, radix);
    }
}

