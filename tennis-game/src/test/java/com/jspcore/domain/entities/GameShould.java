package com.jspcore.domain.entities;

import jspcore.com.domain.entities.Game;
import jspcore.com.domain.values.Player;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameShould {

    private Game game;

    @Before public void
    setUp() {
        game = new Game(Player.create("Javier"), Player.create("MuSTa1nE"));
    }

    @Test public void
    have_two_players() {
        assertThat(game.players(), is(2));
    }

}
