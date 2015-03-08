package com.jspcore;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {

    public static String romanFrom(int number) {
        if (number == 5) return "V";
        return IntStream.iterate(number, i -> i - RomanToDecimal.applyTo(i).decimal)
                .limit(number)
                .filter(i -> i > 0)
                .mapToObj(i -> RomanToDecimal.applyTo(i).name())
                .collect(Collectors.joining());
    }

    enum RomanToDecimal {
        X(10),
        V(5),
        I(1);

        int decimal;

        RomanToDecimal(int decimal) {
            this.decimal = decimal;
        }

        public static RomanToDecimal applyTo(int number) {
            return Collections.unmodifiableCollection(Arrays.asList(RomanToDecimal.values())).stream()
                    .filter(roman -> number >= roman.decimal)
                    .findFirst()
                    .orElse(I);
        }
    }
}
