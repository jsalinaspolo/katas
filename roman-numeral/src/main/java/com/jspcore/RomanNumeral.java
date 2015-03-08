package com.jspcore;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {

    public static String romanFrom(int number) {
        if (number == 5) return "V";
        return IntStream.iterate(number, i -> i - RomanToDecimal.applyTo(i).decimal)
                .limit(RomanToDecimal.values().length)
                .filter(i -> i > 0)
                .mapToObj(i -> RomanToDecimal.applyTo(i).name())
                .collect(Collectors.joining());
    }

    enum RomanToDecimal {
        M(1000), CM(900),
        D(500), CD(400),
        C(100), XC(90),
        L(50), XL(40),
        X(10), IX(9),
        V(5), IV(4),
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
