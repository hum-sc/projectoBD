package view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text, Color color){
        super(text);
        setBackground(color);
        setForeground(Color.white);
        setSize(180,50);
        setBorderPainted(false);
        setFocusPainted(false);
        setActionCommand(text);
    }
    public Button(String text, Color color, String action){
        this(text, color);
        setActionCommand(action);
    }
}
