package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startTheGame();
    }

    public static int subtractThePointsAndWriteOutTheMessage(Enum message1, int tries) {
        tries--;
        System.out.println(message1);
        System.out.println("You have " + tries + " more tries.");
        if (tries > 0) {
            System.out.println("Please try again");
        }
        return tries;
    }

    public static void startTheGame() {
        int userNumber;
        int trialGuessing = 5;
        int numberToGuess = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);

        System.out.println(Communicate.START);
        while (trialGuessing != 0) {
            userNumber = scanner.nextInt();
            if (userNumber > numberToGuess) {
                trialGuessing = subtractThePointsAndWriteOutTheMessage(Communicate.NUMBER_LOW, trialGuessing);
            } else if (userNumber < numberToGuess) {
                trialGuessing = subtractThePointsAndWriteOutTheMessage(Communicate.NUMBER_HIGH, trialGuessing);
            } else {
                System.out.println(Communicate.WINNER);
            }
        }
        System.out.println(Communicate.END.toString() + numberToGuess);
    }

    public enum Communicate {
        START {
            public String toString() {
                return "Please guess the number from 0 to 99";
            }
        },
        NUMBER_HIGH {
            public String toString() {
                return "Your number is GREATER than the one you are trying to guess";
            }
        },
        NUMBER_LOW {
            public String toString() {
                return "Your number is LOWER than the one you are trying to guess";
            }
        },
        WINNER {
            public String toString() {
                return "You guessed it!";
            }
        },
        END {
            public String toString() {
                return "Sorry you didn't guess the number, the answer was: ";
            }
        }
    }
}