package com.epam.jtc.calculator.utils.output;

public class ConsoleInfoOutput implements InfoOutput {

    private final static String RADIX_REQUEST = "Input radix: \n";
    private final static String EXPRESSION_REQUEST = "Input new expression: \n";
    private final static String OPERATION_RESULT = "Result: %s\n";
    private final static String CHANGE_INPUT = "Please change your input.\n";
    private final static String EMPTY_EXPRESSION = "Empty expression! ";
    private final static String NUMBER_FORMAT_EXCEPTION_MESSAGE =
            "%s: Argument is too long or contains unsupported " +
                    "characters for current number system. ";


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
    public void showError(Throwable exception) {

        if (exception.getClass().equals(NumberFormatException.class)) {
            System.err.format(NUMBER_FORMAT_EXCEPTION_MESSAGE,
                    exception.getMessage());
        } else {
            System.err.println(exception.getMessage());
        }
        System.err.print(CHANGE_INPUT);

    }

    @Override
    public void showEmptyInputWarning() {
        System.err.print(EMPTY_EXPRESSION);
        System.err.print(CHANGE_INPUT);
    }
}
