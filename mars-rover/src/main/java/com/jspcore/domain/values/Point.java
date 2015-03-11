package com.jspcore.domain.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Point {
    public static Point create(int location) {
        return new AutoValue_Point(location);
    }

    public abstract int location();

    public Point increase() {
        return Point.create(location() + 1);
    }

    public Point increase(Point limit) {
        return Point.create(increase().location() % limit.increase().location());
    }

    public Point decrease() {
        return Point.create(location() - 1);
    }

    public Point decrease(Point limit) {
        if (location() <= 0) return limit;
        return decrease();
    }

    public String display() { return String.valueOf(location()); }
}
