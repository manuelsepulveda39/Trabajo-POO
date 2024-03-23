/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package manuelysantiago.serviciohotel;

import java.util.HashSet;
import java.util.Set;

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
        ManejoEmpleados empleados = ManejoEmpleados.obtenerInstancia();
        
        
        boolean seguir = true;
        
        do{
            System.out.println(" 1. Menu Clientes \n 2. Menu Habitaciones \n 3.Menu Empleados");
            int opcion = le.leerInt("Ingrese una opcion");
            switch (opcion) {
                case 1 -> clientes.menu();
                case 2 -> habitaciones.menu();
                case 3 -> empleados.menuEmpleados();
                default -> seguir = false;
            }
        }while(seguir);
    }
}
