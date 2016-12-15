
package activitat1.pkg7.m9.uf2;

import java.util.Random;

/**
 *
 * @author ALUMNEDAM
 */
public class Retirar implements Runnable {

    private final Buffer contenedor;
    private final Random aleatorio;
    private final int TIEMPOESPERA = 1000;

    /**
     * Constructor de la clase Retirar.
     *
     * @param contenedor Contenedor comú a les retirades i els ingresos
     */
    public Retirar(Buffer contenedor, int idconsumidor) {
        this.contenedor = contenedor;
        aleatorio = new Random();
    }

    @Override
    /**
     * Implementació de la hebra
     */
    public void run() {
        while (Boolean.TRUE) {
                        
            contenedor.retirar();
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Error en run -> " + e.getMessage());
            }
        }
    }
}