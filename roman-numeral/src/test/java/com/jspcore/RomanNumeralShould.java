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
        assertThat(RomanNumeral.romanFrom(4), is("IV"));
        assertThat(RomanNumeral.romanFrom(5), is("V"));
        assertThat(RomanNumeral.romanFrom(6), is("VI"));
        assertThat(RomanNumeral.romanFrom(8), is("VIII"));
        assertThat(RomanNumeral.romanFrom(9), is("IX"));
        assertThat(RomanNumeral.romanFrom(10), is("X"));
        assertThat(RomanNumeral.romanFrom(16), is("XVI"));
        assertThat(RomanNumeral.romanFrom(51), is("LI"));
        assertThat(RomanNumeral.romanFrom(92), is("XCII"));
        assertThat(RomanNumeral.romanFrom(103), is("CIII"));
        assertThat(RomanNumeral.romanFrom(407), is("CDVII"));
        assertThat(RomanNumeral.romanFrom(507), is("DVII"));
        assertThat(RomanNumeral.romanFrom(909), is("CMIX"));
        assertThat(RomanNumeral.romanFrom(3387), is("MMMCCCLXXXVII"));
    }
}
