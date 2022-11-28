package view.windows;

import view.*;
import view.Button;
import view.TextArea;
import view.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NuevaVenta extends JFrame {
    Title title;
    TextField codigoProducto;
    TextField cantidad;

    TextArea producto;
    TextArea venta;

    Text codigoProductoText;
    Text cantidadText;
    Text productoText;
    Text ventaText;

    Button buscar;
    Button registrarVenta;
    Button listo;
    public NuevaVenta(){
        super("Nueva Venta");
        setSize(514,537);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.darkGray);

        title = new Title("Nueva Venta");
        codigoProductoText = new Text("Codigo del Producto:");
        cantidadText = new Text("Cantidad:");
        productoText = new Text("Producto encontrado:");
        ventaText = new Text("Venta registrada:");

        producto = new TextArea("");
        venta = new TextArea("");

        codigoProducto = new TextField();
        cantidad = new TextField();

        buscar = new Button("Buscar Producto", new Color(76, 76, 76));
        registrarVenta = new Button("Registrar Venta", new Color(76, 76, 76));
        listo = new Button("Listo", new Color(76, 76, 76));

        title.setBounds(20, 30, 200, 50);

        codigoProductoText.setBounds(20, 90, 150, 30);
        codigoProducto.setBounds(170, 90, 150, 30);
        buscar.setBounds(330, 90, 150, 30);

        productoText.setBounds(20, 130, 150, 30);
        producto.setBounds(20, 160, 446, 30);

        cantidadText.setBounds(20, 200, 150, 30);
        cantidad.setBounds(170, 200, 150, 30);
        registrarVenta.setBounds(330, 200, 150, 30);
        ventaText.setBounds(20, 240, 150, 30);
        venta.setBounds(20, 270, 446, 30);

        listo.setBounds(380, 450, 100, 30);

        getContentPane().add(title);
        getContentPane().add(codigoProductoText);
        getContentPane().add(cantidadText);
        getContentPane().add(productoText);
        getContentPane().add(codigoProducto);
        getContentPane().add(cantidad);
        getContentPane().add(producto);
        getContentPane().add(buscar);
        getContentPane().add(registrarVenta);
        getContentPane().add(ventaText);
        getContentPane().add(venta);
        getContentPane().add(listo);


        setVisible(true);
    }

    public String getCodigoProducto(){
        return codigoProducto.getText();
    }
    public String getCantidad(){
        return cantidad.getText();
    }

    public void setTextProducto(String text){
        producto.setText(text);
    }

    public void setTextVenta(String text){
        venta.setText(text);
    }

    public void setActionListener(ActionListener actionListener){
        listo.addActionListener(actionListener);
        registrarVenta.addActionListener(actionListener);
        buscar.addActionListener(actionListener);
    }
}
