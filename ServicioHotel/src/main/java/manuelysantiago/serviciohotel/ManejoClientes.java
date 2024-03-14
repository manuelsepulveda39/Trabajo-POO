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
            System.out.println("1.Agregar un cliente " + "\n 2.Ver datos de un cliente \n 3.Cambiar datos de un cliente \n 4. Salir");
            int opcion = le.leerInt("Ingrese una opcion");
            switch (opcion){
                case 1:
                    agregarCliente();
                    seguir = false;
                    break;
                case 2:
                    verDatosCliente();
                    seguir = false;
                    break;
                case 3:
                    modificarCliente();
                    seguir = false;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Numero no valido, intentelo de nuevo");
                    break;
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
    
    public void verDatosCliente(){
        String idBuscar = String.valueOf(le.leerString("Ingrese el id a buscar"));
        for (Cliente cliente : clientes){
            if(cliente.getId().equals(idBuscar)){
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
}
