package baseballApp;

import java.util.HashSet;
import java.util.stream.Stream;

public class Parser {

    // 입력된 값을 검증하는 클래스

    public static boolean isNotDepulicationNumber(int value){
        HashSet<Integer> set = new HashSet<>();

        // Stream 동작 공부하기
        int[] numbers = Stream.of(String.valueOf(value)).mapToInt(Integer::parseInt).toArray();

        for(int items : numbers){
            set.add(items);
        }

        return set.size() == numbers.length;
    }
}
