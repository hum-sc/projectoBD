package controller;

import dataBase.DataBaseSession;
import view.panels.Clientes;

import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ClientesController implements ActionListener {
    private Clientes clientes;
    private DataBaseSession dataBaseSession;
    private boolean isClienteCreated = false;
    public ClientesController(Clientes clientes, DataBaseSession dataBaseSession){
        this.clientes = clientes;
        this.clientes.setActionListener(this);
        this.dataBaseSession = dataBaseSession;
    }

    private void consultarPanel(){
        clientes.showConsultarPanel();
    }
    private void registrarPanel(){
        clientes.showRegistrarPanel();
    }
    private void actualizarPanel(){
        clientes.showActualizarPanel();
    }
    private void consultarNombre(){
        String nombre = clientes.getNombreConsulta();
        try{
            String data = dataBaseSession.llamarFuncion("getClienteByNombre", new String[]{nombre});
            clientes.setTextConsultaArea(data);
        }catch (Exception e){
            clientes.setTextConsultaArea("Error: \n" + e.getMessage());
        }
    }

    private void consultarRut(){
        String rut = clientes.getRutConsulta();
        try{
            String data = dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut});
            clientes.setTextConsultaArea(data);
        }catch (Exception e){
            clientes.setTextConsultaArea("Error: \n" + e.getMessage());
        }
    }

    private void consultarTodos(){
        try{
            String data = dataBaseSession.llamarFuncion("getClientes", new String[]{});
            clientes.setTextConsultaArea(data);
        }catch (Exception e){
            clientes.setTextConsultaArea("Error: \n" + e.getMessage());
        }
    }

    private void eliminarConsulta(){
        String rut = clientes.getRutConsulta();
        try{
            dataBaseSession.llamarProcedimiento("deleteCliente", new String[]{rut});
            clientes.setTextConsultaArea("Cliente eliminado");
        } catch (Exception e){
            clientes.setTextConsultaArea("Error: \n" + e.getMessage());
        }
    }
    private void buscarRutActualizar(){
        String rut = clientes.getRutActualizar();
        try{
            String data = dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut});
            clientes.setTextDatosActualesArea(data);
            isClienteCreated = true;
        }catch (Exception e){
            isClienteCreated = false;
            clientes.setTextDatosActualesArea("Error: \n" + e.getMessage());
        }
    }
    private void registrarCliente(){
            String rut = clientes.getRutRegistro();
            String nombre = clientes.getNombreRegistro();
            String apellidoPat = clientes.getApellidoPatRegistro();
            String apellidoMat = clientes.getApellidoMatRegistro();
            String direccion = clientes.getDireccionRegistro();
            String telefono = clientes.getTelefonoRegistro();
            try{
                dataBaseSession.llamarProcedimiento("createCliente", new String[]{rut, nombre,apellidoPat, apellidoMat, direccion, telefono});
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al crear cliente: \n" + e.getMessage());
            }
    }

    private void actualizarNombre(){
        if (!isClienteCreated) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente con el rut ingresado");
            return;
        }
        String rut = clientes.getRutActualizar();
        String nombre = clientes.getNombreActualizar();
        try{
            dataBaseSession.llamarProcedimiento("updateNombreCliente", new String[]{rut, nombre});
            clientes.setTextDatosActualesArea(dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut}));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar nombre: \n" + e.getMessage());
        }
    }

    private void actualizarApellidoPat(){
        if (!isClienteCreated) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente con el rut ingresado");
            return;
        }
        String rut = clientes.getRutActualizar();
        String apellidoPat = clientes.getApellidoPatActualizar();
        try{
            dataBaseSession.llamarProcedimiento("updateApellidoPaternoCliente", new String[]{rut, apellidoPat});
            clientes.setTextDatosActualesArea(dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut}));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar apellido paterno: \n" + e.getMessage());
        }
    }

    private void actualizarApellidoMat(){
        if (!isClienteCreated) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente con el rut ingresado");
            return;
        }
        String rut = clientes.getRutActualizar();
        String apellidoMat = clientes.getApellidoMatActualizar();
        try{
            dataBaseSession.llamarProcedimiento("updateApellidoMaternoCliente", new String[]{rut, apellidoMat});
            clientes.setTextDatosActualesArea(dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut}));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar apellido materno: \n" + e.getMessage());
        }
    }

    private void actualizarDomicilio(){
        if (!isClienteCreated) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente con el rut ingresado");
            return;
        }
        String rut = clientes.getRutActualizar();
        String direccion = clientes.getDireccionActualizar();
        try{
            dataBaseSession.llamarProcedimiento("updateDomicilioCliente", new String[]{rut, direccion});
            clientes.setTextDatosActualesArea(dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut}));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar direccion: \n" + e.getMessage());
        }
    }

    private void actualizarTelefono(){
        if (!isClienteCreated ) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente con el rut ingresado");
            return;
        }
        String rut = clientes.getRutActualizar();
        String telefono = clientes.getTelefonoActualizar();
        try{
            dataBaseSession.llamarProcedimiento("updateTelefonoCliente", new String[]{rut, telefono});
            clientes.setTextDatosActualesArea(dataBaseSession.llamarFuncion("getClienteByRut", new String[]{rut}));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar telefono: \n" + e.getMessage());
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "consultarMenu":
                consultarPanel();
                break;
            case "registrarMenu":
                registrarPanel();
                break;
            case "actualizarMenu":
                actualizarPanel();
                break;
            case "consultarNombre":
                consultarNombre();
                break;
            case "consultarRut":
                consultarRut();
                break;
            case "consultarTodos":
                consultarTodos();
                break;
            case "eliminarConsulta":
                eliminarConsulta();
                break;
            case "registrarCliente":
                registrarCliente();
                break;
            case "buscarRutActualizar":
                buscarRutActualizar();
                break;
            case "actualizarNombre":
                actualizarNombre();
                break;
            case "actualizarApellidoPat":
                actualizarApellidoPat();
                break;
            case "actualizarApellidoMat":
                actualizarApellidoMat();
                break;
            case "actualizarDomicilio":
                actualizarDomicilio();
                break;
            case "actualizarTelefono":
                actualizarTelefono();
                break;
        }

    }
}
