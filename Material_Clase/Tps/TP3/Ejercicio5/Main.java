package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        Arreglo unArreglo = new Arreglo();
        int CANTIDAD_HILOS = 8;

        // Creacion e iniciacion de hilos
        Thread trenHilos[] = new Thread[CANTIDAD_HILOS];
        int fraccion = (unArreglo.getLongitud() / CANTIDAD_HILOS);

        unArreglo.rellenarArreglo();

        for (int i = 0; i < CANTIDAD_HILOS; i++) {
            int desde = i * fraccion;
            int hasta = (i == CANTIDAD_HILOS - 1) ? unArreglo.getLongitud() : desde + fraccion;
            trenHilos[i] = new Thread(new HilosCalculadores(unArreglo, desde, hasta));
            trenHilos[i].start();
        }

        // Recorremos el array para ir esperando que cada hilo termine su ejecucion.
        for (int i = 0; i < CANTIDAD_HILOS; i++) {
            try {
                trenHilos[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        System.out.println("La suma del arreglo es de: " + unArreglo.getSumaFinal());
    }
}
