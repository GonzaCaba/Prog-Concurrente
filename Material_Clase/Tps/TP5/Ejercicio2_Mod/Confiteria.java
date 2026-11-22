package Ejercicio2_Mod;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore mesa;
    private Semaphore pedidosMozo;
    private Semaphore bebidaLista;
    private Semaphore pedidosCocinero;
    private Semaphore comidaLista;

    public Confiteria() {
        this.mesa = new Semaphore(2);
        this.pedidosMozo = new Semaphore(0);
        this.bebidaLista = new Semaphore(0);
        this.pedidosCocinero = new Semaphore(0);
        this.comidaLista = new Semaphore(0);
    }

    public void atenderCafeteria() throws InterruptedException {
        System.out.println("Mientras el mozo espera, disfruta inventando nuevas versiones de pollo frito...");
        this.pedidosMozo.acquire(); // Duerme hasta que haya al menos un cliente esperando. Si hay dos, los atiende
                                    // de a uno.
        System.out.println("El mozo atiende la mesa.");
        System.out.println("El mozo ha anotado la orden, busca la bebida y la lleva a la mesa");
        Thread.sleep(500 * ((int) (Math.random() * 4) + 1));
        System.out.println("El mozo entrega la bebida al empleado");
        this.bebidaLista.release(); // Despierta a un cliente que espera su bebida
    }

    public void cocinarPolloFrito() throws InterruptedException {
        System.out.println("Mientras el cocinero no tiene trabajo, ordena su cocina...");
        this.pedidosCocinero.acquire(); // Duerme hasta que haya al menos un cliente esperando. Si hay dos, los
                                        // atiende de a uno.
        System.out.println("El cocinero esta realizando la orden...");
        Thread.sleep(300 * ((int) (Math.random() * 10) + 1));
        System.out.println("El cocinero ha terminado la orden, avisa al cliente.");
        this.comidaLista.release(); // Despierta a un cliente que espera su comida
    }

    public void comerEnCafeteria() throws InterruptedException {
        int eleccion = (int) (Math.random() * 3);
        System.out.println(
                Thread.currentThread().getName() + " ha llegado a la cafeteria y esta esperando para sentarse.");
        this.mesa.acquire();
        switch (eleccion) {
            case 0, 1: // 0: Solo bebida - 1: bebida y comida
                System.out.println(Thread.currentThread().getName() + " se sento en la mesa y llama al mozo");
                if (eleccion == 0) {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " solo quiere tomar algo. Le pide al mozo una Coca-Cola");
                    this.pedidosMozo.release(); // Avisa al mozo que hay un cliente esperando
                    this.bebidaLista.acquire();
                    System.out.println(Thread.currentThread().getName() + " toma la Coca-Cola y se retira");
                    this.mesa.release();
                } else {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " quiere tomar algo y comer. Primero le pide al mozo una Coca-Cola");
                    this.pedidosMozo.release(); // Avisa al mozo que hay un cliente esperando
                    this.bebidaLista.acquire();
                    System.out.println(Thread.currentThread().getName() + " toma la Coca y va hacia al cocinero");
                    System.out.println(Thread.currentThread().getName() + " le pide al cocinero su mejor pollo frito");
                    this.pedidosCocinero.release(); // Avisa al cocinero que hay un cliente esperando
                    this.comidaLista.acquire();
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
                System.out.println(Thread.currentThread().getName() + " le pide al cocinero su mejor pollo frito");
                this.pedidosCocinero.release(); // Avisa al cocinero que hay un cliente esperando
                this.comidaLista.acquire();
                System.out
                        .println(Thread.currentThread().getName() + " ya tiene su pollo! Va a la mesa a comer...");
                Thread.sleep(300 * ((int) (Math.random() * 10) + 1));
                System.out.println(Thread.currentThread().getName() + " ha terminado de comer, libera su mesa");
                this.mesa.release();
        }
    }
}
