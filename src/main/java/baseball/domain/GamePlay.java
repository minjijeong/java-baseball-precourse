package baseball.domain;

import baseball.model.constant.PlayStatus;
import baseball.model.tuple.BaseballRecord;
import baseball.model.tuple.PlayerNumbers;
import baseball.model.tuple.Random;
import baseball.model.tuple.StrikeNumbers;
import baseball.view.InputView;
import baseball.view.ResultView;

public class GamePlay {
    private static final int COUNT = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private PlayStatus playStatus;
    private StrikeNumbers strikeNumbers;

    public void start() {
        do {
            play();
            restartOrExit();
        } while (!isExit());
    }

    private boolean isExit() {
        return playStatus == PlayStatus.EXIT;
    }

    private void play() {
        changePlayStatusToPlaying();
        generateStrikeNumbers();

        do {
            inputPlayerNumbers();
        } while (isPlaying());
    }

    private void changePlayStatusToPlaying() {
        playStatus = PlayStatus.PLAYING;
    }

    private void inputPlayerNumbers() {
        String inputStringNumbers = InputView.inputNumbers();
        changeStatusIfRestartOrExit(inputStringNumbers);

        if (!isPlaying()) {
            return;
        }

        BaseballRecord baseballRecord = getBaseballRecordAndViewPrint(inputStringNumbers);
        changeStatusIfWin(baseballRecord);
    }

    private boolean isPlaying() {
        return playStatus == PlayStatus.PLAYING;
    }

    private BaseballRecord getBaseballRecordAndViewPrint(String inputStringNumbers) {
        PlayerNumbers playerNumbers = new PlayerNumbers(inputStringNumbers);
        BaseballRecord baseballRecord = new BaseballRecord(strikeNumbers, playerNumbers);
        baseballRecord.updateRecordResult();

        ResultView.printGameRecord(baseballRecord);
        return baseballRecord;
    }

    private void changeStatusIfWin(BaseballRecord baseballRecord) {
        if (!baseballRecord.isWin()) {
            return;
        }
        ResultView.printWinMessage();
        playStatus = PlayStatus.GAME_OVER;
    }

    private void restartOrExit() {
        if (isRestart() || isExit()) {
            return;
        }
        String inputContinue = InputView.inputContinue();
        changeStatusIfRestartOrExit(inputContinue);
    }

    private boolean isRestart() {
        return playStatus == PlayStatus.RESTART;
    }

    private void changeStatusIfRestartOrExit(String input) {
        if (PlayStatus.fromValue(input) == PlayStatus.RESTART) {
            playStatus = PlayStatus.RESTART;
            return;
        }
        if (PlayStatus.fromValue(input) == PlayStatus.EXIT) {
            playStatus = PlayStatus.EXIT;
            ResultView.printExitMessage();
        }
    }

    private void generateStrikeNumbers() {
        strikeNumbers = new StrikeNumbers(Random.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT));
    }


}
