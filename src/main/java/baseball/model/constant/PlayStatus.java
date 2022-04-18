package baseball.model.constant;

public enum PlayStatus {
    PLAYING,
    RESTART,
    EXIT,
    ETC,
    GAME_OVER;

    public static PlayStatus fromValue(String value) {
        if (value.equals("1")) {
            return RESTART;
        }
        if (value.equals("2")) {
            return EXIT;
        }
        return ETC;
    }
}

