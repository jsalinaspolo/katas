package com.jspcore.domain.entities;

import com.jspcore.domain.values.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class RoverShould {

    private Rover rover;
    private final Point x = Point.create(3);
    private final Point y = Point.create(4);
    private final Point xLimit = Point.create(9);
    private final Point yLimit = Point.create(9);

    @Before public void
    setUp() {
        final World world = new World(Coordinate.create(xLimit, yLimit), Obstacles.empty());
        rover = new Rover(world, Coordinate.create(x, y), Direction.NORTH);
    }

    @Test public void
    init_rover_with_coordinates_and_direction() {
        assertThat(rover.startPoint().x().location(), is(3));
        assertThat(rover.startPoint().y().location(), is(4));
        assertThat(rover.facing(), is(Direction.NORTH));
    }

    @Test public void
    increase_y_when_move_forward_and_north() {
        rover.command(Command.FORWARD.command());
        assertThat(rover.position(), equalTo(Coordinate.create(
                Point.create(rover.startPoint().x().location()), Point.create(rover.startPoint().y().location() + 1))));
    }

    @Test public void
    turn_left_when_command_left() {
        rover.command(Command.LEFT.command());
        assertThat(rover.facing(), equalTo(Direction.WEST));
    }

    @Test public void
    turn_right_when_command_right() {
        rover.command(Command.RIGHT.command());
        assertThat(rover.facing(), equalTo(Direction.EAST));
    }

    @Test public void
    move_up_when_command_forward_and_facing_north() {
        rover.command(Command.FORWARD.command());
        assertThat(rover.position(), is(Coordinate.create(x, y.increase())));
    }

    @Test public void
    move_down_when_command_backward_and_facing_north() {
        rover.command(Command.BACKWARD.command());
        assertThat(rover.position(), is(Coordinate.create(x, y.decrease())));
    }

    @Test(expected = IllegalArgumentException.class) public void
    throws_exception_when_wrong_command() {
        rover.command('c');
    }

    @Test public void
    move_up_twice_and_rotate_when_commands_FFL() {
        rover.commands("FFL");
        assertThat(rover.position(), is(Coordinate.create(x, y.increase().increase())));
        assertThat(rover.facing(), is(Direction.WEST));
    }

    @Test public void
    move_and_rotate_according_commands_FFLFFLBBRFFL() {
        rover.commands("FFLFFLBBRFFLFFLFFL");
        assertThat(rover.position(), is(Coordinate.create(x.decrease().decrease().decrease().decrease().increase().increase(), y.increase().increase().increase().increase().decrease().decrease())));
        assertThat(rover.facing(), is(Direction.NORTH));
    }

    @Test public void
    display_position_in_format_X_Y_Direction() {
        assertThat(rover.displayPosition(), equalTo("3 4 N"));
    }

    @Test public void
    move_from_an_edge_of_the_world_to_another() {
        rover.commands("FFFFFF");
        assertThat(rover.displayPosition(), is("3 0 N"));
    }

    @Test public void
    collided_with_an_obstacle_and_stop_when_collision() {
        final Point xLimit = Point.create(9);
        final Point yLimit = Point.create(9);

        final World world = new World(Coordinate.create(xLimit, yLimit),
                Obstacles.create(Arrays.asList(
                        Coordinate.create(x.decrease(), y.decrease()),
                        Coordinate.create(x, y.increase()))));
        Rover rover = new Rover(world, Coordinate.create(x, y), Direction.NORTH);
        rover.commands("FFF");
        assertThat(rover.displayPosition(), is("3 5 N"));
        assertThat(rover.isCollided(), is(true));
    }

    @Test public void
    increase_y_when_move_forward() {
        Assert.assertThat(rover.moveUp(), equalTo(Coordinate.create(x, y.increase())));
    }

    @Test public void
    decrease_y_when_move_backward() {
        Assert.assertThat(rover.moveDown(), equalTo(Coordinate.create(x, y.decrease())));
    }

    @Test public void
    increase_x_when_move_right() {
        Assert.assertThat(rover.moveRight(), equalTo(Coordinate.create(x.increase(), y)));
    }

    @Test public void
    decrease_x_when_move_left() {
        Assert.assertThat(rover.moveLeft(), equalTo(Coordinate.create(x.decrease(), y)));
    }

    @Test public void
    move_forward_from_an_edge_when_out_of_the_terrain() {
        World world = new World(Coordinate.create(xLimit, yLimit), Obstacles.empty());
        Rover rover = new Rover(world, Coordinate.create(xLimit, yLimit), Direction.NORTH);
        Assert.assertThat(rover.moveUp(), equalTo(Coordinate.create(xLimit, Point.create(0))));
    }

    @Test public void
    move_backward_from_an_edge_when_out_of_the_terrain() {
        World world = new World(Coordinate.create(xLimit, yLimit), Obstacles.empty());
        Rover rover = new Rover(world, Coordinate.create(xLimit, Point.create(0)), Direction.NORTH);
        Assert.assertThat(rover.moveDown(), equalTo(Coordinate.create(xLimit, yLimit)));
    }

    @Test public void
    move_right_from_an_edge_when_out_of_the_terrain() {
        World world = new World(Coordinate.create(xLimit, yLimit), Obstacles.empty());
        Rover rover = new Rover(world, Coordinate.create(xLimit, yLimit), Direction.NORTH);
        Assert.assertThat(rover.moveRight(), equalTo(Coordinate.create(Point.create(0), yLimit)));
    }

    @Test public void
    move_left_from_an_edge_when_out_of_the_terrain() {
        World world = new World(Coordinate.create(xLimit, yLimit), Obstacles.empty());
        Rover rover = new Rover(world, Coordinate.create(Point.create(0), yLimit), Direction.NORTH);
        Assert.assertThat(rover.moveLeft(), equalTo(Coordinate.create(xLimit, yLimit)));
    }
}
