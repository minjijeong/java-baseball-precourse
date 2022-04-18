package baseball.model.tuple;

import baseball.model.constant.JudgementType;

public class BaseballRule {
    public static JudgementType judgeStrikeOrBall(int round, StrikeNumbers strikeNumbers, PlayerNumbers playerNumbers) {
        if (strikeNumbers.getRound(round) == playerNumbers.getRound(round)) {
            return JudgementType.STRIKE;
        }
        if (strikeNumbers.contains(playerNumbers.getRound(round))) {
            return JudgementType.BALL;
        }
        return JudgementType.NOTHING;
    }

}
