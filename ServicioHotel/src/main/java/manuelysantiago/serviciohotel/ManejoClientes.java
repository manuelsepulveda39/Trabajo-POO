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
        System.out.println("""
                            1. Agregar un cliente 
                            2. Ver datos de un cliente 
                            3. Cambiar datos de un cliente 
                            4. Salida cliente
                            5. Registro comida
                            6. Registro lavanderia
                            7. Salir""");
        int opcion = le.leerInt("Ingrese una opcion");
        switch (opcion){
            case 1 -> agregarCliente();
            case 2 -> {
                String idBuscar = String.valueOf(le.leerInt("Ingrese el id a buscar"));
                verDatosCliente(idBuscar);
            }
            case 3 -> modificarCliente();
            case 4 -> salidaCliente();
            case 5 -> registroComida();
            case 6 -> registroLavanderia();
            case 7 -> {
                return;
            }
            default -> System.out.println("Opcion no valida");
        }
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
                if (cliente.getId().equals(idCliente)) {
                    clienteAEliminar = cliente;
                    break;
                }
            }
        
            if (clienteAEliminar != null) {
                facturarCliente(clienteAEliminar);
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
            if(cliente.getId().equals(idCliente)){
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
    
    public double registroDañosYRobos()
    {
        double totalDañosYRobos = 0;
        if (le.leerBoolean("Se presentaron robos?")){
            totalDañosYRobos += le.leerDoble("Ingrese un valor estimado");
        }
        if (le.leerBoolean("Se presentaron daños?")){
            totalDañosYRobos += le.leerDoble("Ingrese un valor estimado");
        }
        return totalDañosYRobos;
    }
    
    public void registroLavanderia(){
        String idCliente = String.valueOf(le.leerInt("Ingrese el id del cliente"));
        for (Cliente cliente : clientes){
            if(cliente.getId().equals(idCliente)){
                cliente.agregarLavada();
                System.out.println("Lavada agrega con exito");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }
    
    public void facturarComida(Cliente cliente){
        System.out.println("Factura de comida:");
        for (Comida comida : cliente.getComidas()){
            System.out.println(comida.toString());
        }
        System.out.println("El total en comida es: " + cliente.getTotalComida());
    }
    
    public void facturarCliente(Cliente cliente){
        double total = registroDañosYRobos();
        
        System.out.println("---------------------------------");
        
        facturarComida(cliente);
        total += cliente.getTotalComida();
        
        System.out.println("---------------------------------");
        
        System.out.println(cliente.getLavanderia().toString());
        total += cliente.getLavanderia().getTotal();
        
        System.out.println("---------------------------------");
        
        double totalHabitacion = manejoHabitaciones.facturarHabitacion(cliente.getId());
        total += totalHabitacion;
        System.out.println("Total habitacion: "+ totalHabitacion);
        
        System.out.println("---------------------------------");
        
        System.out.println("Total a pagar: " + total);
    }
}
