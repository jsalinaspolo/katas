package com.jspcore.domain.values;

import com.jspcore.domain.entities.Rover;

public enum Direction implements Rotation, Movement {
    NORTH("N") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return WEST;
            if (Command.RIGHT == command) return EAST;
            return this;
        }

        @Override
        public Coordinate move(Rover rover) {
            return rover.moveUp();
        }
    },
    EAST("E") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return NORTH;
            if (Command.RIGHT == command) return SOUTH;
            return this;
        }

        @Override
        public Coordinate move(Rover rover) {
            return rover.moveRight();
        }
    },
    SOUTH("S") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return EAST;
            if (Command.RIGHT == command) return WEST;
            return this;
        }

        @Override
        public Coordinate move(Rover rover) {
            return rover.moveDown();
        }
    },
    WEST("W") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return SOUTH;
            if (Command.RIGHT == command) return NORTH;
            return this;
        }

        @Override
        public Coordinate move(Rover rover) {
            return rover.moveLeft();
        }
    };

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String value() { return this.value; }

    public Direction inverted() {
        return Direction.values()[(ordinal() + Direction.values().length / 2) % Direction.values().length];
    }
}

interface Rotation {
    Direction rotateWith(Command command);
}

interface Movement {
    Coordinate move(Rover rover);
}
