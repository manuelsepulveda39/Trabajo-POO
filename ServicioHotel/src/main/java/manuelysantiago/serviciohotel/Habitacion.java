/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manuelysantiago.serviciohotel;

/**
 *
 * @author Usuario
 */
public class Habitacion {
    
    private int numHabi;
    private int capHabi;
    private String tipoHabi;
    private boolean ocupada;
    private Cliente residente;

    public Habitacion(int numHabi, int capHabi, String tipoHabi) {
        this.numHabi = numHabi;
        this.capHabi = capHabi;
        this.tipoHabi = tipoHabi;
        ocupada = false;
    }
    
    public void ocupar(Cliente residente){
        this.residente = residente;
        ocupada = true;
    }
    
    public void desocupar(){
        residente = null;
        ocupada = false;
    }

    /**
     * @return the numHabi
     */
    public int getNumHabi() {
        return numHabi;
    }

    /**
     * @param numHabi the numHabi to set
     */
    public void setNumHabi(int numHabi) {
        this.numHabi = numHabi;
    }

    /**
     * @return the capHabi
     */
    public int getCapHabi() {
        return capHabi;
    }

    /**
     * @param capHabi the capHabi to set
     */
    public void setCapHabi(int capHabi) {
        this.capHabi = capHabi;
    }

    /**
     * @return the tipoHabi
     */
    public String getTipoHabi() {
        return tipoHabi;
    }

    /**
     * @param tipoHabi the tipoHabi to set
     */
    public void setTipoHabi(String tipoHabi) {
        this.tipoHabi = tipoHabi;
    }

    /**
     * @return the ocupada
     */
    public boolean isOcupada() {
        return ocupada;
    }

    /**
     * @return the residente
     */
    public Cliente getResidente() {
        return residente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("numHabi=").append(numHabi);
        sb.append(", capHabi=").append(capHabi);
        sb.append(", tipoHabi=").append(tipoHabi);
        sb.append(", ocupada=").append(ocupada);
        sb.append('}');
        return sb.toString();
    }
}
