package com.jspcore.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Point {
    public static Point create(int location) {
        return new AutoValue_Point(location);
    }

    public abstract int location();
}
