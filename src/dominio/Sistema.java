/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 *
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Sistema implements Serializable{

    private ArrayList<Partida> listaPartidas = new ArrayList<>();
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    //Agregado para oblig2
    private Partida partida;
    private Partida replicada;

    ///////////////////////////////setters&getters///////////////////
    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    //Agregado para oblig2
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Partida getReplicada() {
        return replicada;
    }

    public void setReplicada(Partida replicada) {
        this.replicada = replicada;
    } 
    
        
    ///////////////////////////////metodos///////////////////
    
    //Modificado para oblig2
    public boolean aliasRepetido(String alias) {
        boolean estaRepetido = false;
        for (int i=0; i<this.listaJugadores.size(); i++){
            if (this.listaJugadores.get(i).getAlias().equals(alias)){
                estaRepetido = true;
            }
        }        
        return estaRepetido;
    }
    
    //Modificado para oblig2
    public void registroJugador(String nombre, String alias, int edad) {
        Jugador jugador = new Jugador(nombre, alias , edad);
        listaJugadores.add(jugador);
    }

    //Modificado para oblig2
    public ArrayList<Jugador> obtenerRanking() {
        Collections.sort(this.listaJugadores, Collections.reverseOrder());          //orden descendente 
        return listaJugadores;
    }
	
    //agrego partida a la lista y la ubico ordenada por hora
    public void registroPartida(Partida unaPartida) {
        this.listaPartidas.add(unaPartida);
        Collections.sort(listaPartidas, Collections.reverseOrder());
    }
    
    //Agregado para oblig2
    public Configuracion crearConfiguracion(int modo, int cantidad){
        //Modo1: Llega una. Modo2: LLegan todas. Modo3: Cant mov.
        Configuracion configuracion;
        if (modo == 1 || modo == 2){
            configuracion = new Configuracion(modo);
        }else{
            configuracion = new Configuracion(modo,cantidad);
        }
        
        return configuracion;
    }
    
    //Agregado para oblig2
    public void crearPartida(Configuracion configuracion, Jugador jugadorRojo, Jugador jugadorAzul){
        this.partida = new Partida(configuracion, jugadorRojo, jugadorAzul);
    }
    
}
