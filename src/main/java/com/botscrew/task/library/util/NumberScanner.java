package com.botscrew.task.library.util;

import java.util.Scanner;

public class NumberScanner {
    private static NumberScanner instance;
    private Scanner scanner = new Scanner(System.in);

    private NumberScanner(){}

    public int nextInt(){
        while (!scanner.hasNextInt()){
            System.out.println("Incorrect input, please enter number!");
            scanner.next();
        }
            return scanner.nextInt();
    }

    public static NumberScanner getInstance(){
        if(instance == null)
            instance = new NumberScanner();
        return instance;
    }
}
