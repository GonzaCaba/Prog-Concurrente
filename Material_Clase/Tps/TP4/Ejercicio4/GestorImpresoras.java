package Ejercicio4;

import java.util.concurrent.Semaphore;

public class GestorImpresoras {
    private boolean[] impresoras = { false, false, false, false, false };
    private int esperando = 0; // clientes dormidos en 'espera', protegido por mutex
    private Semaphore mutex;
    private Semaphore espera;

    public GestorImpresoras() {
        this.mutex = new Semaphore(1);
        this.espera = new Semaphore(0);
    }

    public void imprimirMaterial() throws InterruptedException {
        this.mutex.acquire();
        int impresora = this.buscarLibre();
        if (impresora == -1) {
            this.esperando++;
            this.mutex.release();
            this.espera.acquire();
            // Despierto con mutex heredado: la impresora liberada sigue libre
            impresora = this.buscarLibre();
        }
        this.impresoras[impresora] = true;
        this.mutex.release();

        System.out.println(Thread.currentThread().getName() + " esta imprimiendo en la impresora " + impresora + "...");
        Thread.sleep(3500);
        System.out.println(Thread.currentThread().getName() + " ha terminado de imprimir");

        this.mutex.acquire();
        this.impresoras[impresora] = false;
        if (this.esperando > 0) {
            this.esperando--;
            this.espera.release(); // paso el mutex al que espera, NO lo suelto
        } else {
            this.mutex.release();
        }
    }

    // Debe llamarse con mutex tomado
    private int buscarLibre() {
        int i = 0;
        while (i < this.impresoras.length && this.impresoras[i]) {
            i++;
        }
        return (i < this.impresoras.length) ? i : -1;
    }
}