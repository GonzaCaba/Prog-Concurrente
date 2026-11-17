package Ejercicio10;

import java.util.concurrent.Semaphore;

/**
 * Sillon propio de cada barbero. El atributo ocupado y clienteActual se leen y
 * escriben unicamente con el mutex de la Barberia tomado (o, en el caso de
 * clienteActual, por el propio barbero despues de haber sido despertado).
 */
public class SillonBarbero {
    private final int id;
    private boolean ocupado;
    private Turno clienteActual;
    private final Semaphore despertar; // el barbero duerme aca hasta que llegue un cliente

    public SillonBarbero(int id) {
        this.id = id;
        this.ocupado = false;
        this.clienteActual = null;
        this.despertar = new Semaphore(0);
    }

    public int getId() {
        return this.id;
    }

    public boolean estaOcupado() {
        return this.ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setClienteActual(Turno clienteActual) {
        this.clienteActual = clienteActual;
    }

    public void despertar() {
        this.despertar.release();
    }

    public void dormir() throws InterruptedException {
        System.out.println("El barbero " + this.id + " esta durmiendo esperando que llegue un cliente...");
        this.despertar.acquire();
    }

    public void cortarPelo() throws InterruptedException {
        Turno turno = this.clienteActual;
        System.out.println("El barbero " + this.id + " comienza a cortarle el pelo a "
                + turno.getNombreCliente() + "...");
        Thread.sleep(3000);
        System.out.println("El barbero " + this.id + " ha terminado de cortarle el pelo a "
                + turno.getNombreCliente());
        turno.getFin().release();
    }
}
