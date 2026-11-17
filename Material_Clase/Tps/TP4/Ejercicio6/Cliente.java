package Ejercicio6;

public class Cliente implements Runnable {
    private Taxi unTaxi;

    public Cliente(Taxi unTaxi) {
        this.unTaxi = unTaxi;
    }

    public void run() {
        try {
            unTaxi.tomarTaxi();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
