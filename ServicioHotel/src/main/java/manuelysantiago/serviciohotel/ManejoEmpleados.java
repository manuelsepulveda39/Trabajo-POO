/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;

import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class ManejoEmpleados {
    
    Lectura le = new Lectura();
    private static ManejoEmpleados instancia = null;
    ArrayList<Empleado> recepcionistas = new ArrayList<>();
    ArrayList<Empleado> mucamas = new ArrayList<>();
    ArrayList<Empleado> chefs = new ArrayList<>();
    Empleado[][] horarioRecep = new Empleado[7][3];
    Empleado[][] horarioMuca = new Empleado[7][3];
    Empleado[][] horarioChef = new Empleado[7][3];
    
    public static ManejoEmpleados obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejoEmpleados();
        }
        return instancia;
    }
    
    public void menuEmpleados(){
        System.out.println("""
                            1. Asignar Horario Recepcionistas
                            2. Asignar Horario Mucamas
                            3. Asignar Horario Chefs
                            4. salir""");
        int opcion = le.leerInt("Ingrese una opcion");
        switch (opcion){
            case 1 -> horarioSemanaRecep();
            case 2 -> horarioSemanaMucama();
            case 3 -> horarioSemanaChef() ;
            case 4 -> {
                return;
            }
            default -> System.out.println("Numero no valido, intentelo de nuevo");
        }
        
    }
    
    public void horarioSemanaRecep()
    {
        System.out.println("_________________");
        int numRecep = le.leerInt("Cuantos recepcionistas hay");
        for(int i = 0; i < numRecep ; i++)
        {
            String nombre = le.leerString("Ingresa el nombre del recepcionista " + (i+1) + ": ");
            String id = le.leerString("Ingresa el id del recepcionista " + (i+1) + ": ");
            Empleado aux = new Empleado(id, nombre);
            recepcionistas.add(aux);
            
            
        }
        mostrarEmpleadoDispo(recepcionistas, horarioRecep, "recepcionistas");
    }
    public void horarioSemanaMucama()
    {
        System.out.println("_________________");
        int numRecep = le.leerInt("Cuantas mucamas hay");
        for(int i = 0; i < numRecep ; i++)
        {
            String nombre = le.leerString("Ingresa el nombre de la mucama " + (i+1) + ": ");
            String id = le.leerString("Ingresa el id de la mucama " + (i+1) + ": ");
            Empleado aux = new Empleado(id, nombre);
            mucamas.add(aux);
                       
        }
        mostrarEmpleadoDispo(mucamas, horarioMuca, "mucamas");
    }
    
    public void horarioSemanaChef()
    {
        System.out.println("_________________");
        int numRecep = le.leerInt("Cuantos chefs hay");
        for(int i = 0; i < numRecep ; i++)
        {
            String nombre = le.leerString("Ingresa el nombre del chef " + (i+1) + ": ");
            String id = le.leerString("Ingresa el id del chef " + (i+1) + ": ");
            Empleado aux = new Empleado(id, nombre);
            chefs.add(aux);
            
            
        }
        mostrarEmpleadoDispo(chefs, horarioChef, "chefs");
    }
    public void mostrarEmpleadoDispo(ArrayList<Empleado> empleados, Empleado[][] matHorario, String cargo) 
    {
        System.out.println("Lista de :" + cargo);
       
        for (Empleado empleado : empleados)
        {
            System.out.println(empleado);
            
        }
        asignarHorario(empleados, matHorario);
    }
    
  
    public void asignarHorario(ArrayList<Empleado> empleados, Empleado[][] matHorario)
    {
        System.out.println("_____________________________________");
        System.out.println("A continuación se registrara el cronograma durante la semana de a 3 turnos de 8 horas por día \n Empieza con lunes 1");
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 3; j++)
            {
               System.out.println("TURNO(" + (i+1) + "/" + (j+1) + ")");
               agregarEmpleado(empleados,matHorario, i , j);
            }
        }
        mostrarHorario(matHorario);
        
    }
    public void agregarEmpleado( ArrayList<Empleado> empleados, Empleado[][] matHorario, int i, int j)
    {
        String idBuscar = le.leerString("Ingrese el id del empleado a escoger");
        for (Empleado empleado : empleados){
            if(empleado.getId() != null && empleado.getId().equals(idBuscar)){
                System.out.println(empleado.getNombre() + " ha sido seleccionad@");
                String opcion = le.leerString("Ingrese Y si esta seguro");
                if(opcion.equals("Y") || opcion.equals("y"))
                {
                    matHorario[i][j] = empleado;
                    System.out.println("Agregad@ con exito");
                }
            }
        }
      
    }
    
    public void mostrarHorario(Empleado[][] matHorario)
    {
        for(int i = 0; i < 7;i++)
        {
            System.out.println("Dia " + (i+1));
            for(int j = 0; j < 3;j++)
            {
                System.out.println("-----------------------------------");
                System.out.println("Horario");
                System.out.println(matHorario[i][j].getNombre() + " en turno " + (j+1));
                System.out.println("-----------------------------------");
            }
        }
    }
    
    
}

    
