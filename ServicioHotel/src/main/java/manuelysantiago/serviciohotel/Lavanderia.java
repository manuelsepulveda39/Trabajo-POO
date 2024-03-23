/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;

/**
 *
 * @author Usuario
 */
public class Lavanderia {
    
    private static final double precio = 10000;
    private int numLavadas;
    private double total;

    public Lavanderia() {
        numLavadas = 0;
        total = 0;
    }
    
    public void agregarLavada() {
        numLavadas += 1;
        total = precio * numLavadas;
    }

    /**
     * @return the precio
     */
    public static double getPrecio() {
        return precio;
    }

    /**
     * @return the numLavadas
     */
    public int getNumLavadas() {
        return numLavadas;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lavanderia{");
        sb.append("numero de lavadas = ").append(numLavadas);
        sb.append(", total = ").append(total);
        sb.append('}');
        return sb.toString();
    }
    
    
}
