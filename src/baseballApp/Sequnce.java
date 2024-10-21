package baseballApp;

import java.util.Scanner;

public class Sequnce {

    // 실제 동작하는 클래스
    public static void run(){

        boolean flag = true;

        while(flag){
            Scanner sc = new Scanner(System.in);

            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String command = sc.nextLine();

            BaseBall baseBall = new BaseBall();
            baseBall.run();

            switch(command){
                case "0": {
                    // 자릿수 설정 구현

                    break;
                }
                case "1":{
                    // 게임 시작하기 구현

                    break;
                }
                case "2": {
                    //게임 기록 보기 구현

                    break;
                }
                case "3": {
                    flag = false;
                    break;
                }
                default: {

                }
            }
        }
    }
}
