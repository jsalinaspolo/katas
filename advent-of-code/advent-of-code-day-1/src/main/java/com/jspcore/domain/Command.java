package com.jspcore.domain;

import java.util.HashMap;
import java.util.Map;

public enum Command implements Processor {
    UP("(") {
        @Override public int move() {
            return 1;
        }
    },
    DOWN(")") {
        @Override public int move() {
            return -1;
        }
    };

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String command() {
        return command;
    }

    private static Map<String, Command> lookup = new HashMap<>();

    static {
        for (Command value : values()) {
            lookup.put(value.command(), value);
        }
    }

    public static Command from(String command) {
        return lookup.get(command);
    }


}
