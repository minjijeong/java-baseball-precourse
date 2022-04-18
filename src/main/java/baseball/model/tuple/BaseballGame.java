package baseball.model.tuple;

import baseball.model.constant.GameStatus;
import baseball.utils.BaseballUtils;
import java.util.*;

public class BaseballGame {
    /**
     * 중복 배팅 가능여부
     */
    public static boolean duplicated;
    /**
     * 배팅 횟수
     */
    public static int digit;

    /**
     * 컴퓨터 배팅 숫자 생성
     */
    public List<Integer> computerNumber;

    /**
     * 배팅 횟수
     */
    public GameStatus status;

    /**
     * 게임 룰 생성
     */
    public BaseballGame(){
        this.duplicated = false;
        this.digit=3;
        computerNumber = this.setComputerNumber();
        this.status = GameStatus.READY;
    }
    /**
     * 게임 룰 생성
     * - 자리수 , 중복여부 수동 세팅
     */
    public BaseballGame(Boolean duplicated, int digit){
        this.duplicated = this.duplicated;
        this.digit= this.digit;
        computerNumber = this.setComputerNumber();
        this.status = GameStatus.READY;
    }

    /**
     * 컴퓨터 배팅 숫자 생성
     * @return List<Integer>
     */
    public List<Integer> setComputerNumber(){
        // 컴퓨터 게임 랜덤 세팅 - 확인 사항 중복된 숫자 존재하는지
        this.computerNumber = BaseballUtils.getRandomNumbers(this.digit, this.duplicated);
        System.out.println("computerNumber :: "+computerNumber);
        return computerNumber;
    }

    /**
     * 컴퓨터 숫자 get
     * @return List<Integer>
     */
    public List<Integer> getComputerNumber(){
        return this.computerNumber;
    }
}
