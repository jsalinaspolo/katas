package com.jspcore.values;

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
}
