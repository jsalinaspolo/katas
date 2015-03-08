package com.jspcore.values;

public final class Coordinate {

    private final Point x;
    private final Point y;

    public Coordinate(Point x, Point y) {
        this.x = x;
        this.y = y;
    }

    public int x() { return this.x.location(); }
    public int y() { return this.y.location(); }
}
