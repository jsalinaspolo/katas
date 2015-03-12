package jspcore.com.domain.entities;

import jspcore.com.domain.values.Player;

public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public int players() {
        return 2;
    }


}
