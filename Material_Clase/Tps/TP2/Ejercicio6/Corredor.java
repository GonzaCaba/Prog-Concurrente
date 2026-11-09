package Ejercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Corredor implements Runnable {
    public String nombreCorredor;
    public float distanciaRecorridaMetros = 0;

    public Corredor(String nC) {
        this.nombreCorredor = nC;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            this.avanzarDistancia();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
    }

    public void avanzarDistancia() {
        float distanciaAvanzadaMetros = (float) Math.random() * 10;
        BigDecimal bd = new BigDecimal(Float.toString(distanciaAvanzadaMetros));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        this.distanciaRecorridaMetros += bd.floatValue();
        System.out.println(
                "Soy el corredor " + Thread.currentThread().getName() + " y recorri: " + bd);
    }
}
