package pairOfDice;

import java.util.Scanner;

public class PlayRollDie {
    Scanner in = new Scanner(System.in);
    PairOfDice turn = new PairOfDice();


    public void welcome() {
        System.out.println("Welcome to the game!");

    }

    public void roll() {
        boolean finnished = false;

        while (!finnished) {
            System.out.println("Vil dy kaste? Ja eller Nej");
            String input = in.next();
            if (input.toLowerCase().startsWith("n")) {
                finnished = true;
            }
            else if (input.toLowerCase().startsWith("j")) {
                System.out.println(turn.RollBothDice());
                System.out.println("Det højeste kast endnu er " +turn.getHighestRoll());
            }





        }
    }






}

