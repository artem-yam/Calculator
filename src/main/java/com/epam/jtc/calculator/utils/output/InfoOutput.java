package com.epam.jtc.calculator.utils.output;

import com.epam.jtc.calculator.model.OperationData;

import java.util.List;

public interface InfoOutput {

    void showRadixRequest();

    void showExpressionRequest();

    void showOperationsResults(List<String> results);

    void showError(Throwable exception);

    void showEmptyInputWarning();


}
