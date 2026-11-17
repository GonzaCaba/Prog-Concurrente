package Ejercicio9;

import java.util.concurrent.Semaphore;

public class CentroProduccion {
    private int cantLineaEnsamblajeElectricos, esperandoElectricos;
    private int cantLineaEnsamblajeMecanicos, esperandoMecanicos;
    private final int MAX_CAPACIDAD_ELECTRICO, MAX_CAPACIDAD_MECANICO;
    private Semaphore mutexMecanico;
    private Semaphore mutexElectrico;
    private Semaphore esperandoElectrico;
    private Semaphore esperandoMecanico;
    private Semaphore salidaMecanico;
    private Semaphore salidaElectrico;
    private boolean saliendoElectricos;

    public CentroProduccion() {
        this.cantLineaEnsamblajeElectricos = 0;
        this.cantLineaEnsamblajeMecanicos = 0;
        this.esperandoElectricos = 0;
        this.esperandoMecanicos = 0;
        MAX_CAPACIDAD_ELECTRICO = 6;
        MAX_CAPACIDAD_MECANICO = 4;
        this.mutexElectrico = new Semaphore(1);
        this.mutexMecanico = new Semaphore(1);
        this.esperandoElectrico = new Semaphore(0, true);
        this.esperandoMecanico = new Semaphore(0, true);
        this.salidaElectrico = new Semaphore(1, true);
        this.salidaMecanico = new Semaphore(0, true);
        this.saliendoElectricos = true;
    }

    public void cambiarLineas() throws InterruptedException {
        if (this.saliendoElectricos) {
            this.salidaElectrico.acquire();
            this.salidaMecanico.release();
            this.saliendoElectricos = false;
            System.out.println("\n===== Ahora salen los productos MECANICOS =====\n");
        } else {
            this.saliendoElectricos = true;
            this.salidaMecanico.acquire();
            this.salidaElectrico.release();
            System.out.println("\n===== Ahora salen los productos ELECTRICOS =====\n");
        }
    }

    public void llegaElectrico() throws InterruptedException {
        this.mutexElectrico.acquire();
        if (this.cantLineaEnsamblajeElectricos >= this.MAX_CAPACIDAD_ELECTRICO) {
            System.out.println("[ELEC] " + Thread.currentThread().getName() + " espera lugar (linea llena)");
            this.esperandoElectricos++;
            this.mutexElectrico.release();
            this.esperandoElectrico.acquire();
        }
        this.cantLineaEnsamblajeElectricos++;
        System.out.println("[ELEC] " + Thread.currentThread().getName() + " entra a la linea ("
                + this.cantLineaEnsamblajeElectricos + "/" + this.MAX_CAPACIDAD_ELECTRICO + ")");
        this.mutexElectrico.release();
        Thread.sleep(4000);
        System.out.println("[ELEC] " + Thread.currentThread().getName() + " termino de ensamblarse, espera para salir");
    }

    public void saleElectrico() throws InterruptedException {
        this.salidaElectrico.acquire();
        System.out.println("[ELEC] " + Thread.currentThread().getName() + " cruza la interseccion");
        Thread.sleep(800);
        this.mutexElectrico.acquire();
        this.cantLineaEnsamblajeElectricos--;
        System.out.println("[ELEC] " + Thread.currentThread().getName() + " sale de la fabrica ("
                + this.cantLineaEnsamblajeElectricos + "/" + this.MAX_CAPACIDAD_ELECTRICO + ")");
        if (esperandoElectricos > 0) {
            this.esperandoElectricos--;
            this.esperandoElectrico.release();
        } else {
            this.mutexElectrico.release();
        }
        this.salidaElectrico.release();
    }

    public void llegaMecanico() throws InterruptedException {
        this.mutexMecanico.acquire();
        if (this.cantLineaEnsamblajeMecanicos >= this.MAX_CAPACIDAD_MECANICO) {
            System.out.println("[MECA] " + Thread.currentThread().getName() + " espera lugar (linea llena)");
            this.esperandoMecanicos++;
            this.mutexMecanico.release();
            this.esperandoMecanico.acquire();
        }
        this.cantLineaEnsamblajeMecanicos++;
        System.out.println("[MECA] " + Thread.currentThread().getName() + " entra a la linea ("
                + this.cantLineaEnsamblajeMecanicos + "/" + this.MAX_CAPACIDAD_MECANICO + ")");
        this.mutexMecanico.release();
        Thread.sleep(6000);
        System.out.println("[MECA] " + Thread.currentThread().getName() + " termino de ensamblarse, espera para salir");
    }

    public void saleMecanico() throws InterruptedException {
        this.salidaMecanico.acquire();
        System.out.println("[MECA] " + Thread.currentThread().getName() + " cruza la interseccion");
        Thread.sleep(800);
        this.mutexMecanico.acquire();
        this.cantLineaEnsamblajeMecanicos--;
        System.out.println("[MECA] " + Thread.currentThread().getName() + " sale de la fabrica ("
                + this.cantLineaEnsamblajeMecanicos + "/" + this.MAX_CAPACIDAD_MECANICO + ")");
        if (esperandoMecanicos > 0) {
            this.esperandoMecanicos--;
            this.esperandoMecanico.release();
        } else {
            this.mutexMecanico.release();
        }
        this.salidaMecanico.release();
    }
}
