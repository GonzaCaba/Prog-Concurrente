package Ejercicio5;

public class ControlTren implements Runnable {
    private ParqueAtracciones unParque;

    public ControlTren(ParqueAtracciones unP) {
        this.unParque = unP;
    }

    public void run() {
        try {
            while (true) {
                this.unParque.manejarTren();
            }
        } catch (InterruptedException ie) {
            System.out.println("ERROR");
        }
    }
}
