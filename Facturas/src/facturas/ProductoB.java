//NETEAM
package facturas;

import java.sql.CallableStatement; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.DriverManager;



public class ProductoB {
    public ProductoB(){
    }
    
    void insertaProductoR(Connection conn, Producto producto) throws Exception{
        CallableStatement cs = null;
    
    
    try{
    String plSQL = "call pr_alta_producto(?,?,?)";
    cs = conn.prepareCall(plSQL);
    cs.setString(1, producto.getCodigo());
    cs.setString(2, producto.getDescripcion());
    cs.setDouble(3, producto.getPrecio());
    cs.execute();
    
    }catch(SQLException eSQL){
    throw eSQL;
    }
    }
    void eliminaProductoU(Connection conn, Producto producto){
        
    }
    String consultaProducto(Connection conn, Producto producto) throws Exception{
        CallableStatement cs = null;
    
        try{
        String plSQL = "{? = call fn_consulta_producto(?)}";
        cs = conn.prepareCall (plSQL);
        cs.setString(2, producto.getCodigo());
        cs.registerOutParameter(1, Types.VARCHAR);
    }catch(SQLException eSQL){
        throw eSQL;
    }
    return cs.getString(1);
    }
    
    void actualizaProductoD(Connection conn, Producto producto) throws SQLException{
        PreparedStatement ps = null;
        try{
            String sql= "UPDATE CLIENTE SET =" +producto.getDescripcion()
                    +producto.getPrecio()
                    +"WHERE id = '"+producto.getCodigo()+" ' ";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException eSQL){
            throw eSQL;
        }
    }

public String generarListadoProducto (Connection conn) throws Exception{
    Statement st = null;
    ResultSet rs = null;
    String listado = "";
try{
    String sql = "SELECT p.codigo as codigoP,"+
    "p.descripcion as descripcionP"+
    "p.precio_inutario as preciounitarioP"+
    "FROM FACTURA f, producto p"+
    "WHERE rfactura = d.factura_numero and p.codigo = d.producto_codigo"+
    "ORDER BY d.producto_codigo";

    st = conn.prepareStatement(sql);
    rs = st.executeQuery(sql);

    listado = listado+"----------------------------------";
    listado = listado+"Codigo     Descripcion       Precio unitario";
    listado = listado+"----------------------------------";
    while(rs.next()){
        listado = listado
    +String.format("%"+ (-10)+"s", rs.getString ("codigoP"))
    +String.format("%"+ (-30)+"s", rs.getString ("descripcionP"))
    +String.format("%"+ 20+"s", rs.getString ("preciounitarioP"))
    +"\n";
    }
listado = listado+"---------------------------------------";
    }catch(SQLException eSQL){

}
return listado;
}
}
