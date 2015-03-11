package com.jspcore.domain.values;

import jspcore.com.domain.values.Points;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PointsShould {

    @Test public void
    zero_when_score_is_love() {
        assertThat(Points.LOVE.score(), is(0));
    }

    @Test public void
    one_when_score_is_fifteen() {
            assertThat(Points.FIFTEEN.score(), is(1));
    }

    @Test public void
    two_when_score_is_thirty() {
        assertThat(Points.THIRTY.score(), is(2));
    }

    @Test public void
    three_when_score_is_forty() {
        assertThat(Points.FORTY.score(), is(3));
    }
}
