/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package manuelysantiago.serviciohotel;

/**
 *
 * @author Usuario
 */

import java.util.ArrayList;

public class ManejoClientes {
    
    private static ManejoClientes instancia = null;
    Lectura le = new Lectura();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ManejoHabitaciones manejoHabitaciones = ManejoHabitaciones.obtenerInstancia();
    
    public static ManejoClientes obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejoClientes();
        }
        return instancia;
    }
    
    public void menu(){
        boolean seguir = true;
        do{
            System.out.println("""
                                1. Agregar un cliente 
                                2. Ver datos de un cliente 
                                3. Cambiar datos de un cliente 
                                4. Salida cliente
                                5. Registro comida 
                                6. Salir""");
            int opcion = le.leerInt("Ingrese una opcion");
            switch (opcion){
                case 1 -> {
                    agregarCliente();
                    seguir = false;
                }
                case 2 -> {
                    String idBuscar = String.valueOf(le.leerInt("Ingrese el id a buscar"));
                    verDatosCliente(idBuscar);
                    seguir = false;
                }
                case 3 -> {
                    modificarCliente();
                    seguir = false;
                }
                case 4 -> salidaCliente();
                case 5 -> registroComida();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Numero no valido, intentelo de nuevo");
            }
        }while(seguir);
    }
    
    public void agregarCliente() {
        String nombre = le.leerString("Ingrese el nombre del cliente");
        String id = String.valueOf(le.leerInt("Ingrese el id del cliente"));
        String telefono = String.valueOf(le.leerInt("Ingrese el telefono del cliente"));
        int numDias = le.leerInt("Ingrese el numero de dias que se va quedar el cliente");
        Cliente aux = new Cliente(nombre, id, telefono, numDias);
        clientes.add(aux);
        manejoHabitaciones.asignarResidente(aux);
    }
    
    public void verDatosCliente(String idBuscar){
        for (Cliente cliente : clientes){
            if(cliente.getId() != null && cliente.getId().equals(idBuscar)){
                System.out.println(cliente.toString());
                manejoHabitaciones.mostrarHabitacion(idBuscar);
            }
        }
    }
    
    public void modificarCliente(){
        String idModificar = String.valueOf(le.leerString("Ingrese el id a buscar"));
        for (Cliente cliente : clientes){
            if(cliente.getId().equals(idModificar)){
                cliente.setNombre(le.leerString("Ingrese el numero nombre"));
                cliente.setTelefono(String.valueOf(le.leerInt("Ingrese el numero numero de telefono")));
                
                System.out.println("Cliente modificado correctamente");
                return;
            }
        }
        System.out.println("Cliente no encontrando");
    }
    
    public void salidaCliente(){
        String idCliente = String.valueOf(le.leerInt("Ingrese el id del cliente"));
        verDatosCliente(idCliente);
        String opcion = le.leerString("Ingrese Y si esta seguro");
        if(opcion.equals("Y") || opcion.equals("y")){
            Cliente clienteAEliminar = null;
            for (Cliente cliente : clientes) {
                if (cliente.getId() != null && cliente.getId().equals(idCliente)) {
                    clienteAEliminar = cliente;
                    break;
                }
            }
        
            if (clienteAEliminar != null) {
                manejoHabitaciones.salidaResidente(clienteAEliminar);
                clientes.remove(clienteAEliminar);
                System.out.println("Cliente eliminado con exito");
            } else {
                System.out.println("Cliente no encontrando");
            }
        }
    }
    
    public void registroComida(){
        String idCliente = String.valueOf(le.leerInt("Ingrese el id del cliente"));
        for (Cliente cliente : clientes){
            if(cliente.getId() != null && cliente.getId().equals(idCliente)){
                String nombreC = le.leerString("Ingrese el nombre del producto");
                double precioC = le.leerFloat("Ingrese el precio del producto");
                boolean chefFrances = le.leerBoolean("chef Frances?");
                cliente.agregarComida(nombreC, precioC, chefFrances);
                System.out.println("Guardado con exito");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }
}
