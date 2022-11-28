package view;

import view.panels.Facturas;
import view.panels.MainMenu;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Button facturaButton;
    private Button clienteButton;
    private Button productoButton;
    MainMenu menuPanel;
    Facturas facturas;
    public Ventana(Facturas facturas){
        super("Ventana");
        getContentPane().setBackground(Color.darkGray);
        setSize(814, 537);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        setTitle("Facturacion LA COMPU S.A");
        this.facturas = facturas;
        menuPanel = new MainMenu();
        add(menuPanel);
        add(facturas);
        setVisible(true);
    }
}
