package jspcore.com.domain.values;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Player {

    public static Player create(String name) {
        return new AutoValue_Player(name);
    }

    public abstract String name();
}
