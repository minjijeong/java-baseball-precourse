package baseball.model.constant;

public enum JudgementType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String name;
    JudgementType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

