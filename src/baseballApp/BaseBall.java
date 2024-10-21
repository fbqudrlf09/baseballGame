package baseballApp;

import java.util.HashSet;
import java.util.Random;

public class BaseBall {

    private int digitNum = 4;

    public void setDigitNum(int digitNum) {
        this.digitNum = digitNum;
    }

    public void run() {
        // 데이터 입력
        NumberDTO numberDTO = getRandomNumberDTO(digitNum);

        // 데이터 검증
        // 게임 구현
    }

    private NumberDTO getRandomNumberDTO(int digit) {
        NumberDTO numberDTO = new NumberDTO();
        int maxNum = (int)(Math.pow(10, digit) -1);
        int minNum = (int)Math.pow(10, digit - 1);
        HashSet<Integer> hashSet = new HashSet<Integer>();

        Random random = new Random();
        int ranNumber = 0;

        while(true) {
            ranNumber = random.nextInt(minNum, maxNum);
            if(Parser.isNotDepulicationNumber(ranNumber)) break;
        }

        numberDTO.setBaseBallNumber(ranNumber);

        return numberDTO;
    }
}
