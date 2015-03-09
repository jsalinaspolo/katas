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
    invert_north_to_south() {
        assertThat(Direction.NORTH.invert(), is(Direction.SOUTH));
    }

    @Test public void
    invert_south_to_north() {
        assertThat(Direction.SOUTH.invert(), is(Direction.NORTH));
    }

    @Test public void
    invert_east_to_west() {
        assertThat(Direction.EAST.invert(), is(Direction.WEST));
    }

    @Test public void
    invert_westto_east() {
        assertThat(Direction.WEST.invert(), is(Direction.EAST));
    }

}
