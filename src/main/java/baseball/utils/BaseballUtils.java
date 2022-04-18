package baseball.utils;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class BaseballUtils {

    /**
     * 문자열 숫자리스트로 변환
     * String cast to List<Integer>
     */
    public static List<Integer> castToList(String number){
        List<Integer> num = new ArrayList<>();
        // 유효성 체크하여 정상인 수만 List로 변환
        if(validCheck(number)) {
            char[] charNums = number.toCharArray();
            for (char charNum : charNums) {
                num.add(Integer.parseInt(String.valueOf(charNum)));
            }
        }
        return num;
    }

    /**
     * 입력된 문자열 유효성 체크
     */
    public static boolean validCheck(String userNumber){
        // 유효성 체크 로직
        // 빈값인 경우
        if(userNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        // 길이가 3이 아닌 경우
        if(userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        // 숫자가 아닌 값이 포함된 경우

        return true;
    }
    /**
     * 랜덤 숫자 생성
     * digitNumber : 생성 자리수
     * duplicated : 중복 생성 여부 확인
     */
    public static List<Integer> getRandomNumbers(int digitNumber, boolean duplicated){
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i=0;i<digitNumber;i++){
            randomNumbers.add(getRandomNumber(randomNumbers));
        }
        return randomNumbers;
     }

    /**
     * 램덤 숫자 중복 체크
     * - 중복 시, 재생성
     */
    public static int getRandomNumber(List<Integer> numbers){
        List<Integer> returnNumbers = numbers;
        int newNumber = Randoms.pickNumberInRange(1,9);
        if(returnNumbers.contains(newNumber)){
            getRandomNumber(numbers);
        }
        return newNumber;
    }

}
