package com.epam.jtc.calculator.utils;

import java.util.Collections;
import java.util.List;

public class ExpressionReformer {
    private static final String REGEX_TO_SPLIT_OPERATIONS_VALUES =
            "[()\\s]*[+\\-*/]+[()\\s]*";
    private static final String REGEX_TO_SPLIT_OPERATIONS_SIGNS =
            "[()\\s]*[.,\\w[а-яА-Я]*]+[()\\s]*";


    public void formArgumentsAndOperatorsLists(List<String> formedArguments,
            List<String> formedOperators, String expression) {
        String[] arguments = expression.split(REGEX_TO_SPLIT_OPERATIONS_VALUES);
        String[] operators = expression.split(REGEX_TO_SPLIT_OPERATIONS_SIGNS);

        if (operators.length > arguments.length) {
            throw new IllegalArgumentException();
        } else {
            Collections.addAll(formedArguments, arguments);
            Collections.addAll(formedOperators, operators);
        }
    }
}
