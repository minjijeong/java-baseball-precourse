package baseball.model.tuple;

import baseball.utils.BaseballUtils;
import java.util.List;

public class Player {
    // 사용자 베팅 숫자 리스트
    public List<Integer> userNumList;
    // 사용자 베팅 입력값
    public String userNumberStr;
    // 경기 결과
    public String Result;
    public Player(String userNumber){
        this.userNumberStr = userNumber;
        this.userNumList = BaseballUtils.castToList(userNumberStr); // String to List<Integer>
    }
}
