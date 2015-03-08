package com.jspcore;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FizzyBuzzShould {

    @Test public void
    fizz_when_number_is_dividable_by_3() {
        assertThat(FizzyBuzz.of(3), is("fizz"));
    }

    @Test public void
    buzz_when_number_is_dividable_by_5() {
        assertThat(FizzyBuzz.of(5), is("buzz"));
    }

    @Test public void
    fizzbuzz_when_number_is_dividable_by_15() {
        assertThat(FizzyBuzz.of(15), is("fizzbuzz"));
    }

    @Test public void
    number_when_number_is_not_fulfilled() {
        assertThat(FizzyBuzz.of(16), is("16"));
    }
}
