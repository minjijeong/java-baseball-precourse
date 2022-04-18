package baseball;

import baseball.utils.BaseballUtils;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballTest extends NsTest {

    @Test
    void 랜덤숫자생성_테스트() {
        assertSimpleTest();
    }

    private void assertSimpleTest() {
        BaseballUtils utils = new BaseballUtils();
        List<Integer> randomNumbers = utils.getRandomNumbers(3,false);
        System.out.println(" randomNumbers :: "+ randomNumbers);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
