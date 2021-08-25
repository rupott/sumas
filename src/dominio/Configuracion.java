/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 *
 */
package dominio;

import java.io.Serializable;

public class Configuracion implements Serializable{

    private int modoFinalizacion;
    private int cantidadMovimientos;

    public Configuracion(int unModo) {
        this.modoFinalizacion = unModo;
    }

    public Configuracion(int unModo, int unaCantidad) {
        this.modoFinalizacion = unModo;
        this.cantidadMovimientos = unaCantidad;
    }
    
//////////////////////////////setters&getters/////////////////////////////////////////////////////////////////
    public int getModoFinalizacion() {
        return modoFinalizacion;
    }

    public void setModoFinalizacion(int modoFinalizacion) {
        this.modoFinalizacion = modoFinalizacion;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }
    
}

