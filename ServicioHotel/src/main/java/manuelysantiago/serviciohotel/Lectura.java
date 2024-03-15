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
            System.out.print(mensaje +", debe ser numero entero positivo: ");
            while (!sc.hasNextInt()) {
                System.out.println("Valor no valido");
                sc.next();
                System.out.print("Debe ser un numero entero positivo: ");
            }
            dato = sc.nextInt();
            if(dato <= 0){
                System.out.println("El numero debe ser positivo");
            }
        } while (dato <= 0);
        return dato;
    }
    public double leerDoble(String mensaje){
        System.out.println(mensaje + ": ");
        double dato;
        while (!sc.hasNextDouble()) {
            System.out.println("Valor no valido");
            sc.next();
            System.out.print("Debe ser un numero: ");
        }
        dato = sc.nextDouble();
        return dato;
    }
    
    public float leerFloat(String mensaje){
        System.out.println(mensaje + ": ");
        float dato;
        while (!sc.hasNextFloat()) {
            System.out.println("Valor no valido");
            sc.next();
            System.out.print("Debe ser un numero: ");
        }
        dato = sc.nextFloat();
        return dato;
    }
    
    public String leerString(String mensaje){
        System.out.println(mensaje+": ");
        String dato = sc.next();
        return dato;
    }
    
    public boolean leerBoolean(String mensaje) {
        System.out.print(mensaje + ", ingrese 's' para si o 'n' para no: ");
        while (true) {
            String entrada = sc.next().toLowerCase();
            if (entrada.equals("s")) {
                return true;
            } else if (entrada.equals("n")) {
                return false;
            } else {
                System.out.println("Valor no válido. Debe ser 's'  o 'n'. Inténtelo de nuevo: ");
            }
        }
    }
}
