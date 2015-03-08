package com.jspcore.rover;

import com.jspcore.entity.Rover;
import com.jspcore.values.Coordinate;
import com.jspcore.values.Direction;
import com.jspcore.values.Point;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RoverShould {

    private Rover rover;

    @Before public void
    setUp() {
        final Coordinate startingPoint = new Coordinate(new Point(3), new Point(4));

        rover = new Rover(startingPoint, Direction.N);
    }

    @Test public void
    init_rover() {
        assertThat(rover.startPoint().x(), is(3));
        assertThat(rover.startPoint().y(), is(4));
        assertThat(rover.facing(), is(Direction.N));
    }
}
