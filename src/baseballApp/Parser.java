package baseballApp;

import java.util.HashSet;
import java.util.stream.Stream;

public class Parser {

    // 입력된 값을 검증하는 클래스
    public static boolean isNumber(String str) {
        return str.matches("[1-9]");
    }

    public static boolean isRightDigitNumber(String number, int digit){
        String str;

        // 첫번쨰 자리의 수는 무조건 0이 없어야 하며 그 이후 수는 0도 포함할 수 있다.
        if(digit == 1) str = "[1-9]";
        else str = "[1-9]" + "[0-9]{" + (digit - 1) + "}";

        return number.matches(str);
    }

    public static boolean isNotDuplicationNumber(int value){
        HashSet<Integer> set = new HashSet<>();

        // Stream 동작 공부하기
        int[] numbers = Stream.of(String.valueOf(value).split("")).mapToInt(Integer::parseInt).toArray();

        for(int item : numbers){
            set.add(item);
        }

        return set.size() == numbers.length;
    }
}
