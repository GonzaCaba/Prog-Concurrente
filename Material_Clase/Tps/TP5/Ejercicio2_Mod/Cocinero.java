package Ejercicio2_Mod;

public class Cocinero implements Runnable {
    private Confiteria unaConfiteria;

    public Cocinero(Confiteria unaC) {
        this.unaConfiteria = unaC;
    }

    public void run() {
        while (true) {
            try {
                this.unaConfiteria.cocinarPolloFrito();
            } catch (InterruptedException ie) {
                System.out.println("Error");
            }
        }
    }
}
