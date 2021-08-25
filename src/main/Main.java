package main;
import dominio.Sistema;
import interfaz.VentanaPrincipal;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        //modelo
        Sistema miSistema;
        try{//intento recuperar sistema anterior
            FileInputStream fff = new FileInputStream("archivo_sistema");
            BufferedInputStream bbb = new BufferedInputStream(fff);
            ObjectInputStream ooo = new ObjectInputStream(bbb);
            miSistema = (Sistema) ooo.readObject();
            ooo.close();
        }catch(IOException | ClassNotFoundException e){//creo sistema de cero
            miSistema = new Sistema();            
        }
        
        VentanaPrincipal menuPrincipal = new VentanaPrincipal(miSistema);
        menuPrincipal.setVisible(true);
    }

}