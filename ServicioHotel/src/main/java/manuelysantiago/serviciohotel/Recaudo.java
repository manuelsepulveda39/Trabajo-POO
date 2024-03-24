/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Recaudo {
    
    private static Recaudo instancia = null;
    public static ArrayList<Double> extracto = new ArrayList<>();
    
     public static Recaudo obtenerInstancia() {
        if (instancia == null) {
            instancia = new Recaudo();
        }
        return instancia;
    }
    
    public void mostrarRecaudo()
    {
        LocalDate fecha = LocalDate.now();
        System.out.println("Caja del dia " + fecha);
        double cajaTotal = 0;
        for(double importe : extracto)
        {   
            int cont = 1;
            System.out.println(cont + ". " + importe);
            cont++;
            cajaTotal += importe;
            
        }
        System.out.println("Para un total de " + cajaTotal);
    }
}
