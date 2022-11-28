package view;

import view.panels.Clientes;
import view.panels.Facturas;
import view.panels.MainMenu;
import view.panels.Productos;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Button facturaButton;
    private Button clienteButton;
    private Button productoButton;
    MainMenu menuPanel;
    Facturas facturas;
    Clientes clientes;
    Productos productos;
    public Ventana(Facturas facturas, Clientes clientes, MainMenu menuPanel, Productos productos){
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
        this.productos = productos;
        add(this.menuPanel);
        add(this.clientes);
        add(this.productos);
        add(this.facturas);
        showFacturaPanel();
        setVisible(true);
    }

    public void showFacturaPanel(){
        facturas.setVisible(true);
        clientes.setVisible(false);
        productos.setVisible(false);
    }
    public void showClientePanel(){
        clientes.setVisible(true);
        facturas.setVisible(false);
        productos.setVisible(false);
    }
    public void showProductoPanel(){
        facturas.setVisible(false);
        clientes.setVisible(false);
        productos.setVisible(true);
    }
}
