package com.epam.jtc.calculator.utils.input;

import java.util.Scanner;

public class ConsoleInfoInput implements InfoInput {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getNextLine() {
        return scanner.nextLine().trim();
    }

    @Override
    public boolean canRead() {
        return scanner.hasNextLine();
    }

    @Override
    public void closeResource() {
        scanner.close();
    }
}
