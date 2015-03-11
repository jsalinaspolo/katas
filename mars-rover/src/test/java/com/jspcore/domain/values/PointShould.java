package com.jspcore.domain.values;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PointShould {

    @Test public void
    location_when_init_point() {
        assertThat(Point.create(2).location(), is(2));
    }

    @Test public void
    equality() {
        assertThat(Point.create(2), equalTo(Point.create(2)));
    }

    @Test public void
    increase() {
        assertThat(Point.create(3).increase(), equalTo(Point.create(4)));
    }

    @Test public void
    decrease() {
        assertThat(Point.create(3).decrease(), equalTo(Point.create(2)));
    }

    @Test public void
    increase_when_is_on_the_edge() {
        final Point point = Point.create(3);
        assertThat(point.increase(point), equalTo(Point.create(0)));
    }

    @Test public void
    decrease_when_is_on_the_min_edge() {
        final Point limit = Point.create(9);
        assertThat(Point.create(0).decrease(limit), equalTo(limit));
    }
}
