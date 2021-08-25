/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 *
 */
package dominio;

import java.io.Serializable;

public class Movimiento implements Serializable{

    private char direccion;
    private int numero;
    private String color;

    public Movimiento(String unColor, String unMovimiento) {
        this.color = unColor;
        char ficha = unMovimiento.charAt(0);
        this.numero = ficha - '0';
        this.direccion = unMovimiento.charAt(1);
    }

//////////////////////////////setters&getters/////////////////////////////////////////////////////////////////
    public char getDireccion() {
        return direccion;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }    

}
