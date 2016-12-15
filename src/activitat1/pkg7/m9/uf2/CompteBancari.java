
package activitat1.pkg7.m9.uf2;

import java.util.ArrayList;


public class CompteBancari {
    //Array on es guardaran i s'agafaran els valors.
    ArrayList<String> buffer = new ArrayList<String>();
    
    int comptadorRetirar = 0, comptadorIngresar = 0;

    private boolean contenedorLleno = Boolean.FALSE;

    /**
     * Metode que s'encarrega de retirar els diners. Si no es pot accedir 
     * es quedara en el bucle esperant fins que pugi i llavors realitzara la operació.
     * @param value 
     */
    public synchronized void retirar(int value) {

        while (!contenedorLleno) {
            try {
                wait();
                
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en retirar -> " + e.getMessage());
            }
        }
 
        buffer[comptadorRetirar] = ;

        contenedorLleno = !contenedorLleno;
        notifyAll();

    }

    /**
     * Metode que s'encarrega de realitzar l'ingres de diners. Si no es pot accedir 
     * es quedara en el bucle esperant fins que pugi i llavors realitzara la operació.
     * @param value 
     */
    public synchronized void ingresar(int value) {
        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en ingresar -> " + e.getMessage());
            }
        }
        
        
        
        
        contenedorLleno = !contenedorLleno;
        notifyAll();

    }
}
