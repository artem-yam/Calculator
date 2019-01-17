package com.epam.jtc.calculator.utils.output;

public class ConsoleInfoOutput implements InfoOutput {

    private static final String RADIX_REQUEST = "Input radix: ";
    private static final String UNSUPPORTED_RADIX =
            "Unsupported radix: %s. " + "Please, try another one.\n";
    private static final String EXPRESSION_REQUEST = "Input new expression: ";
    private final static String OPERATION_RESULT = "Result: %s\n";


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
    public void showErrors(Throwable... errors) {
        for (Throwable error : errors) {
            error.printStackTrace();
            System.err.println("----------------------");
            System.err.println(
                    "Class name = " + error.getStackTrace()[0].getClassName());
            System.err.println("----------------------");
            System.err.println(
                    "File name = " + error.getStackTrace()[0].getFileName());
            System.err.println("----------------------");
            System.err.println("Method name = " +
                    error.getStackTrace()[0].getMethodName());
        }
    }

    @Override
    public void showUnsupportedRadixError(String radix) {
        System.out.printf(UNSUPPORTED_RADIX, radix);
    }
}
