package Ejercicio9;

public class Main {
    public static void main(String[] args) {
        CentroProduccion newCenter = new CentroProduccion();
        HiloControl unHilo = new HiloControl(newCenter);
        ProductoElectrico unProductoElectrico = new ProductoElectrico(newCenter);
        ProductoMecanico unProductoMecanico = new ProductoMecanico(newCenter);

        Thread hiloControl = new Thread(unHilo);
        hiloControl.start();

        for (int i = 0; i < 20; i++) {
            Thread prodElectrico = new Thread(unProductoElectrico, "Electrico-" + (i + 1));
            Thread prodMecanico = new Thread(unProductoMecanico, "Mecanico-" + (i + 1));
            try {
                prodElectrico.start();
                Thread.sleep(700);
                prodMecanico.start();
                Thread.sleep(800);
            } catch (InterruptedException ie) {
                System.out.println("Error");
            }
        }
    }
}
