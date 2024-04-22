package com.example;


import java.util.Random;
import java.util.Scanner;

public class NumeroDaIndovinare {
    public static void main(String[] args) {
        Random rand = new Random();
        int numeroCasuale = rand.nextInt(100) + 1;
        System.out.println(numeroCasuale);
        int guess = 0;
        Scanner scanner = new Scanner(System.in);

        promptGuess(scanner, guess, numeroCasuale);

        System.out.println("You guessed it!");
    }

    private static void promptGuess(Scanner scanner, int guess, int numeroCasuale) {
        do {
            System.out.println("Insert a number between 1 and 100");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
            } else {
                System.out.println("That's not a number. Try again!");
                scanner.nextLine();
            }
            if (guess < numeroCasuale) {
                System.out.println("Your guess is lower than the target number");
            } else if (guess > numeroCasuale) {
                System.out.println("Your guess is higher than the target number.");
            }
        } while (guess != numeroCasuale);
    }
}
