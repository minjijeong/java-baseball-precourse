package baseball.model.tuple;

import baseball.model.constant.JudgementType;

public class BaseballRecord {
    private static final int ROUND_COUNT = 3;

    private final StrikeNumbers strikeNumbers;
    private final PlayerNumbers playerNumbers;

    private int strikeCount;
    private int ballCount;

    public BaseballRecord(StrikeNumbers strikeNumbers, PlayerNumbers playerNumbers) {
        this.strikeNumbers = strikeNumbers;
        this.playerNumbers = playerNumbers;
    }

    public void updateRecordResult() {
        for (int round = 0; round < ROUND_COUNT; round++) {
            JudgementType judgementType = BaseballRule.judgeStrikeOrBall(round, strikeNumbers, playerNumbers);
            recordResultCounting(judgementType);
        }
    }

    private void recordResultCounting(JudgementType judgementType) {
        if (judgementType == JudgementType.STRIKE) {
            this.strikeCount++;
            return;
        }
        if (judgementType == JudgementType.BALL) {
            this.ballCount++;
        }
    }

    public boolean hasOut() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean isWin() {
        return strikeCount == ROUND_COUNT;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
