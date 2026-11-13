package Ejercicio5;

import java.util.Random;

public class Arreglo {
    private int sumaFinal;
    private final int[] arreglo;

    public Arreglo() {
        this.sumaFinal = 0;
        this.arreglo = new int[50000];
    }

    public int getLongitud() {
        return this.arreglo.length;
    }

    public int getSumaFinal() {
        return this.sumaFinal;
    }

    public int sumarSegmento(int desde, int hasta) {
        int sumaParcial = 0;
        for (int i = desde; i < hasta; i++) {
            sumaParcial += this.arreglo[i];
        }
        return sumaParcial;
    }

    public void rellenarArreglo() {
        Random numeroRandom = new Random();
        for (int i = 0; i < this.arreglo.length; i++) {
            this.arreglo[i] = numeroRandom.nextInt(10) + 1;
        }
    }

    public synchronized void sumarATotal(int sumaParcial) {
        this.sumaFinal += sumaParcial;
    }
}
