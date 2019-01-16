package com.epam.jtc.calculator.utils.input;

public interface InfoInput {

    String getNextLine();

    boolean canRead();

    void closeResource();
}
