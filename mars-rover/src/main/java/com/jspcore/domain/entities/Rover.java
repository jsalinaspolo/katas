package com.jspcore.domain.entities;

import com.jspcore.domain.values.Command;
import com.jspcore.domain.values.Coordinate;
import com.jspcore.domain.values.Direction;
import com.jspcore.domain.values.Terrain;

public class Rover {
    private Coordinate startPoint;
    private Terrain terrain;
    private Direction direction;

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

    private void rotate(Command command) {
        direction = direction.rotateWith(command);
    }

    public void commands(String commands) {
        commands.chars()
                .mapToObj(i -> (char) i)
                .forEach(command -> command(command));
    }

    public void command(char command) {
        if (Command.LEFT.command() == command) rotate(Command.LEFT);
        else if (Command.RIGHT.command() == command) rotate(Command.RIGHT);
        else if (Command.FORWARD.command() == command) moveForward();
        else if (Command.BACKWARD.command() == command) moveBackward();
        else {
            throw new IllegalArgumentException("wrong command");
        }
    }

    public void moveForward() {
        terrain = Terrain.create(direction.move(terrain), terrain.limit());
    }

    public void moveBackward() {
        terrain =  Terrain.create(direction.inverted().move(terrain), terrain.limit());
    }

    public String displayPosition() {
        StringBuilder builder = new StringBuilder();
        builder.append(terrain.display());
        builder.append(" ");
        builder.append(direction.value);
        return builder.toString();
    }
}
