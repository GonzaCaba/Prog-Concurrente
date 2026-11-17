package Ejercicio9;

public class ProductoMecanico implements Runnable {
    private CentroProduccion unCentro;

    public ProductoMecanico(CentroProduccion unCentroP) {
        this.unCentro = unCentroP;
    }

    public void run() {
        try {
            this.unCentro.llegaMecanico();
            this.unCentro.saleMecanico();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
