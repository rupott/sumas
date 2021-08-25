/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 * 
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Ficha implements Serializable {
    
    private String color;
    private int numero;
    
    public Ficha(String unColor, int unNumero){
        this.color = unColor;
        this.numero = unNumero;
    }
//////////////////////////////setters&getters/////////////////////////////////////////////////////////////////
    public int getNumero() {
        return numero;
    }
    
        public String getColor() {    
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

//////////////////////////////metodos&overrides/////////////////////////////////////////////////////////// 
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
        final Ficha other = (Ficha) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }
    
}
