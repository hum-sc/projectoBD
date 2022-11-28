package view;

import javax.swing.*;
import java.awt.*;

public class Text extends JLabel {
    Font roboto = new Font("Roboto", Font.PLAIN, 15);
    public Text(String text){
        super(text);
        setFont(roboto);
        setForeground(Color.white);
        setSize(300,50);
    }
}
