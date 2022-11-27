//NETEAM
package facturas;

import java.util.Scanner;

public class Conexion {

    public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    int opcion = 0;
    int respuesta =0;
    
    do{
        System.out.println("\n\n-------------------------------");
        System.out.println("         GESTION DE FACTURAS       ");
        System.out.println("1. Registra a un cliente");
        System.out.println("2. Modifica a un cliente");
        System.out.println("3. Eliminar cliente");
        System.out.println("4. Consultar cliente");
        System.out.println("5. Registrar productos");
        System.out.println("6. Modificar productos");
        System.out.println("7. Eliminar productos");
        System.out.println("8. Consultar productos");
        System.out.println("9. Generar listado de clientes");
        System.out.println("10. Generar listado de productos");
        System.out.println("11. Consultar una factura");
        System.out.println("12. Salir");
        opcion = teclado.nextInt();
        teclado.nextLine();
       
        try{
            switch (opcion){
                case 1: insertarP(teclado);
                break;
                case 2: actualizarM(teclado);
                break;
                case 3: eliminarC(teclado);
                break;
                case 4: consultarO(teclado);
                break;
                case 5: insertarR(teclado);
                break;
                case 6: actualizarD(teclado);
                break;
                case 7: eliminarU(teclado);
                break;
                case 8: consultarL(teclado);
                break;
                case 9: generarListadoT();
                break;
                case 10: generarListadoS();
                break;
                case 11: generarListadoF();
                break;
            }catch (Exception e){
                System.out.println(e);        
            }
                System.out.println("Presiona Enter para continuar...");
                String enter = teclado.nextLine();
            }while (opcion != 12);
        }
        
        //metodos del CLIENTE
        private static void insertarP(Scanner teclado) throws Exception{
            Cliente cliente = new Cliente();
            System.out.println("---REGISTRA UN CLIENTE---");
            System.out.println("ID:");String ID = teclado.nextLine();
            cliente.getID();
            System.out.println("Nombre:");String Nombre = teclado.nextLine();
            cliente.getNombre();
            System.out.println("Domicilio:");String Domicilio = teclado.nextLine();
            cliente.getDomicilio();
            System.out.println("Telefono:");String Telefono = teclado.nextLine();
            cliente.getTelefono();
            
            new Clientes().insertaCliente (cliente);
        }
        
        private static void actualizarM(Scanner teclado) throws Exception{
            Cliente cliente = new Cliente();
            System.out.println("---MODIFICA UN CLIENTE---");
            System.out.println("ID:");String ID = teclado.nextLine();
            cliente.getID();
            System.out.println("Escoge el dato a modificar");
            System.out.println("1. Domicilio");
            System.out.println("2. Telefono");
            System.out.println("3. Salir");
            
            int respuesta = teclado.nextInt();
            teclado.nextLine();
            switch (respuesta){
                case 1:
                    System.out.println("Ingresa el Nuevo Domicilio");
                    String Domicilio = teclado.nextLine();
                    cliente.getDomicilio();
                    break;
                case 2:
                    System.out.println("Ingresa el Nuevo Telefono");
                    String Telefono = teclado.nextLine();
                    cliente.getTelefono();
                    break;
                default:
                    break;
            }
            new Clientes().actualizarCliente (cliente);
        }
       
        private static void eliminarC(Scanner teclado) throws Exception{
            Cliente cliente = new Cliente();
            System.out.println("---ELIMINA UN CLIENTE---");
            System.out.println("ID:");String ID = teclado.nextLine();
            cliente.getID();
            String clienteEliminar = new Cliente().consultaCliente (cliente);
            Object clienteConsultado = null;
            
            if (clienteConsultado != null) {
                new Clientes().eliminarCliente (cliente);
            }else{
                System.out.println("Cliente no existente");
            }
        }
        
        private static void consultarO(Scanner teclado) throws Exception{
            Cliente cliente = new Cliente();
            System.out.println("---CONSULTA UN CLIENTE---");
            System.out.println("ID:");String ID = teclado.nextLine();
            cliente.getID();
            
            String clienteConsultado = new Clientes().consultaCliente (cliente);
            if (clienteConsultado != null) {
                System.out.println("Estos son los datos del cliente");
                System.out.println("ID     Nombre     Domicilio     Telefono");
                System.out.println("----------------------------------------");
                System.out.println(clienteConsultado);
            }else{
                System.out.println("Cliente no existente");
            }
        }
        
        //metodos de PRODUCTO
        private static void insertarR(Scanner teclado) throws Exception{
            Producto producto = new Producto();
            System.out.println("---REGISTRA PRODUCTOS---");
            System.out.println("Codigo:");String codigo = teclado.nextLine();
            producto.getCodigo();
            System.out.println("Descripción:");String Descripcion = teclado.nextLine();
            producto.getDescripcion();
            System.out.println("Precio unitario:");String Precio = teclado.nextLine();
            producto.getPrecio();
            
            new Productos().insertaProducto (producto);
        }
        
