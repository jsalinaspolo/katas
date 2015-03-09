package com.jspcore.entity;

import com.jspcore.values.Command;
import com.jspcore.values.Coordinate;
import com.jspcore.values.Direction;

public class Rover {
    private final int SQUARES_SPEED = 1;

    private Coordinate startPoint;
    private Coordinate position;
    private Direction direction;

    public Rover(Coordinate coordinate, Direction direction) {
        this.startPoint = coordinate;
        this.direction = direction;
        this.position = coordinate;
    }

    public Direction facing() {
        return this.direction;
    }

    public Coordinate startPoint() {
        return this.startPoint;
    }

    public Coordinate position() {
        return this.position;
    }

    private void rotate(Command command) {
        direction = direction.rotateWith(command);
    }

    public void command(char command) {
        if (Command.LEFT.command() == command) rotate(Command.LEFT);
        else if (Command.RIGHT.command() == command) rotate(Command.RIGHT);
        else if (Command.FORWARD.command() == command) moveForward();
        else if (Command.BACKWARD.command() == command) moveBackward();
        else {
            throw new IllegalArgumentException("wrong command");
        }
    }

    public void moveForward() {
        position = direction.move(position);
    }

    public void moveBackward() {
        position = direction.invested().move(position);
    }
}
