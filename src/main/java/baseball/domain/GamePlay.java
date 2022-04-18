package baseball.domain;

import baseball.model.constant.GameStatus;
import baseball.model.tuple.BaseballGame;
import baseball.model.tuple.Player;
import baseball.service.GameService;
import java.util.List;
import java.util.Objects;

public class GamePlay {

    public static BaseballGame game;
    public static Player player1;
    public static GameService gameService;
    /**
     * 게임 초기화
     * @return GamePlay
     */
    public static GamePlay init(){
        //System.out.println("GamePlay init 진입");
        game = new BaseballGame();
        gameService = new GameService(game);
        return new GamePlay();
    }

    // 게임 시작
    public void play(){
        // 게임 시작
        do {
            try {
                startGame(); // 게임 시작
                getGameResult(player1.userNumList); // 게임 진행
            }catch (Exception e){
                System.out.println(e.getMessage());
                game.status = GameStatus.ERROR;
                continue;
            }
            //System.out.println("GamePlay :: play :: Game Status :: "+game.status);
        }
        while(!game.status.equals(GameStatus.END));
    }

    /**
     * 게임 시작
     * - 사용자 베팅 값 입력
     * - 게임 새로 시작 시, 컴퓨터 베팅 값 초기화
     */
    public void startGame() throws Exception {
        // 다시 시작 일때, 컴퓨터 베팅 초기화
        if(game.status.equals(GameStatus.RETRY)){
            game = new BaseballGame();
        }
        // 사용자 베팅 입력
        player1 = new Player(gameService.setUserNumber());
        game.status = GameStatus.START;
    }

    public Boolean getGameResult(List<Integer> userNumberList) throws Exception {
        //System.out.println("getGameResult: userNumberList :: "+ userNumberList );
        //System.out.println("getGameResult: comNumberList :: "+ game.getComputerNumber() );

        // 게임결과 값
        // 서비스 내의 게임결과 메소드가 게임성공이 나왔을때
        if(gameService.getGameScore(userNumberList)){
            // 성공 메시지 노출
            String nextStep = gameService.setRetryOrExit();
            // 다시 시작
            game.status = GameStatus.RETRY;
            // 게임 종료
            if(nextStep.equals("2")){
                game.status = GameStatus.END;
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
