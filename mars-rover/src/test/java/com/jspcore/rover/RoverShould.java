package com.jspcore.rover;

import com.jspcore.entity.Rover;
import com.jspcore.values.Command;
import com.jspcore.values.Coordinate;
import com.jspcore.values.Direction;
import com.jspcore.values.Point;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class RoverShould {

    private Rover rover;

    @Before public void
    setUp() {
        final Coordinate startingPoint = Coordinate.create(Point.create(3), Point.create(4));
        rover = new Rover(startingPoint, Direction.NORTH);
    }

    @Test public void
    init_rover_with_coordinates_and_direction() {
        assertThat(rover.startPoint().x(), is(3));
        assertThat(rover.startPoint().y(), is(4));
        assertThat(rover.facing(), is(Direction.NORTH));
    }

    @Test public void
    increase_y_when_move_forward_and_north() {
        rover.command(Command.FORWARD);
        assertThat(rover.position(), equalTo(Coordinate.create(
                Point.create(rover.startPoint().x()), Point.create(rover.startPoint().y() + 1))));
    }
}
