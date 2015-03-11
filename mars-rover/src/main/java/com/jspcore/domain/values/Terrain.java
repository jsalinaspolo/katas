package com.jspcore.domain.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Terrain {

    public static Terrain create(Coordinate coordinate, Coordinate limit, Obstacles obstacles) {
        return new AutoValue_Terrain(coordinate, limit, obstacles);
    }

    public abstract Coordinate coordinate();

    public abstract Coordinate limit();

    public abstract Obstacles obstacles();

    public boolean isCollided() {
        return obstacles().isCollision(coordinate());
    }

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
        return coordinate().display();
    }
}
