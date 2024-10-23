package baseballApp;

import java.util.*;
import java.util.stream.Stream;

public class BaseBall {

    private List<String> gameRecords = new ArrayList<>();

    private int digitNum = 4;

    public void setDigitNum(int digitNum) {
        this.digitNum = digitNum;
    }
    public void setDigitNum(String digitNum){ if(Parser.isNumber(digitNum)){this.digitNum = Integer.parseInt(digitNum);} }

    public void run() {
        // 데이터 입력
        NumberDTO comNumberDTO = getRandomNumberDTO(digitNum);
        System.out.println(comNumberDTO.toString());
        NumberDTO userDTO;
        Scanner sc = new Scanner(System.in);
        int baseBallCntNumber = 0;

        while (true) {
            System.out.println("숫자를 입력하세요.");
            String str = sc.nextLine();
            if(isRightNumber(str)){
                System.out.println("잘못된 숫자를 입력하였습니다!");
                continue;
            }
            userDTO = new NumberDTO(Integer.parseInt(str));

            baseBallCntNumber++;
            ResultDTO resultDTO = judgeBaseBall(comNumberDTO, userDTO);
            System.out.println("총 시도\t:\t" + baseBallCntNumber + "\t" + resultDTO.toString());
            if(resultDTO.getStrikeNumber() == digitNum) break;
        }

        gameRecords.add(Integer.toString(baseBallCntNumber));
        System.out.println("게임에 이겼습니다. 총 " + baseBallCntNumber + "번의 시도를 하였습니다.");
    }

    public void showGameRecord(){
        if(gameRecords.isEmpty()) {
            System.out.println("게임 기록이 없습니다. 게임을 시작해주세요!!");
            return;
        }

        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < gameRecords.size(); i++) {
            System.out.println( (i + 1) + "번째 게임 \t:\t 시도 횟수 \t- \t" + gameRecords.get(i));
        }
    }

    private boolean isRightNumber(String str) {
        return !Parser.isRightDigitNumber(str, digitNum) || !Parser.isNotDuplicationNumber(Integer.parseInt(str));
    }

    private ResultDTO judgeBaseBall(NumberDTO comNumber, NumberDTO userNumber){

        if(comNumber.getBaseBallNumber() == userNumber.getBaseBallNumber()){return new ResultDTO(digitNum, 0, 0);}

        int strikeNumber = 0;
        int ballNumber = 0;
        int outNumber = 0;

        int[] comNumbers = Stream.of(String.valueOf(comNumber.getBaseBallNumber()).split("")).mapToInt(Integer::parseInt).toArray();
        int[] userNumbers = Stream.of(String.valueOf(userNumber.getBaseBallNumber()).split("")).mapToInt(Integer::parseInt).toArray();

        // 배열의 위치에 맞추어 값을 비교하여 숫자와 자릿수가 같은 경우의 값을 구함
        for (int i = 0; i < comNumbers.length; i++) {
            if(comNumbers[i] == userNumbers[i]) strikeNumber++;
        }

        // HashSet중복을 통해 숫자만 같은 경우를 찾은 후 자릿수와 숫자가 같은 경우의 수를 빼주어 숫자는 같지만 자릿수가 다른 경우의 값을 구함
        HashSet<Integer> hashSet =  new HashSet<Integer>();
        for (int i = 0; i < comNumbers.length; i++) {
            hashSet.add(comNumbers[i]);
            hashSet.add(userNumbers[i]);
        }

        // Set에 추가한 개수 - Set에 저장된 개수 = 중복된 숫자 개수
        // 중복된 숫자 개수 - 스트라이크 된 숫자 개수 = 자릿수는 다르지만 숫자는 같은 숫자의 개수
        ballNumber = comNumbers.length * 2 - hashSet.size() - strikeNumber;
        outNumber = comNumbers.length - ballNumber - strikeNumber;

        return new ResultDTO(strikeNumber, ballNumber, outNumber);
    }

    private NumberDTO getRandomNumberDTO(int digit) {
        int maxNum = (int)(Math.pow(10, digit) -1);
        int minNum = (int)Math.pow(10, digit - 1);
        Random random = new Random();
        int ranNumber = 0;

        while(true) {
            ranNumber = random.nextInt(minNum, maxNum);
            if(Parser.isNotDuplicationNumber(ranNumber)) break;
        }

        return new NumberDTO(ranNumber);
    }
}
