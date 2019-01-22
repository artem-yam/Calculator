package com.epam.jtc.calculator.utils.output;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationResult(String result);

    void showUnsupportedRadixError(Throwable exception);

    void showWrongNumberFormatError(String message);

    void showTooManyOperatorsWarning(Throwable exception);

    void showEmptyInputWarning();
}
