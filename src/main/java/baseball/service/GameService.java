package baseball.service;

import baseball.model.constant.BettingMessage;
import baseball.model.constant.Constant;
import baseball.model.tuple.BaseballGame;
import baseball.model.tuple.BettingResult;
import baseball.utils.BaseballUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


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
        System.out.print(BettingMessage.ASK_NUMBER.getMsg());
        String userNumber = Console.readLine();

        // 사용자 입력 값 String 유효성 체크
        BaseballUtils.validCheck(userNumber);

        return  userNumber;
    }

    /**
     * 사용자 게임 종료 선택
     * @return String
     */
    public String setRetryOrExit()  throws Exception{
        System.out.println(BettingMessage.RESULT_SUCESS.getMsg());
        System.out.println(BettingMessage.ASK_NEXT_STEP.getMsg());
        String nextStep = Console.readLine();
        BaseballUtils.validCheckExit(nextStep);

        return nextStep;
    }

    public Boolean getGameScore(List<Integer> userNumberList){
        BettingResult result = new BettingResult(0,0,0);

        int idx = 0;
        for(Integer userNumber : userNumberList){
            if(!game.computerNumber.contains(userNumber)){
                result.nothing++;
                continue;
            }
            if(userNumber.equals(game.computerNumber.get(idx))){
                result.strike++;
                idx++;
                continue;
            }
            if(game.computerNumber.contains(userNumber)){
                result.ball++;
                idx++;
                continue;
            }
            idx++;
        }
        String test = BettingMessage.getBettingResultMsg(result);
        System.out.println(test);
        // ALL 스트라이크
        if(result.strike == Constant.BETTING_WIN_STRIKE){
            return true;
        }
        return false;
    }
}
