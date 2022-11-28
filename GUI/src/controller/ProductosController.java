package controller;

import dataBase.DataBaseSession;
import view.panels.Productos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductosController implements ActionListener {
    private Productos productos;
    private DataBaseSession dataBaseSession;
    public ProductosController(Productos productos, DataBaseSession dataBaseSession){
        this.productos = productos;
        this.productos.setActionListener(this);
        this.dataBaseSession = dataBaseSession;
    }

    private void buscarProducto(){
        String codigo = productos.getCodigoBuscar();
        try {
            String data = dataBaseSession.llamarFuncion("getProductoByCodigo", new String[]{codigo});
            productos.setProductos(data);
        } catch (Exception e) {
            productos.setProductos("Error al buscar el producto\n"+e.getMessage());
        }
    }

    public void verTodos(){
        try {
            String data = dataBaseSession.llamarFuncion("getProductos", new String[]{});
            productos.setProductos(data);
        } catch (Exception e) {
            productos.setProductos("Error al buscar los productos\n"+e.getMessage());
        }
    }
    public void agregarProducto(){
        String codigo = productos.getCodigoField();
        String descripcion = productos.getDescripcionField();
        String precio = productos.getPrecioField();
        try {
            dataBaseSession.llamarProcedimiento("createProducto", new String[]{codigo, descripcion, precio});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto\n"+e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "consultarMenu":
                productos.showVerProductos();
                break;
            case "agregarMenu":
                productos.showAgregarProducto();
                break;
            case "buscarProducto":
                buscarProducto();
                break;
            case "verTodos":
                verTodos();
                break;
            case "agregarProducto":
                agregarProducto();
                break;
        }

    }
}
