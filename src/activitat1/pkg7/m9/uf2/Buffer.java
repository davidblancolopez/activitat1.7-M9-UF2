package activitat1.pkg7.m9.uf2;

import java.util.ArrayList;

public class Buffer {

    //Array on es guardaran i s'agafaran els valors.
    private int[] buffer = new int[10];

    int comptadorRetirar = 0, comptadorIngresar = 0;

    private boolean contenedorLleno = Boolean.FALSE;

    /**
     * Metode que s'encarrega de retirar els diners. Si no es pot accedir es
     * quedara en el bucle esperant fins que pugi i llavors realitzara la
     * operació.
     *
     * @param value
     */
    public synchronized void retirar() {

        while (!contenedorLleno) {
            try {
                wait();

            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en retirar -> " + e.getMessage());
            }
        }

        contenedorLleno = !contenedorLleno;

//        Inicialitzem l'apuntador que ens servira per mouren's per l'array utilitzant el modul de 10 per aixi mai superar 
//        la mida de l'array.
        int apuntador = comptadorRetirar % 10;

//        Condició que ens serveix per a comprobar que retirar no ha superat o esta igualat a ingresar, si es aixi
//        mostrara el missatge 'Buffer vacio...' i no es realitzara la acció de retirar.
        if (comptadorRetirar >= comptadorIngresar) {

            System.out.println("Buffer vacío...");

//        Si no es compleix llavors si es realitzara l' acció de retirar.
        } else {
            buffer[apuntador] = 0;

            if (comptadorIngresar >= comptadorRetirar + 1) {
                comptadorRetirar++;
            }
        }

//        El seguent bucle ens mostra tot el buffer.
        System.out.print("BUFFER [");
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i] + ",");
        }

//        Es mostra la posició en que esta l'apuntador de retirar.'
        int apuntadorRetirar = apuntador + 1;
        System.out.print("]" + "Posicio de treure" + apuntadorRetirar + "\n");

//       Es notifica a tots els fils que esta lliure el contenedor.
        contenedorLleno = !contenedorLleno;
        notifyAll();


    }

    /**
     * Metode que s'encarrega de realitzar l'ingres de diners. Si no es pot
     * accedir es quedara en el bucle esperant fins que pugi i llavors
     * realitzara la operació.
     *
     * @param value
     */
    public synchronized void ingresar(int value) {

        String num = String.valueOf(value);

        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en ingresar -> " + e.getMessage());
            }
        }

        contenedorLleno = !contenedorLleno;

        //Inicialitzem l'apuntador que ens servira per mouren's per l'array.
        int apuntador = comptadorIngresar % 10;

        
//        Condició que ens serveix per a comprobar que encara es poden seguir posan numeros a l'array.
//        si no es pot llavors mostra el missatge i no s'ingressen mes numeros fins que hi hagui un lloc lliure.
        if (comptadorIngresar >= comptadorRetirar + buffer.length) {

            System.out.println("Buffer lleno...");

//        Si no es compleix llavors si es realitzara l' acció d' ingressar.
        } else {
            buffer[apuntador] = value;
            comptadorIngresar++;
        }
        
//        El seguent bucle ens mostra tot el buffer.
        System.out.print("BUFFER [");
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i] + ",");

        }
        
//        Es mostra la posició en que esta l'apuntador d' ingressar.'
        int apuntadorIngressar = apuntador + 1;
        System.out.print("]" + "Posicio de meter" + apuntadorIngressar + "\n");

//       Es notifica a tots els fils que esta lliure el contenedor.
        contenedorLleno = !contenedorLleno;
        notifyAll();


    }
}
