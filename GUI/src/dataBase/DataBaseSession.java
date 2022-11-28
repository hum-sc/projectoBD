package dataBase;

import java.sql.CallableStatement;
import java.sql.Types;

public class DataBaseSession {
    Conexion con;
    public DataBaseSession() throws Exception{
        try{
            con = new Conexion();
        }catch(Exception e){
            throw e;
        }
    }

    public void llamarProcedimiento(String procedimiento, String[] parametros) throws Exception{
        CallableStatement cs = null;
        try{
            procedimiento = procedimiento+"(";
            for(int i = 0; i < parametros.length; i++){
                procedimiento = procedimiento+"?";
                if(i != parametros.length-1){
                    procedimiento = procedimiento+",";
                }
            }
            procedimiento = procedimiento+")";
            cs = con.getConexion().prepareCall("{call "+procedimiento+"}");
            for(int i = 0; i < parametros.length; i++){
                cs.setString(i+1, parametros[i]);
            }

            cs.execute();
        }catch(Exception e){
            throw e;
        }
    }

    public String llamarFuncion(String funcion, String[] parametros) throws Exception{
        CallableStatement cs = null;
        try{
            funcion = funcion+"(";
            for(int i = 0; i < parametros.length; i++){
                funcion = funcion+"?";
                if(i != parametros.length-1){
                    funcion = funcion+",";
                }
            }
            funcion = funcion+")";
            cs = con.getConexion().prepareCall("{? = call "+funcion+"}");
            for(int i = 0; i < parametros.length; i++){
                cs.setString(i+2, parametros[i]);
            }
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
        }catch(Exception e){
            throw e;
        }
        return cs.getString(1);
    }
}
