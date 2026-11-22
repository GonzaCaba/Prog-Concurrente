package Ejercicio3;

public class Gato implements Runnable {
    private GestorComedero comedor;

    public Gato(GestorComedero unComedero) {
        this.comedor = unComedero;
    }

    public void run() {
        try {
            this.comedor.gatoCome();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}