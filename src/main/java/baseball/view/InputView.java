package baseball.view;

import baseball.model.constant.BettingMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "3자리 숫자를 입력해 주세요: ";

    public static String inputNumbers() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}