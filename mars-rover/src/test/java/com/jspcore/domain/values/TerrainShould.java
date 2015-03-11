package com.jspcore.domain.values;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TerrainShould {

    final Point x = Point.create(2);
    final Point y = Point.create(3);

    final Point xLimit = Point.create(9);
    final Point yLimit = Point.create(9);
    
    Terrain terrain;
    
    @Before public void
    setUp() {
        terrain = Terrain.create(Coordinate.create(x, y), Coordinate.create(xLimit, yLimit), Obstacles.empty());
    }

    @Test public void
    equality() {
        assertThat(Coordinate.create(x,y), equalTo(Coordinate.create(x,y)));
    }

    @Test public void
    increase_y_when_move_forward() {
        assertThat(terrain.moveForward(), equalTo(Coordinate.create(x, y.increase())));
    }

    @Test public void
    decrease_y_when_move_backward() {
        assertThat(terrain.moveBackward(), equalTo(Coordinate.create(x, y.decrease())));
    }

    @Test public void
    increase_x_when_move_right() {
        assertThat(terrain.moveRight(), equalTo(Coordinate.create(x.increase(), y)));
    }

    @Test public void
    decrease_x_when_move_left() {
        assertThat(terrain.moveLeft(), equalTo(Coordinate.create(x.decrease(), y)));
    }

    @Test public void
    move_forward_from_an_edge_when_out_of_the_terrain() {
        Terrain terrain = Terrain.create(Coordinate.create(xLimit, yLimit), Coordinate.create(xLimit, yLimit), Obstacles.empty());
        assertThat(terrain.moveForward(), equalTo(Coordinate.create(xLimit, Point.create(0))));
    }

    @Test public void
    move_backward_from_an_edge_when_out_of_the_terrain() {
        Terrain terrain = Terrain.create(Coordinate.create(xLimit, Point.create(0)), Coordinate.create(xLimit, yLimit), Obstacles.empty());
        assertThat(terrain.moveBackward(), equalTo(Coordinate.create(xLimit, yLimit)));
    }

    @Test public void
    move_right_from_an_edge_when_out_of_the_terrain() {
        Terrain terrain = Terrain.create(Coordinate.create(xLimit, yLimit), Coordinate.create(xLimit, yLimit), Obstacles.empty());
        assertThat(terrain.moveRight(), equalTo(Coordinate.create(Point.create(0), yLimit)));
    }

    @Test public void
    move_left_from_an_edge_when_out_of_the_terrain() {
        Terrain terrain = Terrain.create(Coordinate.create(Point.create(0), yLimit), Coordinate.create(xLimit, yLimit), Obstacles.empty());
        assertThat(terrain.moveLeft(), equalTo(Coordinate.create(xLimit, yLimit)));
    }


}
