package Ejercicio3;

public class Hamster implements Runnable {
    private Jaula jaulaAsignada;

    public Hamster(Jaula unaJaula) {
        this.jaulaAsignada = unaJaula;
    }

    public void run() {
        try {
            jaulaAsignada.usarRueda();
            jaulaAsignada.usarPlato();
            jaulaAsignada.usarHamaca();
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
