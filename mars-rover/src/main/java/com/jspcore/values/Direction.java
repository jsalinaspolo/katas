package com.jspcore.values;

public enum Direction implements Rotation {

    NORTH("N") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return WEST;
            if (Command.RIGHT == command) return EAST;
            return this;
        }
    },
    SOUTH("S") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return EAST;
            if (Command.RIGHT == command) return WEST;
            return this;
        }
    },
    EAST("E") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return NORTH;
            if (Command.RIGHT == command) return SOUTH;
            return this;
        }
    },
    WEST("W") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return SOUTH;
            if (Command.RIGHT == command) return NORTH;
            return this;
        }
    };

    public String value;

    Direction(String value) {
        this.value = value;
    }
}

interface Rotation {
    Direction rotateWith(Command command);
}
