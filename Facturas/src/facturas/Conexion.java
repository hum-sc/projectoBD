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
        //hay que terminar todos los metodos para poder hacer este menu
        /*try{
            switch (opcion){
                case 1: insertar(teclado);
                break;
                case 2: actualizar(teclado);
                break;
            }catch (Exception e){
                System.out.println(e);        
            }
                System.out.println("Presiona Enter para continuar...");
                String enter = teclado.nextLine();
            }while (opcion != 12);
        }*/
        
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
}