package jspcore.com.domain.values;

public enum Points {

    LOVE(0),
    FIFTEEN(1),
    THIRTY(2),
    FORTY(3);

    private int score;

    Points(int score) {
        this.score = score;
    }

    public int score() {
        return this.score;
    }
}
