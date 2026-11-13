package Ejercicio9;

public class Camion extends Thread {
    private Surtidor surtidor;

    public Camion(Surtidor unSurtidor) {
        this.surtidor = unSurtidor;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(8000); // pasa cada cierto tiempo
                this.surtidor.llegaCamion();
                Thread.sleep(4000); // tiempo que tarda en cargar
                this.surtidor.terminaCamion();
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
