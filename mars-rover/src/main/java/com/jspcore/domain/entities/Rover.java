package com.jspcore.domain.entities;

import com.jspcore.domain.values.Command;
import com.jspcore.domain.values.Coordinate;
import com.jspcore.domain.values.Direction;

public class Rover {
    private final Coordinate startPoint;
    private final World world;
    private Direction direction;
    private boolean collided;

    public Rover(World world, Coordinate coordinate, Direction direction) {
        this.startPoint = coordinate;
        this.direction = direction;
        this.world = world;
        addRover(coordinate);
    }

    public Direction facing() {
        return this.direction;
    }

    public Coordinate startPoint() {
        return this.startPoint;
    }

    public Coordinate position() {
        return this.world.roverPosition();
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
                .filter(this::command)
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
        updatePosition(direction.move(this));
        if (world.isCollided()) collided = true;
        return collided;
    }

    public Coordinate moveUp() {
        return Coordinate.create(position().x(), position().y().increase(world.limit().y()));
    }

    public Coordinate moveDown() {
        return Coordinate.create(position().x(), position().y().decrease(world.limit().y()));
    }

    public Coordinate moveLeft() {
        return Coordinate.create(position().x().decrease(world.limit().x()), position().y());
    }

    public Coordinate moveRight() {
        return Coordinate.create(position().x().increase(world.limit().x()), position().y());
    }

    public String displayPosition() {
        return new StringBuilder()
                .append(world.display())
                .append(" ")
                .append(direction.value())
                .toString();
    }

    private void addRover(Coordinate position) {
        this.world.addRover(position);
    }

    private void updatePosition(Coordinate position) {
        this.world.updateRover(position);
    }
}


