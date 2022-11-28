package dataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    Connection con;
    public Conexion()throws Exception{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/xepdb1","dev","dev");
        }catch(Exception e){
            throw e;
        }
    }

    public void abrirConexion() throws Exception{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle: thin:@//localhost:1522/xepdb1","dev","dev");
        }catch(SQLException e) {
            throw e;
        }
    }

    public void cerrarConexion()throws Exception{
        try{
            if(con != null) {
                con.close();
            }
        }catch(SQLException e) {
            throw e;
        }
    }

    public Connection getConexion(){
        return con;
    }
}