package Ejercicio5;

import java.util.concurrent.Semaphore;

public class GestorImpresoras {
    private boolean[] impresorasA = { false, false, false, false, false };
    private boolean[] impresorasB = { false, false, false };
    private int esperandoA = 0; // clientes dormidos en 'espera', protegido por mutex
    private int esperandoB = 0;
    private int esperandoCualquiera = 0;
    private Semaphore mutex;
    private Semaphore esperaA;
    private Semaphore esperaB;
    private Semaphore esperaGeneral;

    public GestorImpresoras() {
        this.mutex = new Semaphore(1);
        this.esperaA = new Semaphore(0);
        this.esperaB = new Semaphore(0);
        this.esperaGeneral = new Semaphore(0);
    }

    public void imprimirMaterial(char unTipoImpresion) throws InterruptedException {
        if (unTipoImpresion == 'A') {
            this.imprimirEnA();
        } else if (unTipoImpresion == 'B') {
            this.imprimirEnB();
        } else if (unTipoImpresion == 'X') {
            this.imprimirEnX();
        }
    }

    private void imprimirEnX() throws InterruptedException {
        this.mutex.acquire();
        int nroImpresora = this.buscarLibreA();
        if (nroImpresora == -1) {
            nroImpresora = this.buscarLibreB();
            if (nroImpresora == -1) {
                this.esperandoCualquiera++;
                this.mutex.release();
                this.esperaGeneral.acquire();
                // Despierto con algun mutex heredado: la impresora liberada sigue libre
                nroImpresora = this.buscarLibreA();
                if (nroImpresora == -1) {
                    nroImpresora = this.buscarLibreB();
                    this.ocuparImpresoraB(nroImpresora, 'X');
                } else {
                    this.ocuparImpresoraA(nroImpresora, 'X');
                }
            } else {
                this.ocuparImpresoraB(nroImpresora, 'X');
            }
        } else {
            this.ocuparImpresoraA(nroImpresora, 'X');
        }
    }

    private void imprimirEnA() throws InterruptedException {
        this.mutex.acquire();
        int nroImpresora = this.buscarLibreA();
        if (nroImpresora == -1) {
            this.esperandoA++;
            this.mutex.release();
            this.esperaA.acquire();
            // Despierto con mutex heredado: la impresora liberada sigue libre
            nroImpresora = this.buscarLibreA();
        }
        this.ocuparImpresoraA(nroImpresora, 'A');
    }

    private void imprimirEnB() throws InterruptedException {
        this.mutex.acquire();
        int nroImpresora = this.buscarLibreB();
        if (nroImpresora == -1) {
            this.esperandoB++;
            this.mutex.release();
            this.esperaB.acquire();
            // Despierto con mutex heredado: la impresora liberada sigue libre
            nroImpresora = this.buscarLibreB();
        }
        this.ocuparImpresoraB(nroImpresora, 'B');
    }

    private int buscarLibreA() {
        int i = 0;
        while (i < this.impresorasA.length && this.impresorasA[i]) {
            i++;
        }
        return (i < this.impresorasA.length) ? i : -1;
    }

    private int buscarLibreB() {
        int i = 0;
        while (i < this.impresorasB.length && this.impresorasB[i]) {
            i++;
        }
        return (i < this.impresorasB.length) ? i : -1;
    }

    private void ocuparImpresoraA(int nroImpresora, char tipoImpresion) throws InterruptedException {
        this.impresorasA[nroImpresora] = true;
        this.mutex.release();

        System.out.println(Thread.currentThread().getName()
                + " solicito una impresion de tipo '" + tipoImpresion + "'. Esta imprimiendo en la impresora "
                + (nroImpresora + 1) + "...");
        Thread.sleep(3500);
        System.out.println(Thread.currentThread().getName() + " ha terminado de imprimir");

        this.mutex.acquire();
        this.impresorasA[nroImpresora] = false;
        if (this.esperandoA > 0) {
            this.esperandoA--;
            this.esperaA.release(); // paso el mutex al que espera, NO lo suelto
        } else {
            if (this.esperandoCualquiera > 0) {
                this.esperandoCualquiera--;
                this.esperaGeneral.release(); // paso el mutex al que espera, NO lo suelto
            } else {
                this.mutex.release();
            }
        }

    }

    private void ocuparImpresoraB(int nroImpresora, char tipoImpresion) throws InterruptedException {
        this.impresorasB[nroImpresora] = true;
        this.mutex.release();

        System.out.println(Thread.currentThread().getName()
                + " solicito una impresion de tipo '" + tipoImpresion + "'. Esta imprimiendo en la impresora "
                + (nroImpresora + 1) + "...");
        Thread.sleep(3500);
        System.out.println(Thread.currentThread().getName() + " ha terminado de imprimir");

        this.mutex.acquire();
        this.impresorasB[nroImpresora] = false;
        if (this.esperandoB > 0) {
            this.esperandoB--;
            this.esperaB.release(); // paso el mutex al que espera, NO lo suelto
        } else {
            if (this.esperandoCualquiera > 0) {
                this.esperandoCualquiera--;
                this.esperaGeneral.release(); // paso el mutex al que espera, NO lo suelto
            } else {
                this.mutex.release();
            }
        }

    }

}
