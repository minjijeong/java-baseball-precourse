package baseball.model.constant;

public enum ErrorCode {
    INVALID_INPUT(">> 사용자의 배팅 값이 잘못입력되었습니다. \n각 자리수에는 [1-9]만 중복없이 가능합니다. ex) 129 "),
    INVALID_LENGTH(">> 사용자의 베팅 값의 자리수를 다시 확인해주세요."),
    INVALID_UNUNIQUE(">> 사용자의 베팅 값 내에 중복된 숫자가 존재합니다."),
    INVALID_ANSWER(">> 게임 종료 명령값이 잘못입력되었습니다. \n게임 재시작은 1, 게임 종료는 2 입니다.");

    String msg;
    ErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
