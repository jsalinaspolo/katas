package com.jspcore.values;

public final class Point {

    private final Axis x;
    private final Axis y;

    public Point(int x, int y) {
        this.x = new Axis(x);
        this.y = new Axis(y);
    }

    public int x() { return this.x.value(); }
    public int y() { return this.y.value(); }
}
