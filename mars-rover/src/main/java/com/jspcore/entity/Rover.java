package com.jspcore.entity;

import com.jspcore.values.Coordinate;
import com.jspcore.values.Direction;

public class Rover {

    private Coordinate startPoint;
    private Direction direction;

    public Rover(Coordinate coordinate, Direction direction) {
        this.startPoint = coordinate;
        this.direction = direction;
    }

    public Direction facing() { return this.direction; }
    public Coordinate startPoint() { return this.startPoint; }
}
