
package activitat1.pkg7.m9.uf2;

import java.util.Random;

/**
 *
 * @author Jorge
 */
public class Ingres implements Runnable {

    private final Random aleatorio;
    private final CompteBancari contenedor;
    private final int TIEMPOESPERA = 1500;

    /**
     * Constructor de la clase Ingres.
     *
     * @param contenedor Contenedor comú a les retirades i els ingresos
     */
    public Ingres(CompteBancari contenedor, int idproductor) {
        this.contenedor = contenedor;
        aleatorio = new Random();
    }

    @Override
    /**
     * Implementació de la hebra
     */
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(10);
            
            contenedor.ingresar(poner);
            
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Error en run -> " + e.getMessage());
            }
        }
    }
}
