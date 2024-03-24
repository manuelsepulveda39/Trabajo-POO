/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;
import java.time.LocalDateTime;

/**
 *
 * @author HP
 */
public class Aseo {
    
    private Empleado mucama;
    private Habitacion hab;
    private LocalDateTime fecha;

    public Aseo(Empleado mucama, Habitacion hab) 
    {
        this.mucama = mucama;
        this.hab = hab;
       fecha = LocalDateTime.now();
    }
    
    /**
     * @return the mucama
     */
    public Empleado getMucama() {
        return mucama;
    }

    /**
     * @param mucama the mucama to set
     */
    public void setMucama(Empleado mucama) {
        this.mucama = mucama;
    }

    /**
     * @return the hab
     */
    public Habitacion getHab() {
        return hab;
    }

    /**
     * @param hab the hab to set
     */
    public void setHab(Habitacion hab) {
        this.hab = hab;
    }

    /**
     * @return the fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aseo{");
        sb.append("mucama = ").append(mucama.getId());
        sb.append(", habitacion = ").append(hab.getNumHabi());
        sb.append(", fecha = ").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
