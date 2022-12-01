import controller.ClientesController;
import controller.FacturasController;
import controller.MainMenuController;
import controller.ProductosController;
import dataBase.DataBaseSession;
import view.Ventana;
import view.panels.Clientes;
import view.panels.Facturas;
import view.panels.MainMenu;
import view.panels.Productos;

public class App {
    public static void main(String[] args) throws Exception {
        DataBaseSession dataBaseSession = new DataBaseSession();
        Facturas facturas = new Facturas();
        Clientes clientes = new Clientes();
        MainMenu mainMenu = new MainMenu();
        Productos productos = new Productos();
        Ventana ventana = new Ventana(facturas, clientes, mainMenu, productos);
        MainMenuController mainMenuController = new MainMenuController(mainMenu, ventana, dataBaseSession);
        FacturasController facturasController = new FacturasController(facturas, dataBaseSession);
        ClientesController clientesController = new ClientesController(clientes, dataBaseSession);
        ProductosController productosController = new ProductosController(productos, dataBaseSession);
    }
}
