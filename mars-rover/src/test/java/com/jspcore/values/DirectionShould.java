package com.jspcore.values;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DirectionShould {

    @Test public void
    north_direction_from_value() {
        assertThat(Direction.valueOf("N"), is(Direction.N));
    }

    @Test(expected = IllegalArgumentException.class) public void
    throws_exception_when_invalid_direction() {
        assertThat(Direction.valueOf("M"), is(Direction.N));
    }
}
