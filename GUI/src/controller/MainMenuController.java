package controller;

import dataBase.DataBaseSession;
import model.Venta;
import view.Ventana;
import view.panels.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
    private MainMenu mainMenu;
    private Ventana ventana;
    private DataBaseSession dataBaseSession;
    public MainMenuController(MainMenu mainMenu, Ventana ventana, DataBaseSession dataBaseSession){
        this.mainMenu = mainMenu;
        this.ventana = ventana;
        mainMenu.setActionListener(this);
        this.dataBaseSession = dataBaseSession;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Factura":
                ventana.showFacturaPanel();
                break;
            case "Cliente":
                ventana.showClientePanel();
                break;
            case "Producto":
                ventana.showProductoPanel();
                break;
        }
    }
}
