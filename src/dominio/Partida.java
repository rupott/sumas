/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 *
 */
package dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Partida implements Comparable<Partida>, Serializable {

    private ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
    private Configuracion configuracion;
    private Tablero tablero;
    private String turno;
    private LocalTime hora;
    private LocalDate fecha;
    private Jugador jugadorRojo;
    private Jugador jugadorAzul;
    private int movimientosRestantes = -1;
    private String ganador = "";

    public Partida(Configuracion unaConfiguracion, Jugador rojo, Jugador azul) {
        this.hora = LocalTime.now();
        this.fecha = LocalDate.now();
        this.configuracion = unaConfiguracion;
        this.tablero = new Tablero();
        this.turno = "rojo";
        this.jugadorRojo = rojo;
        this.jugadorAzul = azul;
        if (unaConfiguracion.getModoFinalizacion() == 3) {
            this.movimientosRestantes = unaConfiguracion.getCantidadMovimientos();
        }
    }

//////////////////////////////setters&getters/////////////////////////////////////////////////////////////////
    public LocalTime getHora() {
        return this.hora;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return this.listaMovimientos;
    }

    public String getGanador() {
        return this.ganador;
    }

    public String getTurno() {
        return turno;
    }

    public Jugador getJugadorRojo() {
        return jugadorRojo;
    }

    public Jugador getJugadorAzul() {
        return jugadorAzul;
    }

    public int getMovimientosRestantes() {
        return movimientosRestantes;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    //Agregado para oblig2
    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

///////////////////////////////metodos&overrides///////////////////////////////////////////////////////////    
    //cambia de turno y devuelve color del jugador actual
    public void pasarTurno() {
        if (this.turno.equals("rojo")) {
            this.turno = "azul";
        } else {
            this.turno = "rojo";
        }
    }

    //agrega movimientos a la lista de movimientos
    public void agregarMovimiento(Movimiento unMovimiento) {
        this.listaMovimientos.add(unMovimiento);
    }

    //se fija si termino el juego basandose en la configuracion
    public boolean terminoJuego(Configuracion configuracion) {
        boolean terminoJuego = false;
        int modo = configuracion.getModoFinalizacion();
        Ficha[][] elTablero = this.tablero.getTablero();
        int cantidadFichas;

        switch (modo) {
            case 1: //llega una ficha al otro lado
                for (int j = 0; j < elTablero[0].length && !terminoJuego; j++) {
                    if (elTablero[0][j].getColor().equals("rojo")) {
                        terminoJuego = true;
                        ganador = "rojo";
                    }
                }
                for (int j = 0; j < elTablero[0].length && !terminoJuego; j++) {
                    if (elTablero[elTablero.length - 1][j].getColor().equals("azul")) {
                        terminoJuego = true;
                        ganador = "azul";
                    }
                }
                if (!this.tablero.quedanMovimientos()) {
                    terminoJuego = true;
                    ganador = "empate";
                }
                break;
            case 2: //llegan todas las fichas al otro lado
                cantidadFichas = 0;
                for (int j = 0; j < elTablero[0].length; j++) {
                    if (elTablero[0][j].getColor().equals("rojo")) {
                        cantidadFichas++;
                    }
                }
                if (cantidadFichas == 8) {
                    terminoJuego = true;
                    ganador = "rojo";
                } else {
                    cantidadFichas = 0;
                }
                for (int j = 0; j < elTablero[0].length && !terminoJuego; j++) {
                    if (elTablero[elTablero.length - 1][j].getColor().equals("azul")) {
                        cantidadFichas++;
                    }
                }
                if (!terminoJuego && cantidadFichas == 8) {
                    terminoJuego = true;
                    ganador = "azul";
                }
                if (!this.tablero.quedanMovimientos()) {
                    terminoJuego = true;
                    ganador = "empate";
                }
                break;
            case 3: //termina por cantidad de movimientos
                if (this.movimientosRestantes == 0 || !this.tablero.quedanMovimientos()) {
                    terminoJuego = true;
                    int cantidadFichasRojas = 0;
                    int cantidadFichasAzules = 0;
                    for (int j = 0; j < elTablero[0].length; j++) {
                        if (elTablero[0][j].getColor().equals("rojo")) {
                            cantidadFichasRojas++;
                        }
                        if (elTablero[elTablero.length - 1][j].getColor().equals("azul")) {
                            cantidadFichasAzules++;
                        }
                    }
                    if (cantidadFichasAzules == cantidadFichasRojas) {
                        ganador = "empate";
                    } else {
                        if (cantidadFichasAzules > cantidadFichasRojas) {
                            ganador = "azul";
                        } else {
                            if (cantidadFichasAzules < cantidadFichasRojas) {
                                ganador = "rojo";
                            }
                        }
                    }
                }
                break;
        }

        return terminoJuego;
    }

    //se fija que el movimiento sea valido y en funcion de eso lo ejecuta o no
    public boolean moverFicha(Movimiento unMovimiento) {
        boolean fichaMovida = false;
        //datos del movimiento
        char direccion = unMovimiento.getDireccion();
        int numero = unMovimiento.getNumero();
        String color = unMovimiento.getColor();
        //posiciones
        int[] posicionActual = this.tablero.posicionActual(numero, color);
        int[] posicionFinal = this.tablero.posicionFinal(direccion, numero, color);
        //validaciones
        if (this.tablero.dentroDeTablero(posicionFinal[0], posicionFinal[1])) {
            if (this.tablero.lugarVacio(posicionFinal[0], posicionFinal[1])) {
                this.tablero.ejecutarMovimientoValido(direccion, numero, color, posicionActual, posicionFinal);
                agregarMovimiento(unMovimiento);    //agregamos movimiento a la lista
                fichaMovida = true;
                if (this.configuracion.getModoFinalizacion() == 3) {
                    this.movimientosRestantes--;
                }
            }
        }
        return fichaMovida;
    }

    //devuelve los movimientos gratis en una lista
    public ArrayList<Ficha> movimientosGratis() {
        ArrayList<Ficha> movimientosGratis = new ArrayList<>();

        //tomo el ultimo movimiento hecho de la lista de movimientos y me quedo con los datos
        Movimiento movimientoRealizado = this.listaMovimientos.get(this.listaMovimientos.size() - 1);
        int[] posicion = this.tablero.posicionActual(movimientoRealizado.getNumero(), movimientoRealizado.getColor());
        int posicionI = posicion[0];
        int posicionJ = posicion[1];
        int numeroFicha = movimientoRealizado.getNumero();

        int suma = 0;
        Ficha[][] miTablero = this.tablero.getTablero();

        //eje horizontal
        for (int j = 0; j < miTablero[0].length; j++) {
            suma += miTablero[posicionI][j].getNumero();
        }
        if (suma <= 8 && suma > 0 && !(suma == numeroFicha)) {
            //el color de la ficha a mover, es el color que corresponde al jugador actual, el numero es la suma de fichas
            Ficha fichaGratis = new Ficha(turno, suma);
            if (!movimientosGratis.contains(fichaGratis)) {
                movimientosGratis.add(fichaGratis);
            }
        }
        //eje vertical
        suma = 0;
        for (int i = 0; i < miTablero.length; i++) {
            suma += miTablero[i][posicionJ].getNumero();
        }
        if (suma <= 8 && suma > 0 && !(suma == numeroFicha)) {
            //el color de la ficha a mover, es el color que corresponde al jugador actual, el numero es la suma de fichas
            Ficha fichaGratis = new Ficha(turno, suma);
            if (!movimientosGratis.contains(fichaGratis)) {
                movimientosGratis.add(fichaGratis);
            }
        }
        //diagonal derecha abajo
        suma = 0;
        int j = posicionJ - 1;
        for (int i = posicionI; i < miTablero.length && j < miTablero[0].length - 1; i++) {
            j++;
            suma += miTablero[i][j].getNumero();
        }
        //diagonal izquierda arriba
        j = posicionJ;
        for (int i = posicionI - 1; i >= 0 && j > 0; i--) {
            j--;
            suma += miTablero[i][j].getNumero();
        }
        if (suma <= 8 && suma > 0 && !(suma == numeroFicha)) {
            //el color de la ficha a mover, es el color que corresponde al jugador actual, el numero es la suma de fichas
            Ficha fichaGratis = new Ficha(turno, suma);
            if (!movimientosGratis.contains(fichaGratis)) {
                movimientosGratis.add(fichaGratis);
            }
        }
        //diagonal derecha arriba
        suma = 0;
        j = posicionJ - 1;
        for (int i = posicionI; i >= 0 && j < miTablero[0].length - 1; i--) {
            j++;
            suma += miTablero[i][j].getNumero();
        }
        //diagonal izquierda abajo
        j = posicionJ;
        for (int i = posicionI + 1; i < miTablero.length && j > 0; i++) {
            j--;
            suma += miTablero[i][j].getNumero();
        }
        if (suma <= 8 && suma > 0 && !(suma == numeroFicha)) {
            //el color de la ficha a mover, es el color que corresponde al jugador actual, el numero es la suma de fichas
            Ficha fichaGratis = new Ficha(turno, suma);
            if (!movimientosGratis.contains(fichaGratis)) {
                movimientosGratis.add(fichaGratis);
            }
        }

        return movimientosGratis;
    }

    @Override
    public int compareTo(Partida unaPartida) {
        int resultado = 0;
        LocalTime horarioPartida = this.getHora();
        LocalDate fechaPartida = this.getFecha();
        LocalTime horarioUnaPartida = unaPartida.getHora();
        LocalDate fechaUnaPartida = unaPartida.getFecha();

        if (fechaPartida.isEqual(fechaUnaPartida)) {
            if (horarioPartida.compareTo(horarioUnaPartida) == 0) {
                resultado = 0;
            }
            if (horarioPartida.compareTo(horarioUnaPartida) < 0) {
                resultado = -1;
            }
            if (horarioPartida.compareTo(horarioUnaPartida) > 0) {
                resultado = 1;
            }
        }else{
            if (fechaPartida.isBefore(fechaUnaPartida)){
                resultado = -1;
            }else{
                resultado = 1;
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return this.jugadorRojo.getAlias() + " VS " + this.jugadorAzul.getAlias() + " - " + this.getHora() + " - " + this.getFecha();
    }

    //Agregado para obligatorio2
    //Devuelve array de posiciones validas para pintar el tablero
    public int[][] posValidas(int i, int j) {
        int[][] posiciones = new int[3][2];
        String color = this.tablero.getTablero()[i][j].getColor();
        int numero = this.tablero.getTablero()[i][j].getNumero();
        for (int k = 0; k < 3; k++) {
            char dir = ' ';
            switch (k) {
                case 0:
                    dir = 'A';
                    break;
                case 1:
                    dir = 'D';
                    break;
                case 2:
                    dir = 'I';
                    break;
            }
            int[] posFinal = this.tablero.posicionFinal(dir, numero, color);
            if (this.tablero.dentroDeTablero(posFinal[0], posFinal[1]) && this.tablero.lugarVacio(posFinal[0], posFinal[1])) {
                posiciones[k][0] = posFinal[0];
                posiciones[k][1] = posFinal[1];
            } else {
                posiciones[k][0] = -1;
                posiciones[k][1] = -1;
            }
        }
        return posiciones;
    }

}
