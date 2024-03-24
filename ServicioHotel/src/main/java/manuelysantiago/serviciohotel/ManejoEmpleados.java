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
    
    //Creacion de instancias
    Lectura le = new Lectura();
    private static ManejoEmpleados instancia = null;
    private static ManejoHabitaciones manejoHabitaciones = ManejoHabitaciones.obtenerInstancia();
    
    // Arraylists
    ArrayList<Empleado> recepcionistas = new ArrayList<>();
    ArrayList<Empleado> mucamas = new ArrayList<>();
    ArrayList<Empleado> chefs = new ArrayList<>();
    ArrayList<Aseo> aseos = new ArrayList();
    
    /*
    * matrices basadas en el codigo del grupo de Juan Jose Garzon
    */
    
    Empleado[][] horarioRecep = new Empleado[7][3];
    Empleado[][] horarioMuca = new Empleado[7][3];
    Empleado[][] horarioChef = new Empleado[7][3];
    
    //Metodo que devuelve instancia de la clase
    public static ManejoEmpleados obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejoEmpleados();
        }
        return instancia;
    }
    
    //Menu
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
            String nombre = le.leerString("Ingresa el nombre del recepcionista " + (i+1));
            String id = le.leerString("Ingresa el id del recepcionista " + (i+1));
           if(verificarId(id,recepcionistas))
            {
               Empleado aux = new Empleado(id, nombre);
               recepcionistas.add(aux);
            }
            else{
                i--;
                System.out.println("Ya existe un empleado con ese id, intentelo de nuevo");
            }
            
            
        }
        mostrarEmpleadoDispo(recepcionistas, horarioRecep, "recepcionistas");
    }
    
    public void horarioSemanaMucama()
    {
        System.out.println("_________________");
        int numRecep = le.leerInt("Cuantas mucamas hay");
        for(int i = 0; i < numRecep ; i++)
        {
            String nombre = le.leerString("Ingresa el nombre de la mucama " + (i+1) );
            String id = le.leerString("Ingresa el id de la mucama " + (i+1) );
            if(verificarId(id,mucamas))
            {
               Empleado aux = new Empleado(id, nombre);
               mucamas.add(aux);
            }
            else{
                i--;
                System.out.println("Ya existe un empleado con ese id, intentelo de nuevo");
            }
            
                       
        }
        mostrarEmpleadoDispo(mucamas, horarioMuca, "mucamas");
    }
     
    public void horarioSemanaChef()
    {
        System.out.println("_________________");
        int numRecep = le.leerInt("Cuantos chefs hay");
        for(int i = 0; i < numRecep ; i++)
        {
            String nombre = le.leerString("Ingresa el nombre del chef " + (i+1));
            String id = le.leerString("Ingresa el id del chef " + (i+1));
            if(verificarId(id,chefs))
            {
               Empleado aux = new Empleado(id, nombre);
               chefs.add(aux);
            }
            else{
                i--;
                System.out.println("Ya existe un empleado con ese id, intentelo de nuevo");
            }              
        }
        mostrarEmpleadoDispo(chefs, horarioChef, "chefs");
    }
    
    
    public boolean verificarId(String id, ArrayList<Empleado> empleados)
    {
        for(Empleado empleado : empleados)
        {
            if(empleado.getId().equals(id)){
                return false;
            }
        }
        return true;
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
   public void agregarEmpleado(ArrayList<Empleado> empleados, Empleado[][] matHorario, int i, int j) {
        boolean empleadoEncontrado = false;
        do {
            String idBuscar = String.valueOf(le.leerInt("Ingrese el id del empleado a escoger"));
            for (Empleado empleado : empleados) {
                if (empleado.getId() != null && empleado.getId().equals(idBuscar)) {
                    System.out.println(empleado.getNombre() + " ha sido seleccionad@");
                    matHorario[i][j] = empleado;
                    System.out.println("Agregad@ con éxito");
                    empleadoEncontrado = true;
                    break;
                }
            }
            if (!empleadoEncontrado) {
                // Aquí puedes manejar el caso en el que no se encuentre ningún empleado con el ID especificado.
                System.out.println("No se encontró ningún empleado con el ID especificado");
                if (!le.leerBoolean("¿Desea volver a intentarlo?")) {
                    // Si el usuario no desea volver a intentarlo, salir del bucle.
                    break;
                }
            }
        } while (!empleadoEncontrado);
    }

    
    public void mostrarHorario(Empleado[][] matHorario)
    {
        System.out.println("-----------------------------------");
        System.out.println("Horario");
        for(int i = 0; i < 7;i++)
        {
            System.out.println("Dia " + (i+1));
                        for(int j = 0; j < 3;j++)
            {
                System.out.println(matHorario[i][j].getNombre() + " en turno " + (j+1));
            
            }
        }
        System.out.println("-----------------------------------");
    }
    
    public void menuAseo()
    {
         System.out.println("""
                            1. Agregar Aseo
                            2. ver aseos realizados
                            3. salir""");
        int opcion = le.leerInt("Ingrese una opcion");
        switch (opcion){
            case 1 -> agregarAseo();
            case 2 -> mostrarListaAseo();
            case 3 -> {  return; }
           
            default -> System.out.println("Numero no valido, intentelo de nuevo");
        }
    }
    
    public void agregarAseo()
    {
        
        if(!mucamas.isEmpty())
        {
            String idMuc = null;
            int numHabi = 0;
            do
            {
             if(idMuc != null && ( verificarId(idMuc, mucamas) || manejoHabitaciones.verificarNumHab(numHabi)))
                {
                 System.out.println("Mucama o Habitación no encontrados");
                }
                idMuc = String.valueOf(le.leerInt("Ingrese su id"));
                numHabi = le.leerInt("Ingrese el numero de la habitación que limpió");
            
            }while(verificarId(idMuc, mucamas) || manejoHabitaciones.verificarNumHab(numHabi));
        
            Aseo aux = new Aseo(buscarEmp(idMuc, mucamas), manejoHabitaciones.buscarHab(numHabi));
            aseos.add(aux);
        }
        else
        {
            System.out.println("No hay aun mucamas registradas");
        }
        

    }
    
    public void mostrarListaAseo ()
    {
        System.out.println("Lista de aseos");
        for(Aseo aseo : aseos)
        {
            System.out.println(aseo.toString());
        }
    }
    public Empleado buscarEmp ( String id, ArrayList<Empleado> empleados)
    {
        for(Empleado empleado : empleados)
        {
            if(empleado.getId().equals(id))
            {
                return empleado;
            }   
        }
        return null;
    }
    
}

    
