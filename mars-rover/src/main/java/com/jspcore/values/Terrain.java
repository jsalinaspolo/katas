package com.jspcore.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Terrain {

    public static Terrain create(Coordinate coordinate, Coordinate limit) {
        return new AutoValue_Terrain(coordinate, limit);
    }

    public abstract Coordinate coordinate();

    public abstract Coordinate limit();

    public Coordinate moveForward() {
        return Coordinate.create(coordinate().x(), coordinate().y().increase());
    }

    public Coordinate moveBackward() {
        return Coordinate.create(coordinate().x(), coordinate().y().decrease());
    }

    public Coordinate moveLeft() {
        return Coordinate.create(coordinate().x().decrease(), coordinate().y());
    }

    public Coordinate moveRight() {
        return Coordinate.create(coordinate().x().increase(), coordinate().y());
    }

    public String display() {
        StringBuilder builder = new StringBuilder();
        builder.append(coordinate().display());
        return builder.toString();
    }
}
