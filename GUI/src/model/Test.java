package model;

import controller.ClientesController;
import controller.FacturasController;
import controller.MainMenuController;
import dataBase.DataBaseSession;
import view.Ventana;
import view.panels.Clientes;
import view.panels.Facturas;
import view.panels.MainMenu;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception {
        DataBaseSession dataBaseSession = new DataBaseSession();
        Facturas facturas = new Facturas();
        Clientes clientes = new Clientes();
        MainMenu mainMenu = new MainMenu();
        Ventana ventana = new Ventana(facturas, clientes, mainMenu);
        MainMenuController mainMenuController = new MainMenuController(mainMenu, ventana, dataBaseSession);
        FacturasController facturasController = new FacturasController(facturas, dataBaseSession);
        ClientesController clientesController = new ClientesController(clientes, dataBaseSession);
    }
}
