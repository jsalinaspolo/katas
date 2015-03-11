package com.jspcore.domain.values;

public enum Command {

    LEFT("L"),
    RIGHT("R"),
    FORWARD("F"),
    BACKWARD("B");

    public String value;

    Command(String value) {
        this.value = value;
    }

    public final char command() { return this.value.charAt(0); }
}


