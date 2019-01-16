package com.epam.jtc.calculator.calculatorEngine;

public interface CalculatorEngine {

    String add(String x, String y) throws NumberFormatException;

    String subtract(String x, String y) throws NumberFormatException;

    String multiply(String x, String y) throws NumberFormatException;

    String divide(String x, String y) throws NumberFormatException;
}
