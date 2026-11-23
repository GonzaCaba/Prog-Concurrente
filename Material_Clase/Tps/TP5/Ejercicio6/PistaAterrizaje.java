package Ejercicio6;

import java.util.concurrent.Semaphore;

public class PistaAterrizaje {
    private Semaphore pista;
    private Semaphore colaEsperaAterrizaje;
    private Semaphore colaEsperaDespegue;
    private Semaphore mutex;
    private boolean pistaLibre;
    private int esperandoAterrizar;
    private int esperandoDespegar;
    private int aterrizajesSeguidos;

    public PistaAterrizaje() {
        this.mutex = new Semaphore(1);
        this.pista = new Semaphore(1);
        this.colaEsperaAterrizaje = new Semaphore(0);
        this.colaEsperaDespegue = new Semaphore(0);
        this.pistaLibre = true;
        this.esperandoAterrizar = 0;
        this.esperandoDespegar = 0;
        this.aterrizajesSeguidos = 0;
    }

    public void pedirAterrizar() throws InterruptedException {
        this.mutex.acquire();
        if (pistaLibre) {
            pistaLibre = false;
            mutex.release();
        } else {
            esperandoAterrizar++;
            mutex.release();
            colaEsperaAterrizaje.acquire();
        }
        System.out.println("El " + Thread.currentThread().getName() + " ha solicitado permiso para aterrizar.");
    }

    public void pedirDespegue() throws InterruptedException {
        this.mutex.acquire();
        if (pistaLibre) {
            pistaLibre = false;
            mutex.release();
        } else {
            esperandoAterrizar++;
            mutex.release();
            colaEsperaAterrizaje.acquire();
        }
        System.out.println("El " + Thread.currentThread().getName() + " ha solicitado permiso para despegar.");
    }

    public void aterrizar() throws InterruptedException {
        this.mutex.acquire();
        aterrizajesSeguidos++;
        this.asignarPista();
        mutex.release();
    }

    public void terminarDespegue() throws InterruptedException {
        mutex.acquire();
        asignarPista();
        mutex.release();
    }

    private void asignarPista() throws InterruptedException {
        if (aterrizajesSeguidos >= 10 && esperandoDespegar > 0) {
            aterrizajesSeguidos = 0;
            esperandoDespegar--;
            colaEsperaDespegue.release(); // excepción: cada 10 aterrizajes gana el despegue
        } else if (esperandoAterrizar > 0) {
            esperandoAterrizar--;
            colaEsperaAterrizaje.release(); // prioridad normal: aterrizar
        } else if (esperandoDespegar > 0) {
            aterrizajesSeguidos = 0;
            esperandoDespegar--;
            colaEsperaDespegue.release();
        } else {
            System.out.println("El " + Thread.currentThread().getName()
                    + " ha recibido autorizacion para aterrizar. Procede con el mismo...");
            this.pistaLibre = false;
            Thread.sleep(1500);
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado de aterrizar");
        }
    }
}