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
            System.out.println("Du har kastet " + turn.getRolls() * 2 + " terninge.");
            System.out.println("Vil du kaste? Ja eller Nej");
            String input = in.next();
            if (input.toLowerCase().startsWith("n")) {
                turn.printStuff();
                System.out.println("Det højeste kast endnu er " +turn.getHighestRoll());
                turn.resetPairOfDice();
                System.out.println("Spille igen?");
                String again = in.next();
                if (again.toLowerCase().startsWith("n")) {
                    finnished = true;
                }
                else {
                    continue;
                }

            }
            else if (input.toLowerCase().startsWith("j")) {
                System.out.println(turn.RollBothDice());

            }





        }
    }






}

