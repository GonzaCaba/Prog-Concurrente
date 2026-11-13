package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Energia {
    private int valor;
    private Semaphore mutex;

    public Energia(int unValor) {
        this.valor = unValor;
        this.mutex = new Semaphore(1);
    }

    public int getEnergia() {
        return this.valor;
    }

    public void setEnergia(int nuevoValor) {
        this.valor = nuevoValor;
    }

    public boolean inflingirPuntos(int unaCantidad) throws InterruptedException {
        mutex.acquire();
        boolean puedeInflingir = (this.valor > 0);
        if (puedeInflingir) {
            System.out.println(Thread.currentThread().getName() + " esta infligiendo " + unaCantidad + " al jugador");
            this.valor += unaCantidad;
            mutex.release();
            Thread.sleep(1000);
            System.out.println("El jugador tiene " + this.valor + " puntos de energia");
        } else {
            mutex.release();
            System.out.println("Oh no! El jugador ha muerto!");
        }
        return puedeInflingir;
    }
}
