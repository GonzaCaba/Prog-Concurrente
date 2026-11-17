package Ejercicio10;

public class Cliente extends Thread {
    private final Barberia barberia;

    public Cliente(Barberia barberia, String nombre) {
        super(nombre);
        this.barberia = barberia;
    }

    public void run() {
        try {
            this.barberia.cortarsePelo();
        } catch (InterruptedException ie) {
            System.out.println("ERROR");
        }
    }
}
