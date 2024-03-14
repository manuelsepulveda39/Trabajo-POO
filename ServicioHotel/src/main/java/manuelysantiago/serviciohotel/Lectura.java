/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;

/**
 *
 * @author Usuario
 */

import java.util.Scanner;

public class Lectura {
    Scanner sc = new Scanner(System.in);
    
    public int leerInt(String mensaje){
        int dato;
        do {
            System.out.print(mensaje +", debe ser número entero positivo: ");
            while (!sc.hasNextInt()) {
                System.out.println("Valor no válido");
                sc.next();
                System.out.print("Debe ser un número entero positivo: ");
            }
            dato = sc.nextInt();
            if(dato <= 0){
                System.out.println("El número debe ser positivo");
            }
        } while (dato <= 0);
        return dato;
    }
    public double leerDoble(String mensaje){
        System.out.println(mensaje);
        double dato;
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Valor no válido");
            sc.next();
            System.out.print("Debe ser un número: ");
        }
        dato = sc.nextDouble();
        return dato;
    }
    
    public float leerFloat(String mensaje){
        System.out.println(mensaje);
        float dato;
        System.out.print(mensaje);
        while (!sc.hasNextFloat()) {
            System.out.println("Valor no válido");
            sc.next();
            System.out.print("Debe ser un número: ");
        }
        dato = sc.nextFloat();
        return dato;
    }
    
    public String leerString(String mensaje){
        System.out.println(mensaje+": ");
        String dato = sc.next();
        return dato;
    }
}
