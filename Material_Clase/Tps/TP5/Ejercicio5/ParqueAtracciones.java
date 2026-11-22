package Ejercicio5;

import java.util.concurrent.Semaphore;

public class ParqueAtracciones {
    private final int CANT_PASAJEROS_MAX;
    private int cant_pasajeros_actual;

    private Semaphore subirAlTren;
    private Semaphore llegadaDelTren;
    private Semaphore trenLleno;
    private Semaphore trenVacio;
    private Semaphore mutex;

    private Semaphore turnoTicket;
    private Semaphore vendedorEnEspera;
    private Semaphore ticketVendido;

    public ParqueAtracciones(int cantPasajeros) {
        this.CANT_PASAJEROS_MAX = cantPasajeros;
        this.cant_pasajeros_actual = 0;
        // Referidos a tren
        this.subirAlTren = new Semaphore(0, true);
        this.llegadaDelTren = new Semaphore(0);
        this.trenLleno = new Semaphore(0);
        this.trenVacio = new Semaphore(0);
        this.mutex = new Semaphore(1);
        // Referidos a ticket
        this.vendedorEnEspera = new Semaphore(0);
        this.turnoTicket = new Semaphore(1, true);
        this.ticketVendido = new Semaphore(0);

    }

    public void manejarTren() throws InterruptedException {
        this.subirAlTren.release(this.CANT_PASAJEROS_MAX);
        this.trenLleno.acquire();
        System.out.println("El tren comienza su viaje...");
        Thread.sleep(300);
        System.out.println("Chuqu chuqu chuqu chuqu..... CHU...CHU.... Chuqu chuqu chuqu chuqu...");
        Thread.sleep(3500);
        System.out.println("El tren ha llegado a destino. Comienza a bajarse los pasajeros.");
        this.llegadaDelTren.release(this.CANT_PASAJEROS_MAX);
        this.trenVacio.acquire();
    }

    public void comprarTickets() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " ha llegado al parque y se dirige a comprar un ticket");
        this.turnoTicket.acquire(); // Toma su turno para comprar el ticket.
        this.vendedorEnEspera.release(); // Despierta al vendedor para que lo atienda.
        this.ticketVendido.acquire();
        System.out.println(
                "Una vez adquirido el ticket el " + Thread.currentThread().getName() + " se dirige a tomar el tren");
        Thread.sleep(1500);
        this.turnoTicket.release();
    }

    public void venderTickets() throws InterruptedException {
        this.vendedorEnEspera.acquire(); // Si nadie esta esperando para comprar el vendedor duerme.
        System.out.println("El vendedor le vende un ticket al cliente para tomar el tren.");
        Thread.sleep(200);
        this.ticketVendido.release();
    }

    public void tomarTren() throws InterruptedException {
        // Subida al tren
        this.subirAlTren.acquire(); // Si adquiere un asiento habia lugar.
        this.mutex.acquire();
        // Mecanismo para llevar al ultimo pasajero
        this.cant_pasajeros_actual++;
        System.out.println(Thread.currentThread().getName() + " se ha subido al tren.");
        if (this.cant_pasajeros_actual == this.CANT_PASAJEROS_MAX) { // Si es el ultimo en entrar:
            this.trenLleno.release();
        }
        this.mutex.release();

        // Bajada del tren
        this.llegadaDelTren.acquire(); // Si adquiere el permiso significa que el tren ha llegado.
        this.mutex.acquire();
        this.cant_pasajeros_actual--;
        System.out.println(Thread.currentThread().getName() + " se ha bajado del tren");
        if (this.cant_pasajeros_actual == 0) {
            this.trenVacio.release();
        }
        this.mutex.release();
    }

}
