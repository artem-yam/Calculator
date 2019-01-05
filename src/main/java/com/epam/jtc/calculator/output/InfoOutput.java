package com.epam.jtc.calculator.output;

public interface InfoOutput {

    void requestRadix();

    void requestNewExpression();

    void showOperationResult(String result);

    void showErrors(Throwable... errors);


}
