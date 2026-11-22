package Ejercicio1;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
    private Semaphore lugaresPiscina;

    public GestorPiscina(int capMaxima) {
        this.lugaresPiscina = new Semaphore(capMaxima);
    }

    public void entrarPiscina() throws InterruptedException {
        if (!this.lugaresPiscina.tryAcquire()) {
            System.out.println("La piscina esta llena, " + Thread.currentThread().getName() + " debe esperar...");
            this.lugaresPiscina.acquire();
        }
        System.out.println(Thread.currentThread().getName() + " ha entrado a la piscina...");
        Thread.sleep((int) Math.random() * 5000);
        System.out.println(Thread.currentThread().getName() + " ha salido de la piscina...");
        this.lugaresPiscina.release();
    }

}