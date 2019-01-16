package com.epam.jtc.calculator.calculatorEngine;

public class
DecimalCalculator implements CalculatorEngine {

    @Override
    public String add(String x, String y) {
        double result = Double.parseDouble(x) + Double.parseDouble(y);
        return Double.toString(result);
    }

    @Override
    public String subtract(String x, String y) {
        double result = Double.parseDouble(x) - Double.parseDouble(y);
        return Double.toString(result);
    }

    @Override
    public String multiply(String x, String y) {
        double result = Double.parseDouble(x) * Double.parseDouble(y);
        return Double.toString(result);
    }

    @Override
    public String divide(String x, String y) {
        double result = Double.parseDouble(x) / Double.parseDouble(y);
        return Double.toString(result);
    }
}