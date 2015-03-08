package com.jspcore;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RomanNumeralShould {

    @Test public void
    generate_roman_numerals_from_a_decimal_number() {
        assertThat(RomanNumeral.romanFrom(1), is("I"));
        assertThat(RomanNumeral.romanFrom(2), is("II"));
        assertThat(RomanNumeral.romanFrom(3), is("III"));
        assertThat(RomanNumeral.romanFrom(5), is("V"));
        assertThat(RomanNumeral.romanFrom(6), is("VI"));
        assertThat(RomanNumeral.romanFrom(8), is("VIII"));
        assertThat(RomanNumeral.romanFrom(10), is("X"));
        assertThat(RomanNumeral.romanFrom(16), is("XVI"));

    }
}
