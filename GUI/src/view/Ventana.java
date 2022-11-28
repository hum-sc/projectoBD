package view;

import view.panels.Clientes;
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
    Clientes clientes;
    public Ventana(Facturas facturas, Clientes clientes, MainMenu menuPanel){
        super("Ventana");
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setSize(1014, 537);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        setTitle("Facturacion LA COMPU S.A");
        this.facturas = facturas;
        this.clientes = clientes;
        this.menuPanel = menuPanel;
        add(this.menuPanel);
        add(this.clientes);
        add(facturas);
        showFacturaPanel();
        setVisible(true);
    }

    public void showFacturaPanel(){
        facturas.setVisible(true);
        clientes.setVisible(false);
    }
    public void showClientePanel(){
        clientes.setVisible(true);
        facturas.setVisible(false);
    }
    public void showProductoPanel(){
        facturas.setVisible(false);
        clientes.setVisible(false);
    }
}
