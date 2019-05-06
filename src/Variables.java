public class Variables {

    protected String string = new String();
    protected char OnOff = 'A';
    protected boolean screenFlag = false;
    protected boolean isPositive = true;
    protected double number1 = 0;
    protected double number2 = 0;
    protected double result = 0;
    protected char operator = ' ';


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public char getOnOff() {
        return OnOff;
    }

    public void setOnOff(char onOff) {
        OnOff = onOff;
    }

    public boolean isScreenFlag() { return screenFlag; }

    public void setScreenFlag(boolean screenFlag) {
        this.screenFlag = screenFlag;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public boolean isNumberPositive() {
        return isPositive;
    }

    public void setNumberFlag(boolean positive) {
        isPositive = positive;
    }
}
