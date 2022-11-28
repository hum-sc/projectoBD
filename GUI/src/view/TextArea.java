package view;

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import java.awt.*;

public class TextArea extends JScrollPane {
    public JTextArea textArea;
    public TextArea(String text){
        super();
        textArea = new JTextArea(text);
        textArea.setSize(300, 200);
        textArea.setLineWrap(true);
        textArea.setBackground(new Color(76, 76, 76));
        textArea.setForeground(Color.white);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(textArea);
        setBorder(null);
    }

    public void setText (String text){
        textArea.setText(text);
    }
}

