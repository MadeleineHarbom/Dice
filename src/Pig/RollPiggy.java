package Pig;

import java.util.Scanner;

public class RollPiggy {
    Scanner in = new Scanner(System.in);

    Die die = new Die();

    private boolean gameOn = true;
    private Player winner;

    public void welcome() {
        System.out.println("Let's play Pig, pig!");
    }

    /*
    private void setUp() {
        System.out.println("Hvad heder den første spiller?");
        String inputName1 = in.nextLine();
        Player p1 = new Player(inputName1);
        System.out.println("Hvad heder den adre spiller?");
        String inputName2 = in.nextLine();
        Player p2 = new Player(inputName2);
        System.out.println("Welcome to the game, " + p1.getName() + " and " + p2.getName());

    }
    */
    private Player setUp() {
        System.out.println("Hvad heder spilleren?");
        String inputName1 = in.nextLine();
        Player p = new Player(inputName1);
        return p; }


    private Player turn(Player player) {
        Player winner;
        player.setCurrent();
        System.out.println("Your banked points are " + player.getBanked());
        System.out.println("Let's roll");
        in.nextLine();
        boolean playing = true;
        die.roll(); // BREAK IN ROLL =1 !!!
        player.addToCurrent(die.getFaceValue());
        System.out.println("You rolled " + die.getFaceValue() + ", making your score " + player.getCurrent());
        winner = check100(Player);
        if (this.gameOn == false) {
            return winner;
        }
        System.out.println("Vil du slå igen (skriv ja) ellers går turen videre");
        String cont = in.nextLine();
        if (cont.toLowerCase().startsWith("j") || cont.toLowerCase().startsWith("y")) {
            while (playing == true) {
                System.out.println("Your banked points are " + player.getBanked());
                die.roll();
                player.addToCurrent(die.getFaceValue());
                System.out.println("You rolled " + die.getFaceValue() + ", making your score " + player.getCurrent());
                System.out.println("Vil du slå igen (skriv ja) ellers går turen videre");
                String cont2 = in.nextLine();
                if (cont.toLowerCase().startsWith("j") || cont.toLowerCase().startsWith("y")) {
                    continue;
                } else {
                    player.setBanked();
                    return winner;
                }
            }
        }
        else {
                player.setBanked();
                return winner;



        }


    }


    private Player check100 (Player player) {
        Player winner = null; // Make me null
        if (player.getCurrent() >= 100 ) {
            winner = player;
            this.gameOn = false;

        }

        return winner;

    }


    public void gameLoop() {
        Player p1 =setUp();
        Player p2 = setUp();
        while (this.gameOn) {
            turn(p1);
            if (this.gameOn ==false) {
                break;
            }
            turn(p2);

        }

    }



}
