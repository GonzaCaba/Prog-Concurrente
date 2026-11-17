package Ejercicio6;

public class Taxista implements Runnable {
    private Taxi unTaxi;

    public Taxista(Taxi unTaxi) {
        this.unTaxi = unTaxi;
    }

    public void run() {
        while (true) {
            try {
                unTaxi.manejarTaxi();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
