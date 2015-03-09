package com.jspcore.values;

public enum Command {

    LEFT("L"),
    RIGHT("R"),
    FORWARD("F"),
    BACKWARD("B");

    public String value;

    Command(String value) {
        this.value = value;
    }
}


