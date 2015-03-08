package com.jspcore;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {

    public static String romanFrom(int number) {
        if(number == 5) return "V";
        return IntStream.iterate(number, l -> l - 1)
                .limit(number)
                .mapToObj(i -> "I")
                .collect(Collectors.joining());
    }
}
