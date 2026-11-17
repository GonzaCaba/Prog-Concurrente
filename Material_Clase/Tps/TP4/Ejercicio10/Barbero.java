package Ejercicio10;

public class Barbero extends Thread {
    private final Barberia barberia;
    private final SillonBarbero sillon;

    public Barbero(Barberia barberia, SillonBarbero sillon) {
        super("Barbero-" + sillon.getId());
        this.barberia = barberia;
        this.sillon = sillon;
    }

    public void run() {
        try {
            this.sillon.dormir();
            while (true) {
                this.sillon.cortarPelo();
                if (!this.barberia.llamarSiguiente(this.sillon)) {
                    this.sillon.dormir();
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("ERROR");
        }
    }
}
