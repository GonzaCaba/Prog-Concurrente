package Ejercicio8;

public class Mozo implements Runnable {
    private Confiteria unaConfiteria;

    public Mozo(Confiteria unaConfiteria) {
        this.unaConfiteria = unaConfiteria;
    }

    public void run() {
        try {
            while (true) {
                this.unaConfiteria.atenderCafeteria();
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
