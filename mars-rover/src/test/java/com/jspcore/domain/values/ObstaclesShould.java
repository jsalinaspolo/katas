package com.jspcore.domain.values;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ObstaclesShould {

    private final Point x = Point.create(2);
    private final Point y = Point.create(3);

    private Obstacles obstacles;
    
    @Before public void
    setUp() {
        obstacles = Obstacles.create(Arrays.asList(Coordinate.create(x,y)));
    }

    @Test public void
    collision_when_on_the_same_coordinates() {
        assertThat(obstacles.isCollision(Coordinate.create(x,y)), is(true));
    }

    @Test public void
    not_collision_when_not_in_coordinates_of_an_obstacle() {
        assertThat(obstacles.isCollision(Coordinate.create(x.increase(), y)), is(false));
    }

    @Test public void
    equality() {
        assertThat(Obstacles.create(Arrays.asList(Coordinate.create(x,y))), equalTo(Obstacles.create(Arrays.asList(Coordinate.create(x,y)))));
    }
}
