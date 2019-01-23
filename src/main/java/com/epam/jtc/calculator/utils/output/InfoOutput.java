package com.epam.jtc.calculator.utils.output;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationResult(String result);

    void showError(Throwable exception);

    void showEmptyInputWarning();
}
