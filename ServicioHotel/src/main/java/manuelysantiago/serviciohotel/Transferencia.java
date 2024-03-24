/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;
/**
 *
 * @author HP
 */

public class Transferencia implements PortalPagos{
    Lectura le = new Lectura();

    @Override
    public void realizarPago(double total) {
        System.out.println("Se pagará a través de un Qr el valor de: " + total);
        confirmarPago(total);
    }

    @Override
    public void confirmarPago(double total) {
        String opcion = le.leerString("Ingrese Y para continuar");
        if(opcion.equalsIgnoreCase("Y"))
        {
            
        }
    }

   
    
}
