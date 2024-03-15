/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
    private String nombre;
    private String id;
    private String telefono;
    private int numDias;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private ArrayList<Comida> comidas = new ArrayList<>();

    public Cliente(String nombre, String id, String telefono, int numDias) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.numDias = numDias;
        fechaIngreso = LocalDate.now();
        fechaSalida = fechaIngreso.plusDays(numDias);
    }
    
    public void agregarComida(String nombreC, double precioC, boolean chefFrances){
        getComidas().add(new Comida(nombreC, precioC, chefFrances));
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the numDias
     */
    public int getNumDias() {
        return numDias;
    }

    /**
     * @param numDias the numDias to set
     */
    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    /**
     * @return the fechaIngreso
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaSalida
     */
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the comidas
     */
    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + this.numDias;
        hash = 59 * hash + Objects.hashCode(this.fechaIngreso);
        hash = 59 * hash + Objects.hashCode(this.fechaSalida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.numDias != other.numDias) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        return Objects.equals(this.fechaSalida, other.fechaSalida);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("nombre=").append(nombre);
        sb.append(", id=").append(id);
        sb.append(", telefono=").append(telefono);
        sb.append(", fechaIngreso=").append(fechaIngreso);
        sb.append(", fechaSalida=").append(fechaSalida);
        sb.append('}');
        return sb.toString();
    }
}
