package baseball.model.tuple;

import baseball.model.constant.GameStatus;
import baseball.utils.BaseballUtils;
import java.util.List;

public class Player {
    // 사용자 베팅 숫자 리스트
    public List<Integer> userNumList;
    // 사용자 베팅 입력값
    public String userNumberStr;

    public String result;

    public GameStatus status;

    public Player(String userNumber) throws Exception {
        this.userNumberStr = userNumber;
        this.userNumList = BaseballUtils.castToList(userNumberStr); // String to List<Integer>
        this.result = "";
        this.status = GameStatus.READY;
    }
}
