package Pig;

import java.util.Scanner;

public class PigApp {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // NEW
        RollPiggy game = new RollPiggy();
        int score = game.welcome();
        boolean playing = true; //NEW
        while (playing == true) { // NEW
            game.gameLoop(score); // NEW
            System.out.println("Wanna play again? (Y)"); // NEW
            String input = in.nextLine(); // NEW
            if ((input.toLowerCase().startsWith("y") || input.toLowerCase().startsWith("j")) == false) { // NEW
                break; // New
            }

            }

        }

    }
