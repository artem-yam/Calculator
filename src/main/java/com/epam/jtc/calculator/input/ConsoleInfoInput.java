package com.epam.jtc.calculator.input;

import java.util.Scanner;

public class ConsoleInfoInput implements InfoInput {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String getNextLine() {
        return scanner.nextLine().trim();
    }

    @Override
    public boolean canRead() {
        return scanner.hasNext();
    }

    @Override
    public void closeResource() {
        scanner.close();
    }
}
