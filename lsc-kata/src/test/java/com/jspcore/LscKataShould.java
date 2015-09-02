package com.jspcore;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LscKataShould {

    @Test public void
    passing_sum() {
        assertThat(1 + 1, is(2));
    }

    @Test @Ignore public void
    failing_sum() {
        assertThat(1 + 1, is(3));
    }
}
