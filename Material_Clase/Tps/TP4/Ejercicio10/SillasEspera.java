package Ejercicio10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sillas de espera compartidas por todos los barberos. No es thread-safe por si
 * sola: todos sus metodos se invocan con el mutex de la Barberia tomado.
 */
public class SillasEspera {
    private final int SILLAS_ESPERA;
    private final Queue<Turno> enEspera; // FIFO: se atiende en orden de llegada

    public SillasEspera(int sillasEspera) {
        this.SILLAS_ESPERA = sillasEspera;
        this.enEspera = new LinkedList<>();
    }

    public boolean sentarse(Turno turno) {
        boolean pudoSentarse = false;
        if (this.enEspera.size() < this.SILLAS_ESPERA) {
            this.enEspera.add(turno);
            pudoSentarse = true;
        }
        return pudoSentarse;
    }

    /** Devuelve el cliente que lleva mas tiempo esperando, o null si no hay. */
    public Turno siguiente() {
        return this.enEspera.poll();
    }
}
