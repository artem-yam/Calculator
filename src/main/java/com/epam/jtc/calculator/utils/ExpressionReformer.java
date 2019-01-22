package com.epam.jtc.calculator.utils;

import java.util.Collections;
import java.util.List;

public class ExpressionReformer {
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w[а-яА-Я]*]+[()\\s]*";
    private static final String TOO_MANY_OPERATORS = "Too many operators! ";


    public void formArgumentsAndOperatorsLists(List<String> formedArguments,
                                               List<String> formedOperators,
                                               String expression) {
        String[] arguments = expression.split(REGEX_TO_SPLIT_OPERATIONS_VALUES);
        String[] operators = expression.split(REGEX_TO_SPLIT_OPERATIONS_SIGNS);

        if (operators.length > arguments.length) {
            throw new IllegalArgumentException(TOO_MANY_OPERATORS);
        } else {
            Collections.addAll(formedArguments, arguments);
            Collections.addAll(formedOperators, operators);
        }
    }
}
