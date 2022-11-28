package view.panels;

import view.*;
import view.windows.NuevaVenta;

import java.awt.event.ActionListener;

public class Facturas extends BigPanel {
    private MenuPanel menuFacturas;
    private Button nuevaFactura;
    private Button verFacturas;

    private ContentPanel verFacturasPanel;
    private TextField buscarFactura;
    private Button buscarFacturaButton;
    private Button eliminarFacturaButton;
    private Button verTodasFacturasButton;
    private TextArea responseFacturas;

    private ContentPanel nuevaFacturaPanel;
    private TextField numeroFactura;
    private TextField rut;
    private TextArea factura;
    private Button iniciarFacturaButton;
    private Button nuevaVentaButton;
    private Button finalizarFacturaButton;

    private Text rutLabel;
    private Text numeroFacturaLabel;



    private Title title;
    public Facturas(){
        super();
        title = new Title("Facturas");
        title.setLocation(170,30);

        createMenuFacturas();

        //Ver facturas panel
        createVerFacturasPanel();

        // crear factura panel

        createNuevaFacturaPanel();


        add(verFacturasPanel);
        add(title);
        add(menuFacturas);
        add(nuevaFacturaPanel);
        showVerFacturasPanel();
    }

    public String getNumeroFacturaVerFacturas(){
        return buscarFactura.getText();
    }
    public String getNumeroFacturaNuevaFactura(){
        return numeroFactura.getText();
    }
    public String getRutNuevaFactura(){
        return rut.getText();
    }
    public void setResponseFacturas(String response){
        responseFacturas.setText(response);
    }
    public void setFactura(String response){
        factura.setText(response);
    }

    public void setActionListener(ActionListener actionListener){
        nuevaFactura.addActionListener(actionListener);
        verFacturas.addActionListener(actionListener);
        buscarFacturaButton.addActionListener(actionListener);
        eliminarFacturaButton.addActionListener(actionListener);
        verTodasFacturasButton.addActionListener(actionListener);
        nuevaVentaButton.addActionListener(actionListener);
        iniciarFacturaButton.addActionListener(actionListener);
        finalizarFacturaButton.addActionListener(actionListener);
    }
    private void createMenuFacturas(){
        menuFacturas = new MenuPanel();
        menuFacturas.setLocation(650,0);

        verFacturas = new Button("Ver", menuFacturas.buttonsColor);
        nuevaFactura = new Button("Crear", menuFacturas.buttonsColor);

        verFacturas.setBounds(10,200,130,40);
        nuevaFactura.setBounds(10,250,130,40);

        menuFacturas.add(verFacturas);
        menuFacturas.add(nuevaFactura);
    }

    private void createVerFacturasPanel(){
        verFacturasPanel = new ContentPanel();

        buscarFactura = new TextField();
        buscarFacturaButton = new Button("Buscar", this.buttonsColor);
        eliminarFacturaButton = new Button("Eliminar", this.buttonsColor);
        verTodasFacturasButton = new Button("Ver todas", this.buttonsColor);
        responseFacturas = new TextArea("");

        buscarFactura.setBounds(20,10,150,30);
        buscarFacturaButton.setBounds(200,10,80,30);
        eliminarFacturaButton.setBounds(290,10,80,30);
        verTodasFacturasButton.setBounds(380,10,100,30);
        responseFacturas.setBounds(20,50,460,340);

        verFacturasPanel.add(buscarFactura);
        verFacturasPanel.add(buscarFacturaButton);
        verFacturasPanel.add(responseFacturas);
        verFacturasPanel.add(eliminarFacturaButton);
        verFacturasPanel.add(verTodasFacturasButton);

    }

    private void createNuevaFacturaPanel(){
        nuevaFacturaPanel = new ContentPanel();

        numeroFactura = new TextField();
        rut = new TextField();

        numeroFacturaLabel = new Text("No. de factura");
        rutLabel = new Text("Rut");

        factura = new TextArea("");

        iniciarFacturaButton = new Button("Iniciar", this.buttonsColor);
        nuevaVentaButton = new Button("Nueva venta", this.buttonsColor);
        finalizarFacturaButton = new Button("Finalizar", this.buttonsColor);

        numeroFacturaLabel.setBounds(20,10,100,30);
        numeroFactura.setBounds(130,10,100,30);

        rutLabel.setBounds(20,50,30,30);
        rut.setBounds(60,50,250,30);

        iniciarFacturaButton.setBounds(320,50,100,30);
        factura.setBounds(20,100,460,250);

        nuevaVentaButton.setBounds(20,360,120,30);
        finalizarFacturaButton.setBounds(360,360,120,30);

        nuevaFacturaPanel.add(numeroFactura);
        nuevaFacturaPanel.add(rut);
        nuevaFacturaPanel.add(iniciarFacturaButton);
        nuevaFacturaPanel.add(nuevaVentaButton);

        nuevaFacturaPanel.add(numeroFacturaLabel);
        nuevaFacturaPanel.add(rutLabel);

        nuevaFacturaPanel.add(factura);
        nuevaFacturaPanel.add(finalizarFacturaButton);
    }

    public void showVerFacturasPanel(){
        nuevaFacturaPanel.setVisible(false);
        verFacturasPanel.setVisible(true);
    }
    public void showNuevaFacturaPanel(){
        nuevaFacturaPanel.setVisible(true);
        verFacturasPanel.setVisible(false);
    }
}
