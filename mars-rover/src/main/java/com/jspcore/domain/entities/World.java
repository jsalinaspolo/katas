package com.jspcore.domain.entities;

import com.jspcore.domain.values.Coordinate;
import com.jspcore.domain.values.Obstacles;

import java.util.Optional;

public class World {

    private Optional<Coordinate> rover;
    private final Coordinate limits;
    private final Obstacles obstacles;

    public World(Coordinate limit, Obstacles obstacles) {
        this.limits = limit;
        this.obstacles = obstacles;
        rover = Optional.empty();
    }

    public Coordinate roverPosition() { return rover.orElseThrow(IllegalStateException::new); }

    public Coordinate limit() { return this.limits; }

    public Obstacles obstacles() { return this.obstacles; }

    public boolean isCollided() {
        return obstacles().isCollision(roverPosition());
    }

    public void addRover(Coordinate coordinate) {
        rover = Optional.of(coordinate);
    }

    public void updateRover(Coordinate coordinate) {
        rover.orElseThrow(IllegalStateException::new);
        rover = Optional.of(coordinate);
    }

    public String display() {
        return roverPosition().display();
    }
}
