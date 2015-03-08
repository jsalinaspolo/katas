package com.jspcore;

public class FizzyBuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public static String of(int number) {
        if (number % 15 == 0) return FIZZ + BUZZ;
        else if (number % 3 == 0) return FIZZ;
        else if (number % 5 == 0) return BUZZ;
        return Integer.toString(number);
    }
}
