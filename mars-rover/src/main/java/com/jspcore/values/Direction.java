package com.jspcore.values;

public enum Direction {

    N("NORTH"),
    S("SOUTH"),
    E("EAST"),
    W("WEST");

    public String value;

    Direction(String value) {
        this.value = value;
    }
}
