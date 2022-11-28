package view.panels;

import view.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends MenuPanel{
    private Button facturaButton;
    private Button clienteButton;
    private Button productoButton;

    private int isFoccus;

    public MainMenu(){
        facturaButton = new Button("Factura", Color.darkGray);
        clienteButton = new Button("Cliente", Color.darkGray);
        productoButton = new Button("Producto", Color.darkGray);

        facturaButton.setBounds(10,175,130,40);
        clienteButton.setBounds(10,225,130,40);
        productoButton.setBounds(10,275,130,40);

        add(facturaButton);
        add(clienteButton);
        add(productoButton);

    }

    public void setActionListener(ActionListener actionListener){
        facturaButton.addActionListener(actionListener);
        clienteButton.addActionListener(actionListener);
        productoButton.addActionListener(actionListener);
    }
}
