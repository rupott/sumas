/**
 *
 * @author Maria Jose Carbajal
 * @author Sebastian Curbelo
 *
 */
package dominio;

import java.io.Serializable;

public class Tablero implements Serializable{

    private Ficha[][] tablero = new Ficha[8][9];    //tablero de 8x9

    //con el constructor inicializamos el tablero
    public Tablero() {
        //fichas rojas en la ultima fila
        int i = this.tablero.length - 1;
        int numero = 9;
        for (int j = 0; j < this.tablero[0].length - 1; j++) {
            numero--;
            this.tablero[i][j] = new Ficha("rojo", numero);
        }
        //fichas azules en la primera fila
        i = 0;
        numero = 0;
        for (int j = 1; j < this.tablero[0].length; j++) {
            numero++;
            this.tablero[i][j] = new Ficha("azul", numero);
        }
        //fichas guion negro en el resto del tablero
        this.tablero[0][0] = new Ficha("negro", 0);
        this.tablero[this.tablero.length - 1][this.tablero[0].length - 1] = new Ficha("negro", 0);
        for (i = 1; i < this.tablero.length - 1; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {
                this.tablero[i][j] = new Ficha("negro", 0);
            }
        }
    }

    public Ficha[][] getTablero() {
        return tablero;
    }

//////////////////////////////metodos&overrides/////////////////////////////////////////////////////////// 
    //me pasan un movimiento ya validado, lo ejecuto y actualizo el tablero
    public void ejecutarMovimientoValido(char direccion, int numero, String color, int[] posicionActual, int[] posicionFinal) {
        Ficha aux = fichaEn(posicionFinal[0], posicionFinal[1]);
        //intercambio las fichas de lugar
        this.tablero[posicionFinal[0]][posicionFinal[1]] = this.tablero[posicionActual[0]][posicionActual[1]];
        this.tablero[posicionActual[0]][posicionActual[1]] = aux;
    }

    //dado un movimiento, saber a donde va a parar la ficha
    public int[] posicionFinal(char direccion, int numero, String color) {
        int[] posicionFinal = new int[2];
        int[] posicionActual = posicionActual(numero, color);
        //movimientos
        if (color.equalsIgnoreCase("rojo")) {                   //jugador rojo de abajo hacia arriba            
            posicionFinal[0] = posicionActual[0] - 1;
        } else {                                                          //jugador azul de arriba hacia abajo
            posicionFinal[0] = posicionActual[0] + 1;
        }
        if (direccion == 'A') {                                      //adelante
            posicionFinal[1] = posicionActual[1];
        }
        if (direccion == 'D') {                                      //derecha 
            posicionFinal[1] = posicionActual[1] + 1;
        }
        if (direccion == 'I') {                                       //izquierda 
            posicionFinal[1] = posicionActual[1] - 1;
        }
        return posicionFinal;
    }

    //dados los datos de la ficha, obtenidos del movimiento, encuentro su posicion
    public int[] posicionActual(int numero, String color) {
        int[] posicion = new int[2];
        boolean encontre = false;
        Ficha ficha = new Ficha(color, numero);         //ficha que estoy buscando
        for (int i = 0; i < this.tablero.length && !encontre; i++) {
            for (int j = 0; j < this.tablero[0].length && !encontre; j++) {
                if (ficha.equals(this.tablero[i][j])) {
                    encontre = true;
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    //verificar que la posicion final este dentro del tablero
    public boolean dentroDeTablero(int i, int j) {
        boolean dentro = true;
        if (!(i < this.tablero.length && j < this.tablero[0].length && i>=0 && j>=0)) {
            dentro = false;
        }
        return dentro;
    }

    //verificar que en la posicion final no haya ya una ficha
    public boolean lugarVacio(int i, int j) {
        boolean vacio = false;
        Ficha ficha = new Ficha("negro", 0);                      //comparo con ficha de lugar vacio 
        if (fichaEn(i, j).equals(ficha)) {
            vacio = true;
        }
        return vacio;
    }

    //dada una posicion, me fijo que hay ahi
    public Ficha fichaEn(int i, int j) {
        Ficha ficha = this.tablero[i][j];

        return ficha;
    }

    public boolean quedanMovimientos() {
        boolean quedanMovimientos = false;
        char direccion;
        int numero;
        String color;
        int[] posicionFinal;
        
        //me fijo todas las fichas rojas
        for (numero =1; numero<9 && !quedanMovimientos; numero++){
            color = "rojo";
            direccion = 'D';
            posicionFinal = posicionFinal(direccion, numero, color);
            if (dentroDeTablero(posicionFinal[0],posicionFinal[1]) && lugarVacio(posicionFinal[0], posicionFinal[1])){
                quedanMovimientos = true;
            }
            direccion = 'A';
            posicionFinal = posicionFinal(direccion, numero, color);
            if (dentroDeTablero(posicionFinal[0],posicionFinal[1]) && lugarVacio(posicionFinal[0], posicionFinal[1])){
                quedanMovimientos = true;
            }
            direccion = 'I';
            posicionFinal = posicionFinal(direccion, numero, color);
            if (dentroDeTablero(posicionFinal[0],posicionFinal[1]) && lugarVacio(posicionFinal[0], posicionFinal[1])){
                quedanMovimientos = true;
            }   
        }
        for (numero =1; numero<9 && !quedanMovimientos; numero++){
            color = "azul";
            direccion = 'D';
            posicionFinal = posicionFinal(direccion, numero, color);
            if (dentroDeTablero(posicionFinal[0],posicionFinal[1]) && lugarVacio(posicionFinal[0], posicionFinal[1])){
                quedanMovimientos = true;
            }
            direccion = 'A';
            posicionFinal = posicionFinal(direccion, numero, color);
            if (dentroDeTablero(posicionFinal[0],posicionFinal[1]) && lugarVacio(posicionFinal[0], posicionFinal[1])){
                quedanMovimientos = true;
            }
            direccion = 'I';
            posicionFinal = posicionFinal(direccion, numero, color);
            if (dentroDeTablero(posicionFinal[0],posicionFinal[1]) && lugarVacio(posicionFinal[0], posicionFinal[1])){
                quedanMovimientos = true;
            }
        }
        return quedanMovimientos;
    }
        
    
}
