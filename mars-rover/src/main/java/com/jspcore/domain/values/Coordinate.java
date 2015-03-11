package com.jspcore.domain.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Coordinate {

    public static Coordinate create(Point x, Point y) {
        return new AutoValue_Coordinate(x, y);
    }

    public abstract Point x();

    public abstract Point y();

    public String display() {
        return new StringBuilder()
                .append(x().display())
                .append(" ")
                .append(y().display())
                .toString();
    }
}
