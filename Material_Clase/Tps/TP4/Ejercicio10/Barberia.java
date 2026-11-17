package Ejercicio10;

import java.util.concurrent.Semaphore;

public class Barberia {
    private final SillonBarbero[] sillones;
    private final SillasEspera sillasEspera;
    // Protege el estado de todos los sillones y de las sillas de espera. Es unico
    // para que "hay barbero libre / me siento" y "hay alguien esperando / me libero"
    // sean decisiones atomicas entre si.
    private final Semaphore mutex;

    public Barberia(int cantBarberos, int cantSillasEspera) {
        this.sillones = new SillonBarbero[cantBarberos];
        for (int i = 0; i < cantBarberos; i++) {
            this.sillones[i] = new SillonBarbero(i + 1);
        }
        this.sillasEspera = new SillasEspera(cantSillasEspera);
        this.mutex = new Semaphore(1);
    }

    public SillonBarbero getSillon(int indice) {
        return this.sillones[indice];
    }

    public int getCantBarberos() {
        return this.sillones.length;
    }

    /** Lo invoca el cliente. */
    public void cortarsePelo() throws InterruptedException {
        String nombre = Thread.currentThread().getName();
        Turno turno = new Turno(nombre);

        this.mutex.acquire();
        SillonBarbero libre = this.buscarSillonLibre();
        if (libre != null) {
            // Hay un barbero libre: se lo reserva y se lo despierta
            libre.setOcupado(true);
            libre.setClienteActual(turno);
            turno.setSillon(libre);
            this.mutex.release();
            System.out.println(nombre + " ha llegado y despierta al barbero " + libre.getId() + ".");
            libre.despertar();
        } else if (this.sillasEspera.sentarse(turno)) {
            // Todos ocupados pero hay silla libre: espera a que lo llame un barbero
            this.mutex.release();
            System.out.println(nombre + " ha llegado, pero estan todos los barberos ocupados. Se sienta a esperar.");
            turno.getLlamado().acquire();
            System.out.println(nombre + " es su turno, pasa al sillon del barbero " + turno.getSillon().getId() + ".");
        } else {
            // Todos ocupados y sin sillas: se retira
            this.mutex.release();
            System.out.println(nombre + " ha llegado, pero no hay lugar para el. Se retira.");
            return;
        }

        turno.getFin().acquire();
        System.out.println(nombre + " se retira de la barberia.");
    }

    /**
     * Lo invoca un barbero al terminar un corte. Si hay alguien esperando lo llama
     * (el barbero sigue ocupado) y devuelve true; si no, queda libre y devuelve
     * false.
     */
    public boolean llamarSiguiente(SillonBarbero sillon) throws InterruptedException {
        this.mutex.acquire();
        Turno siguiente = this.sillasEspera.siguiente();
        if (siguiente != null) {
            sillon.setClienteActual(siguiente);
            siguiente.setSillon(sillon);
        } else {
            sillon.setOcupado(false);
        }
        this.mutex.release();

        if (siguiente != null) {
            System.out.println("El barbero " + sillon.getId() + " hace pasar a " + siguiente.getNombreCliente());
            siguiente.getLlamado().release();
        }
        return siguiente != null;
    }

    // Debe invocarse con el mutex tomado
    private SillonBarbero buscarSillonLibre() {
        SillonBarbero libre = null;
        int i = 0;
        while (libre == null && i < this.sillones.length) {
            if (!this.sillones[i].estaOcupado()) {
                libre = this.sillones[i];
            }
            i++;
        }
        return libre;
    }
}
