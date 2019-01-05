package com.epam.jtc.calculator.input;

import java.util.Scanner;

public class ConsoleInfoInput implements InfoInput {

    private static final Scanner scanner = new Scanner(System.in);


    public String getNextLine() {
        return scanner.nextLine().trim();
    }

    public boolean canRead() {
        return scanner.hasNext();
    }
}
