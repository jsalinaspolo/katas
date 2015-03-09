package com.jspcore.values;

public enum Direction {

    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    public String value;

    Direction(String value) {
        this.value = value;
    }
}
