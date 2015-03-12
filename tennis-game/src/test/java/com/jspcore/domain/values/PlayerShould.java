package com.jspcore.domain.values;

import jspcore.com.domain.values.Player;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    private Player player;

    @Before public void
    setUp() {
        player = Player.create("Javier");
    }

    @Test public void
    have_one_point_when_win_a_point() {
        player.winAPoint();
        assertThat(player.points(), is(1));
    }
}
