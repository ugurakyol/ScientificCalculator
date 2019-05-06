public class Action {

    Variables variables = new Variables();

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
        Visual visual = new Visual();
        String string = "";
        if (variables.getNumber2() == 0 && variables.getOperator()!=' ' && variables.isScreenFlag() == false ){
            visual.setTextField1("");
            //textField1.setText("");
            variables.setScreenFlag(true);
            string = enterNumber(visual.getTextField1().getText(),key);
            visual.getTextField1().setText(string);

        }else {

            string = enterNumber(visual.getTextField1().getText(),key);
            visual.getTextField1().setText(string);
        }
    }


}
