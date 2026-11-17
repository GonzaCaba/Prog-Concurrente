package Ejercicio9;

public class ProductoElectrico implements Runnable {
    private CentroProduccion unCentro;

    public ProductoElectrico(CentroProduccion unCentroP) {
        this.unCentro = unCentroP;
    }

    public void run() {
        try {
            this.unCentro.llegaElectrico();
            this.unCentro.saleElectrico();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
