package com.jspcore.domain.entities;

import jspcore.com.domain.entities.Game;
import jspcore.com.domain.values.Player;
import jspcore.com.domain.values.Points;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameShould {

    private Game game;
    private final Player player1 = Player.create("Javier");
    private final Player player2 = Player.create("MuSTa1nE");

    @Before public void
    setUp() {
        game = new Game(player1, player2);
    }

    @Test public void
    have_two_players() {
        assertThat(game.players(), is(2));
    }

    @Test public void
    have_score_fifteen_love_when_player1_win_a_point() {
        game.winPoint(player1);
        assertThat(game.score(), is(String.format("%s %s", Points.FIFTEEN, Points.LOVE)));
    }

    @Test public void
    have_score_love_fifteen_when_player2_win_a_point() {
        game.winPoint(player2);
        assertThat(game.score(), is(String.format("%s %s", Points.LOVE, Points.FIFTEEN)));
    }

}
