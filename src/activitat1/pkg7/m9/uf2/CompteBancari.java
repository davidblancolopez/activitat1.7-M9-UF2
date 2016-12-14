
package activitat1.pkg7.m9.uf2;


public class CompteBancari {
    //Array on es guardaran i s'agafaran els valors.
    int contenedor [] = new int[10];
    private boolean contenedorLleno = Boolean.FALSE;

    /**
     * Metode que s'encarrega de retirar els diners. Si no es pot accedir 
     * es quedara en el bucle esperant fins que pugi i llavors realitzara la operació.
     * @param value 
     */
    public synchronized void retirar(int value) {

        while (contenedorLleno) {
            try {
                wait();
                
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en retirar -> " + e.getMessage());
            }
        }

        contenedorLleno = !contenedorLleno;
        
            


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
        
        
        
        contenedorLleno = !contenedorLleno;
        notifyAll();

    }
}
