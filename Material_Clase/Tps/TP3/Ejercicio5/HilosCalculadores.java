package Ejercicio5;

public class HilosCalculadores implements Runnable {
    private Arreglo unArreglo;
    private int desde;
    private int hasta;

    public HilosCalculadores(Arreglo unArreglo, int desde, int hasta) {
        this.unArreglo = unArreglo;
        this.desde = desde;
        this.hasta = hasta;
    }

    public void run() {
        int sumaParcial = unArreglo.sumarSegmento(this.desde, this.hasta);
        System.out.println("El Hilo " + Thread.currentThread().getName() + " ha terminado su suma parcial y es de: "
                + sumaParcial);
        this.unArreglo.sumarATotal(sumaParcial);
    }
}
