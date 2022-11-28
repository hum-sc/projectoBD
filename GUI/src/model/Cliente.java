package model;

import dataBase.DataBaseSession;

import javax.xml.crypto.Data;
import java.net.http.WebSocketHandshakeException;

public class Cliente {
    private String data;
    private String rut;
    private DataBaseSession db;
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, int telefono, DataBaseSession db) throws Exception{
        this.db = db;
        this.rut = rut;
        this.db.llamarProcedimiento("createCliente", new String[]{rut,nombre,apellidoPaterno,apellidoMaterno,domicilio,Integer.toString(telefono)});
        this.data = this.db.llamarFuncion("getClienteByRut", new String[]{rut});
    }

    public Cliente(String rut, DataBaseSession db) throws Exception{
        this.db = db;
        this.rut = rut;
        this.data = this.getData();
    }
    public String getData() throws Exception {
        try{
            this.data = this.db.llamarFuncion("getClienteByRut", new String[]{this.rut});
        }catch(Exception e){
            this.data = "Error, vuelve a intentarlo despues"+e.getMessage();
            throw e;
        }
        return this.data;
    }

    public boolean updateNombre(String nombre) {
        try {
            this.db.llamarProcedimiento("updateNombreCliente", new String[]{this.rut, nombre});
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean updateApellidoPaterno(String apellidoPaterno) {
        try {
            this.db.llamarProcedimiento("updateApellidoPaternoCliente", new String[]{this.rut, apellidoPaterno});
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean updateApellidoMaterno(String apellidoMaterno) {
        try {
            this.db.llamarProcedimiento("updateApellidoMaternoCliente", new String[]{this.rut, apellidoMaterno});
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean updateDomicilio(String domicilio) {
        try {
            this.db.llamarProcedimiento("updateDomicilioCliente", new String[]{this.rut, domicilio});
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean updateTelefono(int telefono) {
        try {
            this.db.llamarProcedimiento("updateTelefonoCliente", new String[]{this.rut, Integer.toString(telefono)});
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Cliente delete(){
        try{
            this.db.llamarProcedimiento("deleteCliente", new String[]{this.rut});
            return null;
        }catch(Exception e){
            return this;
        }
    }
}
