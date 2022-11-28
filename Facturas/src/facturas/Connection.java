//NETEAM
package facturas;

import java.sql.CallableStatement; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connection {

    public Connection abrirConexion () throws Exception{
    Connection conn = null;

    try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn= (Connection) DriverManager.getConnection ("jdbc:oracle: thin:@localhost:1522:XE","dev", "dev");
    
    } catch (SQLException eSQL) {
    }
        return conn;
    }

    public void cerrarConexion (Connection conn) throws Exception{

        if (conn != null) { 
            conn.close();
        }
    }

        private void close() {
            
        }

        CallableStatement prepareCall(String p1SQL) { 
            return null;
        }

        PreparedStatement prepareStatement (String sql) { 
            return null;
        }
        
       }

