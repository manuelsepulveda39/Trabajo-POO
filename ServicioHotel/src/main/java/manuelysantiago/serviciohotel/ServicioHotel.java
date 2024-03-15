/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package manuelysantiago.serviciohotel;

/**
 *
 * @author Usuario
 */

public class ServicioHotel {
    
    public static void main(String[] args) {
        
        ManejoHabitaciones habitaciones = ManejoHabitaciones.obtenerInstancia();
        habitaciones.cargarHabitaciones();
        ManejoClientes clientes = ManejoClientes.obtenerInstancia();
        Lectura le = new Lectura();
        
        boolean seguir = true;
        
        do{
            System.out.println(" 1. Menu clientes \n 2. Menu habitaciones");
            int opcion = le.leerInt("Ingrese una opcion");
            switch (opcion) {
                case 1 -> clientes.menu();
                case 2 -> habitaciones.menu();
                default -> seguir = false;
            }
        }while(seguir);
    }
}
