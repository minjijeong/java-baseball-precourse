package baseball.model.constant;

import baseball.model.tuple.BettingResult;

public enum BettingMessage {
    ASK_NUMBER("숫자를 입력해 주세요 : "),
    ASK_NEXT_STEP("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESULT_SUCESS("3개의 숫자를 모두 맞히셨습니다! 게임종료"),

    RESULT_BALL("볼"),
    RESULT_NOTHING("낫싱"),
    RESULT_STRIKE("스트라이크");

    private String msg;
    public String getMsg(){
        return msg;
    }
    private BettingMessage(String msg){
        this.msg = msg;
    }

    public static String getBettingResultMsg(BettingResult result){
        StringBuilder message = new StringBuilder();
        if(result.nothing == Constant.BETTING_LENGTH){
            message.append(RESULT_NOTHING.getMsg());
            return message.toString();
        }
        if(result.ball > 0 ){
            message.append(result.ball);
            message.append(RESULT_BALL.getMsg());
            message.append(" ");
        }

        if(result.strike > 0){
            message.append(result.strike);
            message.append(RESULT_STRIKE.getMsg());
            message.append(" ");
        }

        if(result.strike == Constant.BETTING_WIN_STRIKE){
            message.append(RESULT_SUCESS.getMsg());
            message.append(ASK_NEXT_STEP.getMsg());
        }
        return message.toString();
    }
}
