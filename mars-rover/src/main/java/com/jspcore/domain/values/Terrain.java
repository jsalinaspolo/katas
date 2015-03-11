package com.jspcore.domain.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Terrain {

    public static Terrain create(Coordinate coordinate, Coordinate limit) {
        return new AutoValue_Terrain(coordinate, limit);
    }

    public abstract Coordinate coordinate();

    public abstract Coordinate limit();

    public Coordinate moveForward() {
        return Coordinate.create(coordinate().x(), coordinate().y().increase(limit().y()));
    }

    public Coordinate moveBackward() {
        return Coordinate.create(coordinate().x(), coordinate().y().decrease(limit().y()));
    }

    public Coordinate moveLeft() {
        return Coordinate.create(coordinate().x().decrease(limit().x()), coordinate().y());
    }

    public Coordinate moveRight() {
        return Coordinate.create(coordinate().x().increase(limit().x()), coordinate().y());
    }

    public String display() {
        StringBuilder builder = new StringBuilder();
        builder.append(coordinate().display());
        return builder.toString();
    }
}
