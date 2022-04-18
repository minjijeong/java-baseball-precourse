package baseball.model.constant;

public enum GameStatus {
    READY("0"), START("3"), SUCCESS("4"), RETRY("1"), END("2"), ERROR("9");

    String code;
    GameStatus(String code) {
        this.code = code;
    }

    public static GameStatus getStatus(String code){
        if(code.equals("1")){
            return RETRY;
        }
        if(code.equals("2")){
            return END;
        }
        if(code.equals("0")){
            return READY;
        }
        if(code.equals("3")){
            return START;
        }
        if(code.equals("4")){
            return SUCCESS;
        }
        return ERROR;
    }
}
