package baseball.utils;
import baseball.model.constant.Constant;
import baseball.model.constant.ErrorCode;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class BaseballUtils  {

    /**
     * 문자열 숫자리스트로 변환
     * String cast to List<Integer>
     */
    public static List<Integer> castToList(String number) throws Exception {
        List<Integer> num = new ArrayList<>();
        // 유효성 체크하여 정상인 수만 List 형태로 변환
        if(validCheck(number)) {
            char[] charNums = number.toCharArray();
            for (char charNum : charNums) {
                int tmpNum = Integer.parseInt(String.valueOf(charNum));
                // 중복 제한시, 동일 항목 있는 경우 에러
                if(!Constant.BETTING_DUPLICATED && num.contains(tmpNum)){
                    throw new IllegalArgumentException(ErrorCode.INVALID_UNUNIQUE.getMsg());
                }
                num.add(tmpNum);
            }
        }
        return num;
    }

    /**
     * 입력된 문자열 유효성 체크
     */
    public static boolean validCheck(String number) throws Exception{
        // 유효성 체크 로직
        // 빈값인 경우
        if(number.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.getMsg());
        }
        // 길이가 3이 아닌 경우
        if(number.length() != 3) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LENGTH.getMsg());
        }
        // 숫자가 아닌 글자 입력시
        if(!number.matches(Constant.regExp)){
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.getMsg());
        }
        return true;
    }

    public static boolean validCheckExit(String number) throws Exception{
        // 유효성 체크 로직
        // 빈값인 경우
        if(number.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ANSWER.getMsg());
        }
        // 길이가 1이 아닌 경우
        if(number.length() != 1) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ANSWER.getMsg());
        }
        // 1,2만 입력 가능
        if(!number.matches(Constant.regExpAns)){
            throw new IllegalArgumentException(ErrorCode.INVALID_ANSWER.getMsg());
        }
        return true;
    }

    /**
     * 랜덤 숫자 생성
     * digitNumber : 생성 자리수
     * duplicated : 중복 생성 가능 여부 확인
     */
    public static List<Integer> getRandomNumbers(int digitNumber){
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i=0;i<digitNumber;i++){
            randomNumbers.add(getRandomNumber(randomNumbers, Constant.BETTING_DUPLICATED));
        }
        return randomNumbers;
     }

    /**
     * 램덤 숫자 중복 체크
     * - 중복 시, 재생성
     */
    public static int getRandomNumber(List<Integer> numbers, boolean duplicated){
        int newNumber = Randoms.pickNumberInRange(Constant.MIN_NUM,Constant.MAX_NUM);
        // 각 숫자 중복 체크 - 중복 제한
        if(!duplicated) {
            if (numbers.contains(newNumber)) {
                return getRandomNumber(numbers, false);
            }
        }
        return newNumber;
    }

}
