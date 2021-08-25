package manejo_archivos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(File unPath) {
        try {
            out = new Formatter(unPath);
        } catch (FileNotFoundException e) {
            System.out.println("no se puede crear");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("sin permisos");
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}
