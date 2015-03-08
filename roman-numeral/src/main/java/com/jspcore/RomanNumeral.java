package com.jspcore;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {

    public static String romanFrom(int number) {
        if(number == 5) return "V";
        return IntStream.iterate(number, (i -> i - (i >= 5 ? 5 : 1)))
                .limit(number)
                .filter(i -> i > 0)
                .mapToObj(i -> i >= 5 ? "V" : "I")
                .collect(Collectors.joining());
    }
}
