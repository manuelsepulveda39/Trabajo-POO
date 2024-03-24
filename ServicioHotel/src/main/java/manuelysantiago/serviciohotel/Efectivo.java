/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;

/**
 *
 * @author HP
 */
public class Efectivo implements PortalPagos{
    
    /*
    * Codigo basado en el grupo de Angeles
    */
    
    Lectura le = new Lectura();
    @Override
    public void realizarPago(double total) {
        System.out.println("se pagará en efectivo un monto de: " + total);
        confirmarPago(total);
    }

    @Override
    public void confirmarPago(double total) {
        String opcion = le.leerString("Ingrese Y para continuar");
        if(opcion.equalsIgnoreCase("Y"))
        {
            String confirm = le.leerString("Se recibió el dinero? (Y/N)");
            if(confirm.equalsIgnoreCase("Y"))
            {
                System.out.println("Pago Realizado");
            }
        }
    }
}
