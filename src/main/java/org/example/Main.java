package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startTheGame();
    }

    public static int subtractThePointsAndWriteOutTheMessage(String message1, int tries) {
        tries--;
        System.out.println(message1);
        System.out.println("You have " + tries + " more tries.");
        if (tries > 0) {
            System.out.println("Please try again");
        }
        return tries;
    }

    public static void startTheGame() {
        String startGameCommunicate = "Please guess the number from 0 to 99.";
        String numberToHighCommunicate = "Your number is GREATER than the one you are trying to guess";
        String numberToLowCommunicate = "Your number is LOWER than the one you are trying to guess";
        String winnerCommunicate = "You guessed it!";
        String loserCommunicate = "Sorry you didn't guess the number, the answer was: ";

        int numberToGuess = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        int trialGuessing = 5;
        System.out.println(startGameCommunicate);
        while (trialGuessing != 0) {
            userNumber = scanner.nextInt();
            if (userNumber > numberToGuess) {
                trialGuessing = subtractThePointsAndWriteOutTheMessage(numberToLowCommunicate, trialGuessing);
            } else if (userNumber < numberToGuess) {
                trialGuessing = subtractThePointsAndWriteOutTheMessage(numberToHighCommunicate, trialGuessing);
            } else {
                System.out.println(winnerCommunicate);
            }
        }
        System.out.println(loserCommunicate + numberToGuess);
    }
}