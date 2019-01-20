package com.epam.jtc.calculator.utils.output;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationResult(String result);

    void showUnsupportedRadixError(String radix);

    void showWrongNuberFormatError(String message);

    void showTooManyOperatorsWarning();

    void showEmptyInputWarning();
}
