import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class UserInterface extends JFrame {

    Calculation calculation = new Calculation();
    ScreenAction screenAction = new ScreenAction();
    Status status = new Status();

    Color myGreen = new Color(46, 204, 113);
    Color myRed = new Color(242, 38, 19);

    private JPanel mainpanel;
    private JPanel Keypad;
    private JTextField textField1;

    private JButton onOffButton;
    private JButton sinButton;
    private JButton cosButton;
    private JButton tanButton;
    private JButton logButton;
    private JButton lnButton;

    private JButton CEButton;
    private JButton cButton;

    private JButton n9Button;
    private JButton n8Button;
    private JButton n7Button;
    private JButton n6Button;
    private JButton n5Button;
    private JButton n4Button;
    private JButton n3Button;
    private JButton n2Button;
    private JButton n1Button;
    private JButton n0Button;
    private JButton dotButton;
    private JButton EquvalanceButton;

    private JButton buttonSquareRoot;
    private JButton buttonAddition;
    private JButton buttonSubtraction;
    private JButton buttonDivision;
    private JButton buttonMultiplication;
    private JButton buttonAbsolute;
    private JButton buttonXpowerOfY;
    private JButton buttonFactorial;
    private JButton buttonPowerof;
    private JButton buttonExp;
    private JButton Significant;

    public UserInterface()  {

        onOffButton.addActionListener(this::switchPerformed);
        n1Button.addActionListener(this::NumberEnterance);
        n2Button.addActionListener(this::NumberEnterance);
        n3Button.addActionListener(this::NumberEnterance);
        n4Button.addActionListener(this::NumberEnterance);
        n5Button.addActionListener(this::NumberEnterance);
        n6Button.addActionListener(this::NumberEnterance);
        n7Button.addActionListener(this::NumberEnterance);
        n8Button.addActionListener(this::NumberEnterance);
        n9Button.addActionListener(this::NumberEnterance);
        n0Button.addActionListener(this::NumberEnterance);
        dotButton.addActionListener(this::NumberEnterance);

        buttonAddition.addActionListener(this::OperatorPerfomed);
        buttonSubtraction.addActionListener(this::OperatorPerfomed);
        buttonMultiplication.addActionListener(this::OperatorPerfomed);
        buttonDivision.addActionListener(this::OperatorPerfomed);
        buttonSquareRoot.addActionListener(this::OperatorPerfomed);
        buttonXpowerOfY.addActionListener(this::OperatorPerfomed);

        buttonAbsolute.addActionListener(this::OperatorPerfomed);
        buttonFactorial.addActionListener(this::OperatorPerfomed);
        buttonPowerof.addActionListener(this::OperatorPerfomed);
        buttonExp.addActionListener(this::OperatorPerfomed);
        lnButton.addActionListener(this::OperatorPerfomed);
        sinButton.addActionListener(this::OperatorPerfomed);
        cosButton.addActionListener(this::OperatorPerfomed);
        tanButton.addActionListener(this::OperatorPerfomed);
        logButton.addActionListener(this::OperatorPerfomed);

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!textField1.getText().equals("") && status.getOperator() != ' '){

                    getTextField1().setText("");
                    status.setScreenFlag(false);

                } else if (textField1.getText().equals("") && status.getOperator() != ' ' ){

                    status.setOperator(' ');
                }
                else {

                    getTextField1().setText("");
                    status.setScreenFlag(false);
                    status.setOperator(' ');
                    status.setNumber1(0);
                    status.setNumberFlag(true);
                }

            }
        });
        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getTextField1().setText("");
                status.setNumber1(0);
                status.setOperator(' ');
                status.setNumber2(0);
                status.setScreenFlag(false);
                status.setNumberFlag(true);
            }
        });
        EquvalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Equal to
                Calculate();
            }
        });
        Significant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().equals("") && status.isNumberPositive()){
                    // convert to negative
                    textField1.setText("-");
                    status.setNumberFlag(false);
                    Significant.setText("-/+");

                } else if (textField1.getText().equals("") && !status.isNumberPositive()){
                    // convert to positive
                    textField1.setText("");
                    status.setNumberFlag(true);
                    Significant.setText("+/-");

                } else if (textField1.getText().equals("-")){
                    // convert to negative
                    textField1.setText("");
                    status.setNumberFlag(true);
                    Significant.setText("+/-");

                } else if (status.getNumber1() == 0 && status.isNumberPositive()) {
                    // convert to negative
                    textField1.setText(String.valueOf(-1 * Double.parseDouble(textField1.getText())));
                    status.setNumberFlag(false);
                    Significant.setText("-/+");
                } else if (status.getNumber1() == 0 && !status.isNumberPositive()) {
                    // convert to positive
                    textField1.setText(String.valueOf(-1 * Double.parseDouble(textField1.getText())));
                    status.setNumberFlag(true);
                    Significant.setText("+/-");
                }  else if ((status.getNumber1() == Double.parseDouble(textField1.getText())) && status.isNumberPositive()) {
                    // convert to negative
                    status.setNumber1(-1 * Double.parseDouble(textField1.getText()));
                    textField1.setText(String.valueOf(status.getNumber1()));
                    status.setNumberFlag(false);
                    Significant.setText("-/+");
                } else if ((status.getNumber1() == Double.parseDouble(textField1.getText())) && !status.isNumberPositive()) {
                    // convert to positive
                    status.setNumber1(-1 * Double.parseDouble(textField1.getText()));
                    textField1.setText(String.valueOf(status.getNumber1()));
                    status.setNumberFlag(true);
                    Significant.setText("+/-");
                }else if (!(status.getNumber1() == Double.parseDouble(textField1.getText())) && status.isNumberPositive()) {
                    // convert to negative
                    textField1.setText(String.valueOf(-1 * Double.parseDouble(textField1.getText())));
                    status.setNumberFlag(false);
                    Significant.setText("-/+");
                } else if (!(status.getNumber1() == Double.parseDouble(textField1.getText())) && !status.isNumberPositive()) {
                    // convert to positive
                    textField1.setText(String.valueOf(-1 * Double.parseDouble(textField1.getText())));
                    status.setNumberFlag(true);
                    Significant.setText("+/-");
                }
            }
        });
    }

    public void OperatorPerfomed (ActionEvent e) {
        String value = e.getActionCommand();
        System.out.println(value + " ");
        char operatorKey = ' ';

        switch (value) {
            case "+": /* Finds the addition  */
                operatorKey = '+';
                break;
            case "-": /* Finds the subtraction  */
                operatorKey = '-';
                break;
            case "x": /* Finds the addition  */
                operatorKey = '*';
                break;
            case "/": /* Finds the addition  */
                operatorKey = '/';
                break;
            case "√ ": /* Finds the addition  */
                operatorKey = '√';
                break;
            case "x^y": /* Finds the addition  */
                operatorKey = 'B';
                break;
            case "|x|": /* Finds the addition  */
                operatorKey = 'A';
                break;
            case "X!": /* Finds the subtraction  */
                operatorKey = 'C';
                break;
            case "X^2": /* Finds the addition  */
                operatorKey = 'D';
                break;
            case "Exp": /* Finds the addition  */
                operatorKey = 'E';
                break;
            case "ln": /* Finds the addition  */
                operatorKey = 'F';
                break;
            case "Sin": /* Finds the addition  */
                operatorKey = 'G';
                break;
            case "Cos": /* Finds the addition  */
                operatorKey = 'H';
                break;
            case "Tan": /* Finds the addition  */
                operatorKey = 'J';
                break;
            case "Log": /* Finds the addition  */
                operatorKey = 'K';
                break;
        }
        System.out.println(operatorKey + " ");
        if (status.getOperator() == ' ') {

            if(operatorKey == 'A' && operatorKey == 'C' && operatorKey == 'D' && operatorKey == 'E' && operatorKey == 'F' && operatorKey == 'G' && operatorKey == 'H' && operatorKey == 'J' && operatorKey == 'K'){

                getFirstNumber();
                status.setOperator(operatorKey);
                Calculate();
                status.setOperator(' ');

            } else if (operatorKey =='-'){

                if (textField1.getText().equals("")) {

                    status.setNumberFlag(false);
                    textField1.setText(String.valueOf(operatorKey));

                } else if (status.getOperator() == ' ') {

                    getFirstNumber();
                    status.setOperator(operatorKey);

                } else {

                    getSecondNumber();
                    Calculate();
                    status.setOperator(operatorKey);
                }

            } else if (status.getNumber1() != 0 && !(operatorKey =='-')) {

                status.setOperator(operatorKey);

            } else {
                getFirstNumber();
                status.setOperator(operatorKey);
            }
        } else {

            getSecondNumber();
            Calculate();
            status.setOperator(operatorKey);
        }
    }

    public void NumberEnterance (ActionEvent e) {

        if ( screenAction.checkScreen(textField1.getText(),'.') == false){

            String value = e.getActionCommand();
            System.out.println(value + "\n");

            if (textField1.getText().equals("") &&  value == "."){

                setScreen(0+value);

            }else{
                if ( textField1.getText().equals("-") &&  value == "."){

                    setScreen(-0+value);
                }else{
                    setScreen(value);
                }
            }
        } else {

            String value = e.getActionCommand();

            if ( value != "." ){

                setScreen(value);
            }
        }
    }

    public void switchPerformed(ActionEvent e) {
        //On/Off Button

        switch (status.getOnOff()){

            case 'A': status.setOnOff('P');
                Keypad.setVisible(false);
                onOffButton.setText("On");
                onOffButton.setBackground(myGreen);
                getTextField1().setText(" Calculator Closed");
                status.setNumber1(0);
                status.setOperator(' ');
                status.setNumber2(0);
                status.setScreenFlag(false);
                break;
            case 'P': status.setOnOff('A');
                Keypad.setVisible(true);
                onOffButton.setText("Off");
                onOffButton.setBackground(myRed);
                getTextField1().setText("");
                break;
        }
    }

    public void setScreen(String key){

        String screenValue;
        if (status.getNumber2() == 0 && status.getOperator()!=' ' && status.isScreenFlag() == true ){

            textField1.setText("");
            status.setScreenFlag(false);
            //string = screenAction.enterNumber(textField1.getText(),key);
            screenValue = key;
            textField1.setText(screenValue);

        }else {

            screenValue = screenAction.enterNumber(textField1.getText(),key);
            textField1.setText(screenValue);
        }
    }

    public void getResult(){

        System.out.println("got in result");

        status.setScreenFlag(false);

        switch (status.getOperator()) {

            case '+': /* Finds the addition  */
                status.setResult(status.getNumber1() + status.getNumber2());
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case '-': /* Finds the subtraction */
                status.setResult(status.getNumber1() - status.getNumber2());
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case '*': /* Finds the multiplication */
                status.setResult(status.getNumber1() * status.getNumber2());
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case '/': /* Finds the division */
                status.setResult(status.getNumber1() / status.getNumber2());
                status.setNumber1(status.getResult());
                status.setNumber2(0);;
                break;
            case '√': /* Finds the square root */
                //result = number1 * Math.sqrt(number2);
                status.setResult(status.getNumber1() * Math.sqrt(status.getNumber2()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'A': /* Finds the absolute value of a number */
                //result = Math.abs(number1);
                status.setResult(Math.abs(status.getNumber1()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'B': /* Finds the number1 to power of number2 */
                //result = Math.pow(number1 , number2);
                status.setResult(Math.pow(status.getNumber1(), status.getNumber2()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'C': /* Finds the factorial of number1 */
                //result = calculation.Factorial(number1);
                status.setResult(calculation.Factorial(status.getNumber1()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'D': /* Finds the number1 to power of 2 */
                //result = Math.pow(number1 , 2);
                status.setResult(Math.pow(status.getNumber1() , 2));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'E': /* Finds the exponential of number */
                //result = Math.exp(number1);
                status.setResult(Math.exp(status.getNumber1()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'F': /* Finds the ln */
                //result = Math.log(number1);
                status.setResult( Math.log( status.getNumber1()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'G': /* Finds sin of number */
                //result = Math.sin(Math.toRadians(number1));
                status.setResult( Math.sin( Math.toRadians(status.getNumber1())));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'H': /* Finds the cosine of number */
                //result = Math.cos(Math.toRadians(number1));
                status.setResult( Math.cos( Math.toRadians(status.getNumber1())));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'J': /* Finds the tangent of number */
                //result = Math.tan(Math.toRadians(number1));
                status.setResult( Math.tan( Math.toRadians(status.getNumber1())));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
            case 'K': /* Finds the exponential of number */
                //result = Math.log10(number1);
                status.setResult(Math.log10(status.getNumber1()));
                status.setNumber1(status.getResult());
                status.setNumber2(0);
                break;
        }
    }

    public void Calculate(){

        if (status.getOperator() == ' '){

            getFirstNumber();

        }
        else {

            getSecondNumber();

            getResult();

            textField1.setText(String.valueOf(status.getNumber1()));
        }
    }

    public void getFirstNumber(){

        if (status.isNumberPositive() == false){

                status.setNumber1(Double.parseDouble(textField1.getText()));
                status.setNumberFlag(true);
                status.setScreenFlag(true);

        } else {

            status.setNumber1(Double.parseDouble(textField1.getText()));
            status.setScreenFlag(true);
        }
    }

    public void getSecondNumber(){

            status.setNumber2(Double.parseDouble(textField1.getText()));
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(String text) {

        textField1.setText(text);
    }
}
