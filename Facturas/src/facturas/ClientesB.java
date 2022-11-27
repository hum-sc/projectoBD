//NETEAM
package facturas;

import java.sql.CallableStatement; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.DriverManager;

public class ClientesB {
    public ClientesB(){
    }
    
    void insertaClienteP(Connection conn, Cliente cliente)throws Exception{
        CallableStatement cs = null;
        
        try{
            String plSQL = "{ call pr_alta_cliente(?,?,?,?)";
            cs = conn.prepareCall (plSQL);
            cs.setString(1, cliente.getID());
            cs.setString(1, cliente.getNombre());
            cs.setString(1, cliente.getDomicilio());
            cs.setString(1, cliente.getTelefono());
            cs.execute();
        }catch (SQLException eSQL){
            throw eSQL;
        }
        
        String consultaCliente(Connection conn, Cliente cliente) throws Eception{
        CallableStatement cs = null;
        
        try{
            String plSQL = "{? = call fn_counsulta_cliente(?)}";
            cs = conn.prepareCall (plSQL);
            cs.setString(2, cliente.getID());
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
        }catch (SQLException eSQL){
            throw eSQL;
        }
        return cs.getString(1);
    }
    }
    
    void actualizaClienteM(Connection conn, Cliente cliente) throws SQLException{
        PreparedStatement ps =null;
        
        try{
            String sql = "UPDATE CLIENTE SET ="+cliente.getDomicilio()
                    +cliente.getTelefono()
                    +"WHERE id = '" + cliente.getID()+" ' ";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException eSQL){
            throw eSQL;
        }
    }
        void eliminarClienteC(Connection conn, Cliente cliente){
        }
        
        String generarListadoClientes(Connection conn)throws Exception{
        Statement st = null;
        ResultSet rs = null;
        String listado = "";
        
        try{
            String sql = "SELECT f.cliente_id as cliente_idF,"+
                    "c.nombre AS nombreC,"+
                    "c.domicilio AS domicilioC,"+
                    "c.telefono AS telefonoC,"+
                    "FORM FACTURA f, cliente c"+
                    "WHERE rfactura = f.numero and f.cliente_id = c.id"+
                    "ORDER BY f.cliente_id";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            
            listado = listado+"---------------------------------------";
            listado = listado+"ID     Nombre     Domiclio     Telefono";
            listado = listado+"---------------------------------------";
            while(rs.next()){
                listado = listado
                        +String.format("%"+(-10)+"s", rs.getString("cliente_idF"))
                        +String.format("%"+(-30)+"s", rs.getString("nombreC"))
                        +String.format("%"+20+"s", rs.getString("domicilioC"))
                        +String.format("%"+10+"s", rs.getString("telefonoC"))
                        +"\n";
                
            }
            listado = listado +"--------------------------------------";
            
        }catch(SQLException eSQL){
            return listado;
        }
    }
           
    }
}