package baseball.model.constant;

public class BaseballIllegalArgumentException extends IllegalArgumentException{
    private static final String MESSAGE = "야구게임 진행 도중 오류가 발생하였습니다.";

    public BaseballIllegalArgumentException() {
        this(MESSAGE);
    }

    public BaseballIllegalArgumentException(String message) {
        super(message);
    }
}
