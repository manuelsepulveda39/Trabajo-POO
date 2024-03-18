/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;

/**
 *
 * @author Usuario
 */

public class Comida {
    private String nombre;
    private double precio;
    private boolean chefFrances;
    private double total;

    public Comida(String nombre, double precio, boolean chefFrances) {
        this.nombre = nombre;
        this.precio = precio;
        this.chefFrances = chefFrances;
        if(chefFrances){
            total = precio + (precio*0.15);
        }
        else{
            total = precio;
        }
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
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the chefFrances
     */
    public boolean isChefFrances() {
        return chefFrances;
    }

    /**
     * @param chefFrances the chefFrances to set
     */
    public void setChefFrances(boolean chefFrances) {
        this.chefFrances = chefFrances;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comida{");
        sb.append("nombre = ").append(nombre);
        sb.append(", precio = ").append(precio);
        sb.append(", chefFrances = ").append(chefFrances);
        sb.append(", total = ").append(total);
        sb.append('}');
        return sb.toString();
    }
}
