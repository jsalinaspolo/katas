package jspcore.com.domain.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Player {

    private int points;

    public static Player create(String name) {
        return new AutoValue_Player(name);
    }

    public abstract String name();

    public void winAPoint() {
        points = ++points;
    }

    public int points() {
        return points;
    }
}
