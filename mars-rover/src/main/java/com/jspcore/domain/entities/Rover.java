package com.jspcore.domain.entities;

import com.jspcore.domain.values.*;

import java.util.Collections;

public class Rover {
    private Coordinate startPoint;
    private Terrain terrain;
    private Direction direction;
    private boolean collided;

    public Rover(Terrain terrain, Direction direction) {
        this.startPoint = terrain.coordinate();
        this.direction = direction;
        this.terrain = terrain;
    }

    public Direction facing() {
        return this.direction;
    }

    public Coordinate startPoint() {
        return this.startPoint;
    }

    public Coordinate position() {
        return this.terrain.coordinate();
    }

    public boolean isCollided() {
        return this.collided;
    }

    private void rotate(Command command) {
        direction = direction.rotateWith(command);
    }

    public void commands(String commands) {
        commands.chars()
                .mapToObj(i -> (char) i)
                .filter(command -> command(command))
                .findFirst();
    }

    public boolean command(char command) {
        if (Command.LEFT.command() == command) rotate(Command.LEFT);
        else if (Command.RIGHT.command() == command) rotate(Command.RIGHT);
        else if (Command.FORWARD.command() == command) return moveForward();
        else if (Command.BACKWARD.command() == command) return moveBackward();
        else {
            throw new IllegalArgumentException("wrong command");
        }

        return false;
    }

    public boolean moveForward() {
        return move(direction);
    }

    public boolean moveBackward() {
        return move(direction.inverted());
    }

    private boolean move(Direction direction) {
        terrain = Terrain.create(direction.move(terrain), terrain.limit(), terrain.obstacles());
        if (terrain.isCollided()) collided = true;

        return collided;
    }

    public String displayPosition() {
        StringBuilder builder = new StringBuilder();
        builder.append(terrain.display());
        builder.append(" ");
        builder.append(direction.value);
        return builder.toString();
    }
}
