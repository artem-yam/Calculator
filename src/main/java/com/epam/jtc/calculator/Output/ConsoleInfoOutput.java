package com.epam.jtc.calculator.Output;

public class ConsoleInfoOutput implements InfoOutput {

    private static final String RADIX_REQUEST = "Input radix: ";
    private static final String EXPRESSION_REQUEST = "Input new expression: ";
    private final static String OPERATION_RESULT = "Result: %s\n";


    @Override
    public void requestRadix() {
        System.out.print(RADIX_REQUEST);
    }

    @Override
    public void requestNewExpression() {
        System.out.print(EXPRESSION_REQUEST);
    }

    @Override
    public void showOperationResult(String result) {
        System.out.printf(OPERATION_RESULT, result);
    }

    @Override
    public void showErrors(Throwable... errors) {
        for (Throwable error : errors) {
            System.err.println(error.toString());
        }
    }
}
