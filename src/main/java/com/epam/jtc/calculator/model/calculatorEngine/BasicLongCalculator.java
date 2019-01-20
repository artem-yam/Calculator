package com.epam.jtc.calculator.model.calculatorEngine;

abstract class BasicLongCalculator implements CalculatorEngine {

    private final int radix;

    BasicLongCalculator(int radix) {
        this.radix = radix;
    }

    long add(long x, long y) {
        return x + y;
    }

    long subtract(long x, long y) {
        return x - y;
    }

    long multiply(long x, long y) {
        return x * y;
    }

    long divide(long x, long y) {
        return x / y;
    }

    long parseToLong(String stringForParsing) {
        return Long.parseLong(stringForParsing, radix);
    }
}

