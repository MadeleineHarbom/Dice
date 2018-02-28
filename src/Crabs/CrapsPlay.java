package Crabs;

import java.util.Scanner;

public class CrapsPlay {

    Scanner in = new Scanner(System.in);

    private boolean winner;
    private Die die1;
    private Die die2;
    private int point;
    private boolean playing = true;

    public CrapsPlay () {
        this(6);
    }

    public CrapsPlay (int sides) {
        die1 = new Die(sides);
        die2 = new Die(sides);
    }

    public void welcomeToGame() {
        System.out.println("HEy! Let's play Craps! :D");
    }

    private void gameOver() {
        System.out.println("Game over");
        if (winner == true) {
            System.out.println("You won, you talented fucker!");
        }
        else {
            System.out.println("You lost, nab cake");
        }
    }

    private String firstTurn() {
        die1.roll();
        die2.roll();
        int sum = die1.getFaceValue() + die2.getFaceValue();
        if (sum ==  7 || sum == 11) {
            this.point = sum;
            winner = true;
        }
        else if (sum == 2 || sum == 3 || sum == 12) {
            this.point = sum;
            winner = false;
        }
        else {
            this.point = sum;
        }
        return "You rolled " + die1.getFaceValue() + " and " + die2.getFaceValue() + ". Your point is " + this.point + "!";
    }

    private String takeTurn() {
        die1.roll();
        die2.roll();
        int sum = die1.getFaceValue() + die2.getFaceValue();
        if (sum == 7) {
            winner = false;
            playing = false;
        }
        else if (sum == this.point) {
            winner = true;
            playing = false;
        }
        return "You rolled " + die1.getFaceValue() + " and " + die2.getFaceValue() + ". The sum is " + sum;
    }

    public void startGame() {
        System.out.println(firstTurn());
        while (this.playing == true) {
            System.out.println("Vil du kaste? Ja eller Nej");
            String input = in.next();
            if (input.toLowerCase().startsWith("n")) {
                this.playing = false;
            }
            else if (input.toLowerCase().startsWith("j") || input.toLowerCase().startsWith("y")) {
                System.out.println(takeTurn());
            }

        }
        gameOver();

    }
}
