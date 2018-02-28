package pairOfDice;

import javafx.util.Pair;

public class PlayMe {

    public static void main(String[] args) {
        PlayRollDie game = new PlayRollDie();

        game.welcome();
        game.gameLoop();
        game.bye();



    }



}
