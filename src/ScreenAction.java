public class ScreenAction {

    Status status = new Status();

    public String enterNumber(String screen, String key){

        String result = screen+key;

        return result;
    }

    boolean checkScreen(String s,char c) {

        boolean flag = false ;
        int len = s.length();

        if (s == null)  {

            flag = false;

        } else {

            for (int i = 0; i < len; i++) {

                if (s.charAt(i) == c) {

                    flag = true;
                }
            }

        }

        return flag;
    }






    public void setScreen(String key){
        UserInterface userInterface = new UserInterface();
        String string = "";
        if (status.getNumber2() == 0 && status.getOperator()!=' ' && status.isScreenFlag() == false ){
            userInterface.setTextField1("");
            //textField1.setText("");
            status.setScreenFlag(true);
            string = enterNumber(userInterface.getTextField1().getText(),key);
            userInterface.getTextField1().setText(string);

        }else {

            string = enterNumber(userInterface.getTextField1().getText(),key);
            userInterface.getTextField1().setText(string);
        }
    }


}
