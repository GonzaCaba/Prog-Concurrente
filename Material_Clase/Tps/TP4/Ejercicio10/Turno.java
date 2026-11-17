package Ejercicio10;

import java.util.concurrent.Semaphore;

/**
 * Representa la visita de un cliente. Cada cliente tiene su propio Turno, asi
 * el barbero que lo atiende se comunica solo con el y no con otro cliente.
 */
public class Turno {
    private final String nombreCliente;
    private final Semaphore llamado; // el cliente sentado espera aca a que un barbero lo llame
    private final Semaphore fin; // el cliente espera aca a que terminen de cortarle el pelo
    private SillonBarbero sillon; // sillon asignado (lo setea la Barberia bajo su mutex)

    public Turno(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.llamado = new Semaphore(0);
        this.fin = new Semaphore(0);
        this.sillon = null;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public Semaphore getLlamado() {
        return this.llamado;
    }

    public Semaphore getFin() {
        return this.fin;
    }

    public SillonBarbero getSillon() {
        return this.sillon;
    }

    public void setSillon(SillonBarbero sillon) {
        this.sillon = sillon;
    }
}
