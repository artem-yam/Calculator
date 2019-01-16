package com.epam.jtc.calculator.utils.output;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationResult(String result);

    void showErrors(Throwable... errors);

    void showUnsupportedRadixError(String radix);

}
