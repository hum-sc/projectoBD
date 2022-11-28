package view;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    Font roboto = new Font("Roboto", Font.BOLD, 30);
    public Title(String text){
        super(text);
        setFont(roboto);
        setForeground(Color.white);
        setSize(300,50);
    }
}
