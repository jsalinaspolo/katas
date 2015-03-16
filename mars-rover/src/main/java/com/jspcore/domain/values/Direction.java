package com.jspcore.domain.values;

import com.jspcore.domain.entities.Rover;

public enum Direction implements Movement {
    NORTH("N") {
        @Override
        public Coordinate move(Rover rover) {
            return rover.moveUp();
        }
    },
    EAST("E") {
        @Override
        public Coordinate move(Rover rover) {
            return rover.moveRight();
        }
    },
    SOUTH("S") {
        @Override
        public Coordinate move(Rover rover) {
            return rover.moveDown();
        }
    },
    WEST("W") {
        @Override
        public Coordinate move(Rover rover) {
            return rover.moveLeft();
        }
    };

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public Direction inverted() {
        return Direction.values()[(ordinal() + Direction.values().length / 2) % Direction.values().length];
    }

    public Direction rotateWith(Command command) {
        if (Command.LEFT == command)
            return Direction.values()[(Direction.values().length + ordinal() - 1) % Direction.values().length];
        if (Command.RIGHT == command)
            return Direction.values()[(Direction.values().length + ordinal() + 1) % Direction.values().length];
        throw new IllegalArgumentException("Command not valid");
    }
}

interface Movement {
    Coordinate move(Rover rover);
}
