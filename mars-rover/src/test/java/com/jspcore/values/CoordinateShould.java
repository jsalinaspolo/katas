package com.jspcore.values;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CoordinateShould {

    final Point x = Point.create(2);
    final Point y = Point.create(3);

    @Test public void
    x_when_get_x_coordinates_from_a_point() {
        assertThat(Coordinate.create(x, y).x(), is(2));
    }

    @Test public void
    y_when_get_y_coordinates_from_a_point() {
        assertThat(Coordinate.create(x, y).y(), is(3));
    }

    @Test public void
    equality() {
        assertThat(Coordinate.create(x,y), equalTo(Coordinate.create(x,y)));
    }
}
