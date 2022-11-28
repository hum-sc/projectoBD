package model;

import controller.FacturasController;
import dataBase.DataBaseSession;
import view.Ventana;
import view.panels.Facturas;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception {
        DataBaseSession dataBaseSession = new DataBaseSession();
        Facturas facturas = new Facturas();
        Ventana ventana = new Ventana(facturas);
        FacturasController facturasController = new FacturasController(facturas, dataBaseSession);
    }
}
