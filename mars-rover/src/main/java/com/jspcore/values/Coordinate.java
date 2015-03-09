package com.jspcore.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Coordinate {

    public static Coordinate create(Point x, Point y) {
        return new AutoValue_Coordinate(x, y);
    }

    public abstract Point x();

    public abstract Point y();

    public Coordinate moveForward() {
        return Coordinate.create(x(), y().increase());
    }

    public Coordinate moveBackward() {
        return Coordinate.create(x(), y().decrease());
    }

    public Coordinate moveLeft() {
        return Coordinate.create(x().decrease(), y());
    }

    public Coordinate moveRight() {
        return Coordinate.create(x().increase(), y());
    }

    public String display() {
        StringBuilder builder = new StringBuilder();
        builder.append(x().display());
        builder.append(" ");
        builder.append(y().display());
        return builder.toString();
    }
}
