package com.epam.jtc.calculator.utils.output;

import java.util.List;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationsResults(List<String> results);

    void showError(Throwable exception);

    void showEmptyInputWarning();


}
