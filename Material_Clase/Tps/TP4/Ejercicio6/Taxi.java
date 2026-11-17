package Ejercicio6;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore esperandoPorCliente;
    private Semaphore enViaje;
    private Semaphore taxiOcupado;

    public Taxi() {
        this.enViaje = new Semaphore(0);
        this.taxiOcupado = new Semaphore(1);
        this.esperandoPorCliente = new Semaphore(0);
    }

    public void tomarTaxi() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esta recorriendo la calle en busca de un taxista");
        this.taxiOcupado.acquire();
        Thread.sleep(300);
        System.out.println(Thread.currentThread().getName() + " ha encontrado un taxi libre! Se esta subiendo...");
        Thread.sleep(1000);
        this.esperandoPorCliente.release();
        this.enViaje.acquire();
        System.out.println(Thread.currentThread().getName() + " se baja del taxi y sigue su camino");
    }

    public void manejarTaxi() throws InterruptedException {
        System.out.println("El Taxista esta esperando por personas a las cuales llevar, mientras tanto, duerme...");
        this.esperandoPorCliente.acquire();
        System.out.println("Se ha subido una persona al Taxi, el taxista comienza a manejar...");
        Thread.sleep(5000);
        System.out.println("El taxista ha llegado a destino...");
        this.enViaje.release();
        Thread.sleep(300);
        this.taxiOcupado.release();
    }
}
