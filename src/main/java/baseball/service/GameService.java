package baseball.service;

import baseball.model.constant.BettingMessage;
import baseball.model.constant.Constant;
import baseball.model.constant.GameStatus;
import baseball.model.tuple.BaseballGame;
import baseball.model.tuple.BettingResult;
import baseball.model.tuple.Player;
import baseball.utils.BaseballUtils;
import baseball.view.InputView;
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
    public static String getBaseballRecordAndViewPrint() throws Exception {
        String userNumber = InputView.inputNumbers();

        // 사용자 입력 값 String 유효성 체크
        BaseballUtils.validCheck(userNumber);

        return  userNumber;
    }

    /**
     * 사용자 게임 종료 선택
     * @return String
     */
    public String setRetryOrExit()  throws Exception{
        String nextStep = Console.readLine();
        BaseballUtils.validCheckExit(nextStep);

        return nextStep;
    }

    /**
     * 베팅 게임 점수 항목별로 계산
     */
    public Player getGameScore(Player player){
        BettingResult result = new BettingResult(0,0,0);

        int idx = 0;
        for(Integer userNumber : player.userNumList){
            // 컴퓨터 베팅 내에 어떠한 것도 일치 하지 않으면
            if(!game.computerNumber.contains(userNumber)){
                result.nothing++;
                idx++;
                continue;
            }
            // 각 자리의 베팅 값이 일치하면
            if(userNumber.equals(game.computerNumber.get(idx))){
                result.strike++;
                idx++;
                continue;
            }
            // 컴퓨터 베팅내에 존재하는 수이면
            if(game.computerNumber.contains(userNumber)){
                result.ball++;
                idx++;
                continue;
            }
            idx++;
        }
        player.result = BettingMessage.getBettingResultMsg(result);
        System.out.println(player.result);

        // ALL 스트라이크
        if(result.strike == Constant.BETTING_WIN_STRIKE){
            player.status = GameStatus.SUCCESS;
        }
        return player;
    }
}
