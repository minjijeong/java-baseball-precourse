package baseball.service;

import baseball.model.constant.BettingMessage;
import baseball.model.tuple.BaseballGame;
import baseball.utils.BaseballUtils;
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
    public String setUserNumber() throws Exception {
        System.out.println(BettingMessage.ASK_NUMBER.getMsg());
        String userNumber = Console.readLine();

        // 사용자 입력 값 String 유효성 체크
        BaseballUtils.validCheck(userNumber);

        return  userNumber;
    }

    /**
     * 사용자 게임 종료 선택
     * @return String
     */
    public String setRetryOrExit() throws Exception {
        System.out.println(BettingMessage.RESULT_SUCESS.getMsg());
        System.out.println(BettingMessage.ASK_NEXT_STEP.getMsg());

        String nextStep = Console.readLine();

        BaseballUtils.validCheckExit(nextStep);

        return nextStep;
    }
}
