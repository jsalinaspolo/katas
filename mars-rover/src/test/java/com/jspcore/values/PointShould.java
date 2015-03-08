package com.jspcore.values;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointShould {

    @Test public void
    x_when_get_x_coordinates_from_a_point() {
        assertThat(new Point(2,3).x(), is(2));
    }

    @Test public void
    y_when_get_y_coordinates_from_a_point() {
        assertThat(new Point(2,3).y(), is(3));
    }

}
