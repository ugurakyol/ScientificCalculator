import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Form was created here

        JFrame frame = new JFrame("Scientific Calculator");
        frame.setContentPane(new UserInterface().getMainpanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

    }
}