        private static void actualizarD(Scanner teclado) throws Exception{
            Producto producto = new Producto();
            System.out.println("---MODIFICA Productos---");
            System.out.println("Codigo:");String Codigo = teclado.nextLine();
            producto.getCodigo();
            System.out.println("Escoge el dato a modificar");
            System.out.println("1. Descripción");
            System.out.println("2. Precio Unitario");
            System.out.println("3. Salir");
            
            int respuesta = teclado.nextInt();
            teclado.nextLine();
            switch (respuesta){
                case 1:
                    System.out.println("Ingresa la Nuevo Descripcion");
                    String Descripcion = teclado.nextLine();
                    producto.getDescripcion();
                    break;
                case 2:
                    System.out.println("Ingresa el Nuevo Precio Unitario");
                    String Precio = teclado.nextLine();
                    producto.getPrecio();
                    break;
                default:
                    break;
            }
            new Productos().actualizaProducto(producto);
        }
        
        private static void eliminarU(Scanner teclado) throws Exception{
            Producto producto = new Producto();
            System.out.println("---ELIMINA UN PRODUCTO---");
            System.out.println("Codigo:");String Codigo = teclado.nextLine();
            producto.getCodigo();
            String productoEliminar = new Producto().consultaProducto(producto);
            Object productoConsultado = null;
            
            if (productoConsultado != null) {
                new Productos().eliminaProducto (producto);
            }else{
                System.out.println("Producto no existente");
            }
        }
        
         private static void consultarL(Scanner teclado) throws Exception{
            Producto producto = new Producto();
            System.out.println("---CONSULTA PRODUCTOS---");
            System.out.println("Codigo:");String Codigo = teclado.nextLine();
            producto.getCodigo();
            
            String productoConsultado = new Producto().consultaProducto(producto);
            if (productoConsultado != null) {
                System.out.println("Estos son los datos del producto");
                System.out.println("Codigo     Descripcion     Precio Unitario");
                System.out.println("----------------------------------------");
                System.out.println(productoConsultado);
            }else{
                System.out.println("Producto no existente");
            }
        }
       //LISTADOS
         private static void generarListadoT() throws Exception{
             System.out.println("---LISTADO DE CLIENTES---");
             String listadoClientes = new Clientes().generarListadoClientes();
             System.out.println(listadoClientes);
         }
         
         private static void generarListadoS() throws Exception{
             System.out.println("---LISTADO DE PRODUCTOS---");
             String listadoProductos = new Productos().generarListadoProductos();
             System.out.println(listadoProductos);
         }
         
         private static void generarListadoF() throws Exception{
             System.out.println("---CONSULTAR FACTURA---");
             String listadoFacturas = new Facturas().generarListadoFacturas();
             System.out.println(listadoFacturas);
         }
         
         //Conexion de metodos
         public void insertaClienteP (Cliente cliente) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             
             try{
                 conn = connBD.abrirConexion();
                 new ClientesB().insertaClienteP(conn, cliente);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
         }
         
         public void consultaClienteP (Cliente cliente) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             ClientesB bloquesB = new ClientesB();
             String clienteAConsultar = null;
             try{
                 conn = connBD.abrirConexion();
                 clienteAConsultar = bloquesB.consultarCliente(conn, cliente);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
             return clienteAconsultar;
         }
         
         public void actualizaClienteM (Cliente cliente) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             
             try{
                 conn = connBD.abrirConexion();
                 new ClientesB().actualizaClienteM(conn, cliente);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
         }
         
         public void eliminarClienteC (Cliente cliente) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             
             try{
                 conn = connBD.abrirConexion();
                 new ClientesB().eliminarClienteC(conn, cliente);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
         }
         
         public String generarListadoClientes () thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             ClientesB bloquesB = new ClientesB();
             String Listado;
             
             try{
                 conn = connBD.abrirConexion();
                 listado = bloquesB.generarListadoClientes(conn);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
             return listado;
         }
         
         public void insertaProductoR (Producto producto) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             
             try{
                 conn = connBD.abrirConexion();
                 new ProductoB().insertaProductoR(conn, producto);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
         }
         
         public String consultaProducto (Producto producto) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             ProductoB bloquesB = new ProductoB();
             String productoAConsultar = null;
             
             try{
                 conn = connBD.abrirConexion();
                 productoAConsultar = bloquesB.consultaProducto(conn, producto);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
             return productoAConsultar;
         }
         
         public void actualizaProductoD (Producto producto) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             
             try{
                 conn = connBD.abrirConexion();
                 new ProductoB().actualizaProductoD(conn, producto);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
         }
         
         public void eliminaClienteU (Producto producto) thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             
             try{
                 conn = connBD.abrirConexion();
                 new ProductoB().elimienaProductoU(conn, producto);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
         }
         
         public void generarListadoProductos () thrwos Exception{
             Connection conn = null;
             ConexionBD connBD = new ConexionBD;
             ProductoB bloquesB = ProductoB();
             String listado;
             
             try{
                 conn = connBD.abrirConexion();
                 listado = bloquesB.generarListadoProducto(conn);
             }catch (Exception e){
                 throw e;
             }
             finally{
                 connBD.cerrarConexion(conn);
             }
             return listado;
         }
}