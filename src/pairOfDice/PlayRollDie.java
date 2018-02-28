package pairOfDice;

import java.util.Scanner;

public class PlayRollDie {
    Scanner in = new Scanner(System.in);
    PairOfDice turn = new PairOfDice();


    public void welcome() {
        System.out.println("Let the gaaaames begin");

    }

    public void gameLoop() {
        boolean finnished = false;

        while (!finnished) {
            System.out.println("Du har kastet " + turn.getRolls() * 2 + " terninge.");
            System.out.println("Vil du kaste? Ja eller Nej");
            String input = in.next();
            if (input.toLowerCase().startsWith("n")) {
                turn.printRollInfo();
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

    public void bye() {
        System.out.println("Tak for at du spillede");
    }


}

