package Ejercicio5;

public class VendedorTickets implements Runnable {
    private ParqueAtracciones unParque;

    public VendedorTickets(ParqueAtracciones unP) {
        this.unParque = unP;
    }

    public void run() {
        try {
            while (true) {
                this.unParque.venderTickets();
            }
        } catch (InterruptedException ie) {
            System.out.println("ERROR");
        }
    }
}
