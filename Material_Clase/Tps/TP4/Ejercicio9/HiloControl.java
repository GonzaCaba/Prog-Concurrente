package Ejercicio9;

public class HiloControl implements Runnable {
    private CentroProduccion unCentro;

    public HiloControl(CentroProduccion unCentroP) {
        this.unCentro = unCentroP;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(10000);
                unCentro.cambiarLineas();
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
