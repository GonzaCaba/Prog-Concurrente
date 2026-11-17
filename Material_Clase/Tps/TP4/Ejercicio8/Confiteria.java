package Ejercicio8;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore mesa;
    private Semaphore esperaMozo;
    private Semaphore esperaCliente;
    private Semaphore inventandoPollo;

    public Confiteria() {
        this.mesa = new Semaphore(1);
        this.esperaMozo = new Semaphore(0);
        this.esperaCliente = new Semaphore(0);
        this.inventandoPollo = new Semaphore(0);
    }

    public void atenderCafeteria() throws InterruptedException {
        System.out.println("Mientras el mozo espera, disfruta inventando nuevas versiones de pollo frito...");
        this.inventandoPollo.acquire();
        System.out.println("El mozo atiende la mesa y le extiende la carta...");
        this.esperaMozo.acquire();
        System.out.println("El mozo ha anotado la orden y se pone manos a la obra..");
        Thread.sleep(3000);
        System.out.println("La comida ya esta lista, el mozo la lleva a la mesa...");
        Thread.sleep(400);
        this.esperaCliente.release();
        System.out.println("El mozo ha entregado la comida al cliente...");
        this.esperaMozo.acquire();
        System.out.println("El cliente ha liberado la mesa, el mozo la limpia y espera el proximo");
    }

    public void comerEnCafeteria() throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " ha llegado a la cafeteria y esta esperando para sentarse.");
        this.mesa.acquire();
        System.out.println(Thread.currentThread().getName() + " se sento en la mesa y llama al mozo");
        this.inventandoPollo.release();
        Thread.sleep(300);
        System.out.println(Thread.currentThread().getName() + " esta eligiendo de la carta...");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " ha elegido! Se lo informa al mozo");
        this.esperaMozo.release();
        Thread.sleep(400);
        System.out.println(Thread.currentThread().getName() + " esta esperando la comida...");
        this.esperaCliente.acquire();
        System.out.println(Thread.currentThread().getName() + " ya tiene la comida! Comienza a comer...");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()
                + " ha terminado de comer! Llama al mozo y le agradece, liberando la mesa.");
        this.esperaMozo.release();
        this.mesa.release();
    }
}
