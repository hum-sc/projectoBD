package view.panels;


import view.*;

import java.awt.event.ActionListener;

public class Productos extends BigPanel{
    private Title title;
    private MenuPanel menuPanel;
    private Button consultarMenu;
    private Button agregarMenu;

    private ContentPanel verProductos;
    private TextField codigoBuscar;
    private Button buscar;
    private Button verTodos;
    private TextArea productos;

    private ContentPanel agregarProducto;
    private Text codigoLabel;
    private Text descripcionLabel;
    private Text precioLabel;

    private TextField codigoField;
    private TextField descripcionField;
    private TextField precioField;

    private Button agregarButton;

    public Productos(){
        super();
        title = new Title("Productos");
        title.setBounds(20, 30, 800, 50);

        createMenuPanel();
        createVerProductos();
        createAgregarProducto();

        add(title);
        add(menuPanel);
        add(verProductos);
        add(agregarProducto);
        setVisible(true);
        showAgregarProducto();
    }

    public void createMenuPanel(){
        menuPanel = new MenuPanel();
        menuPanel.setLocation(700,0);
        consultarMenu = new Button("Consultar", menuPanel.buttonsColor, "consultarMenu");
        agregarMenu = new Button("Agregar", menuPanel.buttonsColor, "agregarMenu");

        consultarMenu.setBounds(10, 200, 130, 40);
        agregarMenu.setBounds(10, 250, 130, 40);

        menuPanel.add(consultarMenu);
        menuPanel.add(agregarMenu);
    }

    public void createVerProductos(){
        verProductos = new ContentPanel();
        codigoBuscar = new TextField();

        buscar = new Button("Buscar", this.buttonsColor, "buscarProducto");
        verTodos = new Button("Ver todos", this.buttonsColor, "verTodos");
        productos = new TextArea("");

        codigoBuscar.setBounds(20, 10, 150, 30);
        buscar.setBounds(290, 10, 80, 30);
        verTodos.setBounds(380, 10, 100, 30);
        productos.setBounds(20, 50, 590, 340);

        verProductos.add(codigoBuscar);
        verProductos.add(buscar);
        verProductos.add(verTodos);
        verProductos.add(productos);

    }

    public void createAgregarProducto(){
        agregarProducto = new ContentPanel();
        codigoLabel = new Text("Codigo: ");
        descripcionLabel = new Text("Descripcion: ");
        precioLabel = new Text("Precio: ");

        codigoField = new TextField();
        descripcionField = new TextField();
        precioField = new TextField();

        agregarButton = new Button("Agregar", this.buttonsColor, "agregarProducto");

        codigoLabel.setBounds(20, 10, 100, 30);
        codigoField.setBounds(120, 10, 150, 30);

        descripcionLabel.setBounds(20, 50, 100, 30);
        descripcionField.setBounds(120, 50, 150, 30);

        precioLabel.setBounds(20, 90, 100, 30);
        precioField.setBounds(120, 90, 150, 30);

        agregarButton.setBounds(20, 130, 100, 30);

        agregarProducto.add(codigoLabel);
        agregarProducto.add(codigoField);
        agregarProducto.add(descripcionLabel);
        agregarProducto.add(descripcionField);
        agregarProducto.add(precioLabel);
        agregarProducto.add(precioField);
        agregarProducto.add(agregarButton);
    }

    public void showAgregarProducto(){
        verProductos.setVisible(false);
        agregarProducto.setVisible(true);
    }

    public void showVerProductos(){
        agregarProducto.setVisible(false);
        verProductos.setVisible(true);
    }

    public String getCodigoBuscar(){
        return codigoBuscar.getText();
    }

    public String getCodigoField(){
        return codigoField.getText();
    }

    public String getDescripcionField(){
        return descripcionField.getText();
    }

    public String getPrecioField(){
        return precioField.getText();
    }

    public void setActionListener(ActionListener actionListener){
        consultarMenu.addActionListener(actionListener);
        agregarMenu.addActionListener(actionListener);

        buscar.addActionListener(actionListener);
        verTodos.addActionListener(actionListener);
        agregarButton.addActionListener(actionListener);
    }

    public void setProductos(String productos){
        this.productos.setText(productos);
    }

}
