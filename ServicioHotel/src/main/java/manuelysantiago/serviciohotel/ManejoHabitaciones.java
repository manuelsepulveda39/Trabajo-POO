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
import java.io.*;

public class ManejoHabitaciones {
    
    private static ManejoHabitaciones instancia = null;
    ArrayList<Habitacion> habitaciones = new ArrayList<>();
    Lectura le = new Lectura();
    private final String archivo = "habitaciones.txt";

    public static ManejoHabitaciones obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejoHabitaciones();
        }
        return instancia;
    }
    
    public void menu(){
        boolean seguir = true;
        do{
            System.out.println("""
                                1. Crear habitaciones
                                2. Modificar habitacion
                                3. Ver habitaciones
                                4. salir""");
            int opcion = le.leerInt("Ingrese una opcion");
            switch (opcion){
                case 1 -> {
                    crearHabitaciones();
                    seguir = false;
                }
                case 2 -> {
                    modificarHabitacion();
                    seguir = false;
                }
                case 3 -> {
                    mostrarHabitaciones();
                    seguir = false;
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Numero no valido, intentelo de nuevo");
            }
        }while(seguir);
    }
    
    public void cargarHabitaciones() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int numHabi = Integer.parseInt(partes[0]);
                int capHabi = Integer.parseInt(partes[1]);
                String tipoHabi = partes[2];
                habitaciones.add(new Habitacion(numHabi, capHabi, tipoHabi));
            }
        } 
        catch (IOException e) {
            System.err.println("");
        }
    }

    private void guardarHabitaciones() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Habitacion habitacion : habitaciones) {
                bw.write(habitacion.getNumHabi()+","+habitacion.getCapHabi()+","+habitacion.getTipoHabi());
                bw.newLine();
            }
        } 
        catch (IOException e) {
            System.err.println("Error al guardar las habitaciones: " + e.getMessage());
        }
    }

    public void crearHabitaciones() {
        
        System.out.println("Creación de habitaciones:");
        int numHabitaciones = le.leerInt("Ingrese el numero de habitaciones que desea agregar");
        
        for (int i = 0; i < numHabitaciones; i++) {
            int numHabi = le.leerInt("Ingrese el número de habitación");
            int capHabi = le.leerInt("Ingrese la capacidad de la habitación");
            String tipoHabi = le.leerString("Ingrese el tipo de habitación");
            
            habitaciones.add(new Habitacion(numHabi, capHabi, tipoHabi));
        }
        
        if (!existeArchivo()) {
            crearArchivo();
        }
        
        guardarEnArchivo();
    }
    
    private boolean existeArchivo() {
        File archivoE = new File(archivo);
        return archivoE.exists();
    }

    private void crearArchivo() {
        try {
            File archivoC = new File(archivo);
            archivoC.createNewFile();
        } 
        catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        
    }
    
    private void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Habitacion habitacion : habitaciones) {
                writer.write(habitacion.getNumHabi()+","+habitacion.getCapHabi()+","+habitacion.getTipoHabi());
                writer.newLine();
            }
        } 
        catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public void modificarHabitacion() {
        mostrarHabitacionesDisponibles();
        int numHabitacion = le.leerInt("Ingrese el numero de la habitacion que desea modificar, recuerde que no puede estar ocupada");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumHabi() == numHabitacion && !habitacion.isOcupada()) {
                habitacion.setCapHabi(le.leerInt("Ingrese la nueva capacidad"));
                habitacion.setTipoHabi(le.leerString("Ingrese el nuevo tipo de habitación"));
                
                System.out.println("Habitación modificada correctamente");
                guardarHabitaciones();
                return;
            }
        }
        System.out.println("Habitación no encontrada u ocupada");
    }
    
    public void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones Disponibles:");
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.isOcupada()) {
                System.out.println(habitacion.toString());
            }
        }
    }
    
    public void mostrarHabitaciones() {
        System.out.println("Lista de habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }
    
    public void mostrarHabitacion(String id){
        for (Habitacion habitacion : habitaciones){
            if(habitacion.getResidente() != null && habitacion.getResidente().getId().equals(id)){
                System.out.println(habitacion.toString());
            }
        }
    }
    
    public void asignarResidente(Cliente residente){
        boolean seguir = true;
        do{
            mostrarHabitacionesDisponibles();
            int numHabitacion = le.leerInt("Ingrese el numero de la pieza");
            for (Habitacion habitacion : habitaciones){
                if(habitacion.getNumHabi() == numHabitacion && !habitacion.isOcupada()){
                    habitacion.ocupar(residente);
                    return;
                }
            }
            System.out.println("Habitacion no encontrada u ocupada, intente de nuevo");
        } while(seguir);
    }
    
    public void salidaResidente(Cliente residente) {
        for (Habitacion habitacion : habitaciones) {
            Cliente habitacionResidente = habitacion.getResidente();
            if (habitacionResidente != null && habitacionResidente.equals(residente)) {
                habitacion.desocupar();
            }
        }
    }
}
