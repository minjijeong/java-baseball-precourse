package baseball.model.constant;

public enum BettingMessage {
    ASK_NUMBER("숫자를 입력해 주세요 : "),
    ASK_NEXT_STEP("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESULT_SUCESS("3개의 숫자를 모두 맞히셨습니다! 게임종료"),

    RESULT_BALL("%볼"),

    RESULT_STRIKE("%스트라이크");

    private String msg;
    public String getMsg(){
        return msg;
    }
    private BettingMessage(String msg){
        this.msg = msg;
    }
}
