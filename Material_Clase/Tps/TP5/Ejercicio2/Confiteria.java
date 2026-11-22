package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore mesa;
    private Semaphore esperaMozo;
    private Semaphore esperaClienteAlMozo;
    private Semaphore esperaClienteAlCocinero;
    private Semaphore inventandoPollo;
    private Semaphore ordenandoCocina;
    private Semaphore esperaAtiendanMozo;
    private Semaphore esperaAtiendanCocinero;

    public Confiteria() {
        this.mesa = new Semaphore(2);
        this.esperaMozo = new Semaphore(0);
        this.esperaClienteAlMozo = new Semaphore(0);
        this.esperaClienteAlCocinero = new Semaphore(0);
        this.inventandoPollo = new Semaphore(0);
        this.ordenandoCocina = new Semaphore(0);
        this.esperaAtiendanMozo = new Semaphore(0);
        this.esperaAtiendanCocinero = new Semaphore(0);
    }

    public void atenderCafeteria() throws InterruptedException {
        System.out.println("Mientras el mozo espera, disfruta inventando nuevas versiones de pollo frito...");
        // Avisa a los clientes que esta listo para atender
        this.esperaAtiendanMozo.release(); // Dos mesas ocupadas compiten por el permiso, una lo adquiere el otro se
                                           // bloquea
        this.inventandoPollo.acquire(); // Duerme hasta que un cliente llegue.
        System.out.println("El mozo atiende la mesa.");
        this.esperaMozo.acquire();
        System.out.println("El mozo ha anotado la orden, busca la bebida y la lleva a la mesa");
        Thread.sleep(500 * ((int) (Math.random() * 4) + 1));
        System.out.println("El mozo entrega la bebida al empleado");
        this.esperaClienteAlMozo.release();
    }

    public void cocinarPolloFrito() throws InterruptedException {
        System.out.println("Mientras el cocinero no tiene trabajo, ordena su cocina...");
        this.esperaAtiendanCocinero.release(); // Avisa a los clientes que esta listo para atender
        this.ordenandoCocina.acquire(); // Duerme hasta que un cliente llegue.
        System.out.println("El cocinero esta realizando la orden...");
        Thread.sleep(300 * ((int) (Math.random() * 10) + 1));
        System.out.println("El cocinero ha terminado la orden, avisa al cliente.");
        // Despierta al cliente
        this.esperaClienteAlCocinero.release();
    }

    public void comerEnCafeteria() throws InterruptedException {
        int eleccion = (int) (Math.random() * 3);
        System.out.println(
                Thread.currentThread().getName() + " ha llegado a la cafeteria y esta esperando para sentarse.");
        this.mesa.acquire();
        switch (eleccion) {
            case 0, 1: // 0: Solo bebida - 1: bebida y comida
                System.out.println(Thread.currentThread().getName() + " se sento en la mesa y llama al mozo");
                this.esperaAtiendanMozo.acquire(); // Avisa al mozo que esta listo para que lo atiendan, si este esta
                                                   // ocupado, se queda bloqueado
                this.inventandoPollo.release(); // Despierta al mozo
                Thread.sleep(300); // Espera que mozo llegue
                if (eleccion == 0) {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " solo quiere tomar algo. Le pide al mozo una Coca-Cola");
                    this.esperaMozo.release();
                    this.esperaClienteAlMozo.acquire();
                    System.out.println(Thread.currentThread().getName() + " toma la Coca-Cola y se retira");
                    this.mesa.release();
                } else {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " quiere tomar algo y comer. Primero le pide al mozo una Coca-Cola");
                    this.esperaMozo.release();
                    this.esperaClienteAlMozo.acquire();
                    System.out.println(Thread.currentThread().getName() + " toma la Coca y va hacia al cocinero");
                    this.esperaAtiendanCocinero.acquire(); // Avisa al cocinero que esta listo para que lo atiendan, si
                                                           // este esta ocupado, se queda bloqueado
                    System.out.println(Thread.currentThread().getName() + " le pide al cocinero su mejor pollo frito");
                    this.ordenandoCocina.release(); // Despierta al cocinero
                    this.esperaClienteAlCocinero.acquire();
                    System.out
                            .println(Thread.currentThread().getName() + " ya tiene su pollo! Va a la mesa a comer...");
                    Thread.sleep(300 * ((int) (Math.random() * 10) + 1));
                    System.out.println(Thread.currentThread().getName() + " ha terminado de comer, libera su mesa");
                    this.mesa.release();
                }
                break;
            case 2: // solo comida
                System.out.println(
                        Thread.currentThread().getName() + " deja sus cosas en la mesa y se dirige al cocinero");
                this.esperaAtiendanCocinero.acquire(); // Avisa al cocinero que esta listo para que lo atiendan, si este
                                                       // esta ocupado, se queda bloqueado
                System.out.println(Thread.currentThread().getName() + " le pide al cocinero su mejor pollo frito");
                this.ordenandoCocina.release(); // Despierta al cocinero
                this.esperaClienteAlCocinero.acquire();
                System.out
                        .println(Thread.currentThread().getName() + " ya tiene su pollo! Va a la mesa a comer...");
                Thread.sleep(300 * ((int) (Math.random() * 10) + 1));
                System.out.println(Thread.currentThread().getName() + " ha terminado de comer, libera su mesa");
                this.mesa.release();
        }
    }
}
