package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int rollDices() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        int lives = 5, dice1, dice2, launch = 0,
                totalEven = 0, totalOdd = 0, totalEqual = 0, consecutive = 0;
        String player_name, key;
        boolean gameOver = false, youWin = false;

        System.out.println("::: Welcome to Roll Dices :::");
        System.out.print("player name: ");
        player_name = data.nextLine();
        System.out.println("Press enter to start the game...");
        data.nextLine();

        while (!gameOver && !youWin) {

            System.out.println("\nPress ENTER to roll the dices... (or type 'exit' to quit)");
            key = data.nextLine();

            if (key.equalsIgnoreCase("exit")) {
                System.out.println("You left the game.");
                break;
            }

            launch++;
            dice1 = rollDices();
            dice2 = rollDices();
            int sum = dice1 + dice2;

            System.out.println("\n--- L" + launch + " ---");
            System.out.println("Dice 1: " + dice1 + " | Dice 2: " + dice2 + " | Sum: " + sum);
            if (dice1 == dice2) {
                totalEqual++;
                consecutive++;
                System.out.println("Equal dices! Consecutive equal rolls: " + consecutive);

                if (dice1 == 6) {
                    lives++;
                    System.out.println("Double 6! You earn one extra life. Lives: " + lives);
                }

                if (consecutive >= 3) {
                    youWin = true;
                }
            } else {
                consecutive = 0;
            }

            if (sum % 2 != 0) {
                totalOdd++;
                lives--;
                System.out.println("Odd sum! You lose one life. Lives: " + lives);
                if (lives <= 0) {
                    gameOver = true;
                }
            } else {
                totalEven++;
                System.out.println("Even sum! Game continues. Lives: " + lives);
            }
        }
        if (gameOver) {
            System.out.println("\n::: GAME OVER :::");

        } else if (youWin) {
            System.out.println("\n::: YOU WIN :::");

        }
        System.out.println("\n::: FINAL REPORT ::: Player: " + player_name);
        System.out.println("Total launches:           " + launch);
        System.out.println("Launches with even sum:   " + totalEven);
        System.out.println("Launches with odd sum:    " + totalOdd);
        System.out.println("Launches with equal dice: " + totalEqual);
    }
}