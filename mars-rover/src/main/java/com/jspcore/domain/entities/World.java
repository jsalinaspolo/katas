package com.jspcore.domain.entities;

import com.jspcore.domain.values.Coordinate;
import com.jspcore.domain.values.Obstacles;

public class World {

    private Coordinate rover;
    private final Coordinate limits;
    private final Obstacles obstacles;

    public World(Coordinate limit, Obstacles obstacles) {
        this.limits = limit;
        this.obstacles = obstacles;
    }

    public Coordinate roverPosition() { return this.rover; }

    public Coordinate limit() { return this.limits; }

    public Obstacles obstacles() { return this.obstacles; }

    public boolean isCollided() {
        return obstacles().isCollision(roverPosition());
    }

    public void updateRover(Coordinate coordinate) {
        this.rover = coordinate;
    }

    public String display() {
        return roverPosition().display();
    }
}
