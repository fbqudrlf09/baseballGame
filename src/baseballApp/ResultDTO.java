package baseballApp;

public class ResultDTO {

    private int strikeNumber;
    private int ballNumber;
    private int outNumber;

    public ResultDTO() {}

    public ResultDTO(int strikeNumber, int ballNumber, int outNumber) {
        this.strikeNumber = strikeNumber;
        this.ballNumber = ballNumber;
        this.outNumber = outNumber;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public void setStrikeNumber(int strikeNumber) {
        this.strikeNumber = strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public int getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(int outNumber) {
        this.outNumber = outNumber;
    }

    public String toString() {
        return "strikeNumber \t : \t" +  strikeNumber + "\t" + "ballNumber \t : \t " + ballNumber + "\t" + "outNumber \t : \t " + outNumber;
    }
}
