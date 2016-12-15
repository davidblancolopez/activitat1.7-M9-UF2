
package activitat1.pkg7.m9.uf2;


public class Activitat17M9UF2 {
    
    private static Buffer compte;
    private static Thread[] ingres;  
    private static Thread[] retirada;



    private static final int CANTIDADRETIRADES = 5;
    private static final int CANTIDADINGRESOS = 5;


    /**
     * Metode Main que crea els fils de ingresos i retirades.
     * @param args 
     */
    public static void main(String[] args) {
        compte = new Buffer();
        

        ingres = new Thread[CANTIDADINGRESOS];
        retirada = new Thread[CANTIDADRETIRADES];
        for (int i = 0; i < CANTIDADRETIRADES; i++) {
            retirada[i] = new Thread(new Retirar(compte, i));
            retirada[i].start();
        }
        for (int j = 0; j < CANTIDADINGRESOS; j++) {
            ingres[j] = new Thread(new Ingres(compte, j));
            ingres[j].start();
        }

    }

}
