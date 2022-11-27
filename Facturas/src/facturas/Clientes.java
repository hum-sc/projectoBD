//NETEAM
package facturas;

public class Clientes {
    void insertaCliente(Cliente cliente){
        System.out.println("\nEl grupo se ha dado de alta");
    }
    
    void actualizarCliente(Cliente cliente){
        System.out.println("\nEl cliente ha sido actualizado");
    }
    
    void eliminarCliente(Cliente cliente){
        System.out.println("\nEl cliente se ha eliminado");
    }
    
    String consultaCliente(Cliente cliente){
        return null;
    }
    
    String generarListadoClientes(){
        throw new UnsupportedOperationException();
    }
}
