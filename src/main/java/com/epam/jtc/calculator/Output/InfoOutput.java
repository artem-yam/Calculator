package com.epam.jtc.calculator.Output;

public interface InfoOutput {

    void requestRadix();

    void requestNewExpression();

    void showOperationResult(String result);

    void showErrors(Throwable... errors);


}
