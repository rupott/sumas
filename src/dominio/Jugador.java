/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 *
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Jugador implements Comparable<Jugador>, Cloneable, Serializable {

    private String nombre;
    private String alias;
    private int edad;
    private int puntaje;                    //Jugador comienza con 0 puntos

    public Jugador(String unNombre, String unAlias, int unaEdad) {
        this.nombre = unNombre;
        this.alias = unAlias;
        this.edad = unaEdad;
        this.puntaje = 0;
    }
//////////////////////////////setters&getters///////////////////////////////////////////////////////////
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getEdad() {
        return edad;
    }
    
    
//////////////////////////////metodos&overrides///////////////////////////////////////////////////////////
    public void modificarPuntaje() {
        this.puntaje++;
    }

    @Override
    public int compareTo(Jugador unJugador) {
        return (this.getPuntaje() - unJugador.getPuntaje());
    }

    @Override
    protected Jugador clone() throws CloneNotSupportedException {
        return (Jugador) super.clone();
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
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.alias, other.alias)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getAlias();
    }
    
    
}
