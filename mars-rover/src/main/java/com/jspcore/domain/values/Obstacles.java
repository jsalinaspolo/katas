package com.jspcore.domain.values;

import com.google.auto.value.AutoValue;

import java.util.Collection;
import java.util.Collections;

@AutoValue
public abstract class Obstacles {

    public static Obstacles create(Collection<Coordinate> obstacles) {
        return new AutoValue_Obstacles(obstacles);
    }

    public abstract Collection<Coordinate> obstacles();

    public static Obstacles empty() {
        return Obstacles.create(Collections.emptyList());
    }

    public boolean isCollision(Coordinate coordinate) {
        return obstacles().stream()
                .filter(obstacle -> obstacle.equals(coordinate))
                .findFirst()
                .isPresent();
    }



}
