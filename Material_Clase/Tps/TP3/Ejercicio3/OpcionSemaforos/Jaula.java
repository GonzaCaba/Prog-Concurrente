package Ejercicio3.OpcionSemaforos;

import java.util.concurrent.Semaphore;

public class Jaula {
    private Semaphore mutexHamaca;
    private Semaphore mutexRueda;
    private Semaphore mutexPlato;

    public Jaula() {
        this.mutexHamaca = new Semaphore(1);
        this.mutexRueda = new Semaphore(1);
        this.mutexPlato = new Semaphore(1);
    }

    public boolean usarRueda() throws InterruptedException {
        boolean pudoObtener = this.mutexRueda.tryAcquire();
        if (pudoObtener) {
            System.out.println(Thread.currentThread().getName() + " esta corriendo en la rueda...");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " termino de usar la rueda.");
            this.mutexRueda.release();
        }
        return pudoObtener;
    }

    public boolean usarPlato() throws InterruptedException {
        boolean pudoObtener = this.mutexPlato.tryAcquire();
        if (pudoObtener) {
            System.out.println(Thread.currentThread().getName() + " esta comiendo del plato...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " termino de usar el plato de comida.");
            this.mutexPlato.release();
        }
        return pudoObtener;
    }

    public boolean usarHamaca() throws InterruptedException {
        boolean pudoObtener = this.mutexHamaca.tryAcquire();
        if (pudoObtener) {
            System.out.println(Thread.currentThread().getName() + " esta usando la Hamaca...");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " termino de usar la Hamaca.");
            this.mutexHamaca.release();
        }
        return pudoObtener;
    }
}
