package Ejercicio3;

public class Jaula {
    private Object hamaca;
    private Object rueda;
    private Object platoComida;

    public Jaula() {
        this.hamaca = new Object();
        this.rueda = new Object();
        this.platoComida = new Object();
    }

    public void usarRueda() throws InterruptedException {
        synchronized (this.rueda) {
            System.out.println(Thread.currentThread().getName() + " esta corriendo en la rueda...");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " termino de usar la rueda.");
        }
    }

    public void usarPlato() throws InterruptedException {
        synchronized (this.platoComida) {
            System.out.println(Thread.currentThread().getName() + " esta comiendo del plato...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " termino de usar el plato de comida.");
        }
    }

    public void usarHamaca() throws InterruptedException {
        synchronized (this.hamaca) {
            System.out.println(Thread.currentThread().getName() + " esta usando la Hamaca...");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " termino de usar la Hamaca.");
        }
    }
}
