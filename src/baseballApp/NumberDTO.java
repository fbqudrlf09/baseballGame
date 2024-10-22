package baseballApp;

public class NumberDTO {

    public NumberDTO() {}
    public NumberDTO(int number) {baseBallNumber = number;}

    // 입력된 값을 저장한 클래스
    private int baseBallNumber;

    public int getBaseBallNumber() {
        return baseBallNumber;
    }

    public void setBaseBallNumber(int baseBallNumber) {
        this.baseBallNumber = baseBallNumber;
    }
    public String toString() {
        return "baseBallNumber \t : \t " + baseBallNumber;
    }
}
