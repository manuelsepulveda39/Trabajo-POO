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
        
        for (int i = 0; i< 2; i++){
            clientes.menu();
        }
    }
}
