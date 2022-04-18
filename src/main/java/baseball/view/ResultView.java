package baseball.view;

import baseball.model.constant.JudgementType;
import baseball.model.tuple.BaseballRecord;
import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_EXIT = "게임을 종료합니다.";
    private static final String DELIMITER = " ";

    public static void printGameRecord(BaseballRecord baseballRecord) {
        System.out.println(getJudgementString(baseballRecord));
    }

    private static String getJudgementString(BaseballRecord baseballRecord) {
        if (baseballRecord.hasOut()) {
            return JudgementType.NOTHING.toString();
        }

        List<String> judgementList = new ArrayList<>();
        if (baseballRecord.hasBall()) {
            judgementList.add(baseballRecord.getBallCount() + JudgementType.BALL.toString());
        }
        if (baseballRecord.hasStrike()) {
            judgementList.add(baseballRecord.getStrikeCount() + JudgementType.STRIKE.toString());
        }

        return String.join(DELIMITER, judgementList);
    }

    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public static void printExitMessage() {
        System.out.print(GAME_EXIT);
    }

}
