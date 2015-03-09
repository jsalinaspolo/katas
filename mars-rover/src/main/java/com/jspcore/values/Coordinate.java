package com.jspcore.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Coordinate {

    public static Coordinate create(Point x, Point y) {
        return new AutoValue_Coordinate(x.location(),y.location());
    }

    public abstract int x();
    public abstract int y();


}
