package Ejercicio1;

public class Persona implements Runnable {
    private GestorPiscina balneario;

    public Persona(GestorPiscina unBalneario) {
        this.balneario = unBalneario;
    }

    public void run() {
        try {
            this.balneario.entrarPiscina();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
