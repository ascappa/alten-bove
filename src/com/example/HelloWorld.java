package com.example;

import java.io.PrintStream;


public class HelloWorld {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try {
            String fileName = "output.txt";
            PrintStream printStream = new PrintStream(fileName);
            printStream.println("According to all known laws of aviation...");
            printStream.close();
        } catch (Exception e) {
            System.out.println("Ci sono degli errori nell'esecuzione del codice...");
        }

        long executionTime = System.currentTimeMillis() - startTime;

        System.out.printf("Il tempo di esecuzione del programma è %dms.\n", executionTime);
    }
}
