package com.jspcore.values;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DirectionShould {

    @Test public void
    north_direction_from_value() {
        assertThat(Direction.valueOf("NORTH"), is(Direction.NORTH));
    }

    @Test(expected = IllegalArgumentException.class) public void
    throws_exception_when_invalid_direction() {
        assertThat(Direction.valueOf("M"), is(Direction.NORTH));
    }

    @Test public void
    be_south_when_invert_direction_of_north() {
        assertThat(Direction.NORTH.inverted(), is(Direction.SOUTH));
    }

    @Test public void
    be_north_when_invert_direction_of_south() {
        assertThat(Direction.SOUTH.inverted(), is(Direction.NORTH));
    }

    @Test public void
    be_west_when_invert_direction_of_east() {
        assertThat(Direction.EAST.inverted(), is(Direction.WEST));
    }

    @Test public void
    be_east_when_invert_direction_of_west() {
        assertThat(Direction.WEST.inverted(), is(Direction.EAST));
    }

    @Test public void
    be_west_when_rotate_left_of_north() {
        assertThat(Direction.NORTH.rotateWith(Command.LEFT), is(Direction.WEST));
    }

    @Test public void
    be_east_when_rotate_right_of_north() {
        assertThat(Direction.NORTH.rotateWith(Command.RIGHT), is(Direction.EAST));
    }

    @Test public void
    be_north_when_rotate_left_of_east() {
        assertThat(Direction.EAST.rotateWith(Command.LEFT), is(Direction.NORTH));
    }

    @Test public void
    be_south_when_rotate_right_of_east() {
        assertThat(Direction.EAST.rotateWith(Command.RIGHT), is(Direction.SOUTH));
    }

    @Test public void
    be_east_when_rotate_left_of_south() {
        assertThat(Direction.SOUTH.rotateWith(Command.LEFT), is(Direction.EAST));
    }

    @Test public void
    be_west_when_rotate_right_of_south() {
        assertThat(Direction.SOUTH.rotateWith(Command.RIGHT), is(Direction.WEST));
    }

    @Test public void
    be_north_when_rotate_left_of_west() {
        assertThat(Direction.WEST.rotateWith(Command.LEFT), is(Direction.SOUTH));
    }

    @Test public void
    be_south_when_rotate_right_of_west() {
        assertThat(Direction.WEST.rotateWith(Command.RIGHT), is(Direction.NORTH));
    }


}
