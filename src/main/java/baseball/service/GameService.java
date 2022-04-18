package baseball.service;

import baseball.model.constant.BettingMessage;
import baseball.model.constant.GameStatus;
import baseball.model.tuple.BaseballGame;
import camp.nextstep.edu.missionutils.Console;


public class GameService {
    private BaseballGame game;

    public GameService(BaseballGame game){
        this.game = game;
    }

    /**
     * 사용자 베팅 입력
     * @return String
     */
    public String setUserNumber(){
        System.out.println(BettingMessage.ASK_NUMBER.getMsg());
        return Console.readLine();
    }

    /**
     * 사용자 게임 종료 선택
     * @return String
     */
    public String setRetryOrExit(){
        System.out.println(BettingMessage.RESULT_SUCESS.getMsg());
        System.out.println(BettingMessage.ASK_NEXT_STEP.getMsg());
        return Console.readLine();
    }
}
