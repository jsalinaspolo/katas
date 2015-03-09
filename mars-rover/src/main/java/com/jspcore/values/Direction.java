package com.jspcore.values;

public enum Direction implements Rotation, Move {
    NORTH("N") {
        @Override
        public Direction rotateWith(Command command) {
            if (Command.LEFT == command) return WEST;
            if (Command.RIGHT == command) return EAST;
            return this;
        }

        @Override
        public Coordinate move(Coordinate coordinate) {
            return coordinate.moveForward();
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
        public Coordinate move(Coordinate coordinate) {
            return coordinate.moveRight();
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
        public Coordinate move(Coordinate coordinate) {
            return coordinate.moveBackward();
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
        public Coordinate move(Coordinate coordinate) {
            return coordinate.moveLeft();
        }
    };

    public String value;

    Direction(String value) {
        this.value = value;
    }

    public Direction invested() {
        return Direction.values()[(ordinal() + Direction.values().length / 2) % Direction.values().length];
    }
}

interface Rotation {
    Direction rotateWith(Command command);
}

interface Move {
    Coordinate move(Coordinate coordinate);
}
