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
        return p;
    }


    private Player turn(Player player) {
        Player winner;
        player.setCurrent();
        System.out.println(player.getName() + "'s banked points are " + player.getBanked());
        System.out.println("Let's roll, " + player.getName() + "!");
        in.nextLine();
        boolean playing = true; // REDUNDANT!
        die.roll();
        if (die.getFaceValue() == 1) { // NEW
            System.out.println(player.getName() + " rolled 1 and loose their turn"); //NEW
            return winner = null; // NEW
        }
        player.addToCurrent(die.getFaceValue());
        System.out.println(player.getName() + " rolled " + die.getFaceValue() + ", making their score " + player.getCurrent());
        winner = check100(player);
        if (this.gameOn == false) {
            return winner;
        }
        System.out.println("Vil du slå igen (skriv ja) ellers går turen videre");
        String cont = in.nextLine();
        if (cont.toLowerCase().startsWith("j") || cont.toLowerCase().startsWith("y")) {
            while (playing == true) {
                System.out.println(player.getName() + "'s banked points are " + player.getBanked());
                die.roll();
                if (die.getFaceValue() == 1) { // NEW
                    System.out.println(player.getName() + " rolled 1 and loose their turn");
                    break; // NEW
                }
                player.addToCurrent(die.getFaceValue());
                System.out.println(player.getName() + " rolled " + die.getFaceValue() + ", making their score " + player.getCurrent());
                winner = check100(player); // NEW
                if (this.gameOn == false) { // NEW
                    return winner; // NEW
                }
                System.out.println("Vil du slå igen (skriv ja) ellers går turen videre");
                String cont2 = in.nextLine();
                if (cont2.toLowerCase().startsWith("j") || cont2.toLowerCase().startsWith("y")) { // BUG FIX
                    continue;
                } else {
                    player.setBanked();
                    return winner;
                }
            }
        } else {
            player.setBanked();
            return winner;


        }
        return winner;


    }


    private Player check100(Player player) {
        Player winner = null;
        if (player.getCurrent() >= 10) { // FIX ME
            winner = player;
            this.gameOn = false;

        }

        return winner;

    }

    private void gameOver(Player player) {
        System.out.println(player.getName() + " won! Grats");
    }


    public void gameLoop() {
        Player stuff = null; //NEW
        Player p1 = setUp();
        Player p2 = setUp();
        while (this.gameOn == true) { // NEW
            turn(p1);
            stuff = check100(p1); // NEW
            if (this.gameOn == false) {
                gameOver(stuff);
                break;
            }
            turn(p2);
            stuff = check100(p2); // NEW
            if (this.gameOn == false) { // NEW
                gameOver(stuff); // NEW
                break; // NEW

            }
            //gameOver(stuff);

        }


    }
}
