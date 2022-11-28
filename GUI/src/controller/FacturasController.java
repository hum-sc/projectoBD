package controller;

import dataBase.DataBaseSession;
import view.panels.Facturas;
import view.windows.NuevaVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturasController implements ActionListener {
    private Facturas facturas;
    private DataBaseSession dataBaseSession;
    private boolean isCreating;
    private boolean isProductoFound;
    private NuevaVenta nuevaVenta;
    public FacturasController(Facturas facturas, DataBaseSession dataBaseSession){
        this.facturas = facturas;
        this.dataBaseSession = dataBaseSession;
        isCreating = false;
        facturas.setActionListener(this);
    }

    private void buscarFactura(){
        String numeroFactura = facturas.getNumeroFacturaVerFacturas();
        try{
            String response = dataBaseSession.llamarFuncion("getFacturaByNum", new String[]{numeroFactura});
            facturas.setResponseFacturas(response);
        } catch (Exception e) {
            facturas.setResponseFacturas("Error al buscar factura\n"+ e.getMessage());
        }
    }

    public void verTodas(){
        try{
            String response = dataBaseSession.llamarFuncion("getFacturas", new String[]{});
            facturas.setResponseFacturas(response);
        } catch (Exception e) {
            facturas.setResponseFacturas("Error al buscar factura\n"+ e.getMessage());
        }
    }
    public void eliminarFactura(){
        String numeroFactura = facturas.getNumeroFacturaVerFacturas();
        try{
            dataBaseSession.llamarProcedimiento("deleteFactura", new String[]{numeroFactura});
            facturas.setResponseFacturas("Factura "+numeroFactura+" eliminada");
        } catch (Exception e) {
            facturas.setResponseFacturas("Error al eliminar la factura\n"+ e.getMessage());
        }
    }
    public void iniciarFactura(){
        String numeroFactura = facturas.getNumeroFacturaNuevaFactura();
        String rut = facturas.getRutNuevaFactura();
        try{
            dataBaseSession.llamarProcedimiento("createFactura", new String[]{numeroFactura, rut});
            String data = dataBaseSession.llamarFuncion("getFacturaByNum", new String[]{numeroFactura});
            facturas.setFactura(data);
            isCreating = true;
        } catch (Exception e) {
            facturas.setFactura("Error al iniciar la factura\n"+ e.getMessage());
        }
    }
    public void nuevaVenta(){
        if (isCreating){
            nuevaVenta = new NuevaVenta();
            nuevaVenta.setActionListener(this);
        }
    }
    public void buscarProducto(){
        String codigo = nuevaVenta.getCodigoProducto();
        try{
            String data = dataBaseSession.llamarFuncion("getProductoByCodigo", new String[]{codigo});
            nuevaVenta.setTextProducto(data);
            isProductoFound = true;
        } catch (Exception e) {
            nuevaVenta.setTextProducto("Error al buscar producto\n"+ e.getMessage());
        }
    }
    public void registrarVenta(){
        String codigo = nuevaVenta.getCodigoProducto();
        String cantidad = nuevaVenta.getCantidad();
        String numeroFactura = facturas.getNumeroFacturaNuevaFactura();
        if(isProductoFound) {
            try {
                dataBaseSession.llamarProcedimiento("createVenta", new String[]{cantidad, numeroFactura, codigo});
                String data = dataBaseSession.llamarFuncion("getVenta", new String[]{codigo, numeroFactura});
                nuevaVenta.setTextVenta(data);
                isProductoFound = false;
            } catch (Exception e) {
                nuevaVenta.setTextVenta("Error al registrar venta\n" + e.getMessage());
            }
        } else {
            nuevaVenta.setTextVenta("Ingrese datos validos");
        }
    }
    public void cerrandoCracionDeVenta(){
        isCreating = true;
        String numeroFactura = facturas.getNumeroFacturaNuevaFactura();
        try{
            String data = dataBaseSession.llamarFuncion("getFacturaByNum", new String[]{numeroFactura});
            facturas.setFactura(data);
            nuevaVenta.dispose();
        } catch (Exception e) {
            facturas.setFactura("Error al modificar la factura\n"+ e.getMessage());
        }
    }

    private void finalizarFactura(){
        isCreating = false;
        facturas.showVerFacturasPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Ver":
                facturas.showVerFacturasPanel();
                break;
            case "Crear":
                facturas.showNuevaFacturaPanel();
                break;
            case "Buscar":
                buscarFactura();
                break;
            case "Ver todas":
                verTodas();
                break;
            case "Eliminar":
                eliminarFactura();
                break;
            case "Iniciar":
                iniciarFactura();
                break;
            case "Nueva venta":
                nuevaVenta();
                break;
            case "Buscar Producto":
                buscarProducto();
                break;
            case "Registrar Venta":
                registrarVenta();
                break;
            case "Listo":
                cerrandoCracionDeVenta();
                break;
            case "Finalizar":
                finalizarFactura();
                break;
            default:
                System.out.println(e.getActionCommand());
                break;
        }
    }
}
