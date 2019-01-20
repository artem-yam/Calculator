package com.epam.jtc.calculator.utils.output;

public class ConsoleInfoOutput implements InfoOutput {

    private final static String RADIX_REQUEST = "Input radix: \n";
    private final static String UNSUPPORTED_RADIX = "Unsupported radix: %s. ";
    private final static String EXPRESSION_REQUEST = "Input new expression: \n";
    private final static String OPERATION_RESULT = "Result: %s\n";
    private final static String CHANGE_INPUT = "Please change your input.\n";
    private final static String TOO_MANY_OPERATORS = "Too many operators! ";
    private final static String EMPTY_EXPRESSION = "Empty expression! ";
    private final static String NUMBER_FORMAT_EXCEPTION_MESSAGE =
            "%s: Argument is too long or contains unsupported " +
                    "characters for current number system\n";


    @Override
    public void showRadixRequest() {
        System.out.print(RADIX_REQUEST);
    }

    @Override
    public void showExpressionRequest() {
        System.out.print(EXPRESSION_REQUEST);
    }

    @Override
    public void showOperationResult(String result) {
        System.out.printf(OPERATION_RESULT, result);
    }


    @Override
    public void showUnsupportedRadixError(String radix) {
        System.err.printf(UNSUPPORTED_RADIX, radix);
        System.err.print(CHANGE_INPUT);
    }

    @Override
    public void showWrongNuberFormatError(String message) {
        System.err.format(NUMBER_FORMAT_EXCEPTION_MESSAGE,
                message);
    }

    @Override
    public void showTooManyOperatorsWarning() {
        System.err.print(TOO_MANY_OPERATORS);
        System.err.print(CHANGE_INPUT);
    }

    @Override
    public void showEmptyInputWarning() {
        System.err.print(EMPTY_EXPRESSION);
        System.err.print(CHANGE_INPUT);
    }
}
