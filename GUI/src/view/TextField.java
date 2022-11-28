package view;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {

    public TextField(){
        super(10);
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white));
        setForeground(Color.white);
    }

}
