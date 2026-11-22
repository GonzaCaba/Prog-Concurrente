package Ejercicio5;

public class Pasajero implements Runnable {
    private ParqueAtracciones unParque;

    public Pasajero(ParqueAtracciones unP) {
        this.unParque = unP;
    }

    public void run() {
        try {
            while (true) {
                this.unParque.comprarTickets();
                this.unParque.tomarTren();
            }
        } catch (InterruptedException ie) {
            System.out.println("ERROR");
        }
    }
}
