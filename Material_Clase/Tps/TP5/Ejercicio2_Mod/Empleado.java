package Ejercicio2_Mod;

public class Empleado implements Runnable {
    private Confiteria unaConfiteria;

    public Empleado(Confiteria unaConfiteria) {
        this.unaConfiteria = unaConfiteria;
    }

    public void run() {
        try {
            this.unaConfiteria.comerEnCafeteria();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
