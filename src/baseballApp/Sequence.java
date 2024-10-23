package baseballApp;

import java.util.Scanner;

public class Sequence {

    // 실제 동작하는 클래스
    public static void run(){

        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        BaseBall baseBall = new BaseBall();


        while(flag){

            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String command = sc.nextLine();

            switch(command){
                case "0": {
                    // 자릿수 설정 구현
                    System.out.println("설정하고자 하는 자릿수를 입력하세요. (1 ~ 9)");
                    baseBall.setDigitNum(sc.nextLine() );

                    break;
                }
                case "1":{
                    // 게임 시작하기 구현
                    baseBall.run();

                    break;
                }
                case "2": {
                    //게임 기록 보기 구현
                    baseBall.showGameRecord();

                    break;
                }
                case "3": {
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("잘못된 명령어를 입력하였습니다.");
                }
            }
        }
    }
}
