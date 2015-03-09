package com.jspcore.entity;

import com.jspcore.values.Command;
import com.jspcore.values.Coordinate;
import com.jspcore.values.Direction;
import com.jspcore.values.Point;

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

    public void command(Command command) {
        move();
    }

    public void move() {
        switch (direction) {
            case NORTH:
                moveTo(position().x(), position().y() + speed());
                break;
            case SOUTH:
                break;
            case EAST:
                break;
            case WEST:
                break;
        }
    }

    private void moveTo(int x, int y) {
        position = Coordinate.create(Point.create(x), Point.create(y));
    }

    private int speed() {
        return SQUARES_SPEED;
    }
}
