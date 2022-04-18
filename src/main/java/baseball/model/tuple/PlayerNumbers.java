package baseball.model.tuple;

import baseball.model.constant.BaseballIllegalArgumentException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbers implements Numbers {
    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력해 주세요.";
    public static final String NUMBER_LENGTH_MESSAGE = "3자리를 입력해 주세요.";
    private static final int COUNT = 3;

    private final List<Integer> userNumbers;

    public PlayerNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public PlayerNumbers(String userNumbers) {
        this.userNumbers = convertToList(userNumbers);
    }

    private void validateNumbers(String inputStringNumbers) {
        if (!isNumber(inputStringNumbers)) {
            throw new BaseballIllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
        if (inputStringNumbers.length() != COUNT) {
            throw new BaseballIllegalArgumentException(NUMBER_LENGTH_MESSAGE);
        }
    }

    private boolean isNumber(String s) {
        return s.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private List<Integer> convertToList(String inputStringNumbers) {
        validateNumbers(inputStringNumbers);
        List<Integer> numbers = new ArrayList<>();
        for (String s : inputStringNumbers.split("")) {
            numbers.add(Integer.parseInt(s));
        }

        validateDuplicatedNumber(numbers);
        return numbers;
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() < COUNT) {
            throw new BaseballIllegalArgumentException("중복된 숫자를 입력하셨습니다.");
        }
    }

    @Override
    public int getRound(int index) {
        return userNumbers.get(index);
    }

    @Override
    public boolean contains(int number) {
        return userNumbers.contains(number);
    }
}
