package baseballApp;

import java.util.HashSet;
import java.util.stream.Stream;

public class Parser {

    // 입력된 값을 검증하는 클래스
    public static boolean isNumber(String str) {
        return str.matches("[0-9]+");
    }

    public static boolean isRightDigit(String number, int digit){
        String str = "[0-9]{" + digit + "}";

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
