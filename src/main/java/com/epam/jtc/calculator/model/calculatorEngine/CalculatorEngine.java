package com.epam.jtc.calculator.model.calculatorEngine;

public interface CalculatorEngine {

    String add(String x, String y);

    String subtract(String x, String y);

    String multiply(String x, String y);

    String divide(String x, String y) throws ArithmeticException;
}
