package Ejercicio3;

public class Perro implements Runnable {
    private GestorComedero comedor;

    public Perro(GestorComedero unComedero) {
        this.comedor = unComedero;
    }

    public void run() {
        try {
            this.comedor.perroCome();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
