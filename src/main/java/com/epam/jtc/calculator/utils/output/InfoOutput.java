package com.epam.jtc.calculator.utils.output;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationResult(String result);

    void showException(Throwable error);

    void showUnsupportedRadixError(String radix);

    void showTooManyOperatorsWarning();

    void showEmptyInputWarning();
}
