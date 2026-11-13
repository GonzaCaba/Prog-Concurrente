package Ejercicio3.OpcionSemaforos;

public class Hamster implements Runnable {
    private Jaula jaulaAsignada;

    public Hamster(Jaula unaJaula) {
        this.jaulaAsignada = unaJaula;
    }

    public void run() {
        boolean usoHamaca = false;
        boolean usoPlato = false;
        boolean usoRueda = false;
        try {
            while (!usoHamaca || !usoPlato || !usoRueda) {
                if (!usoRueda && jaulaAsignada.usarRueda()) {
                    usoRueda = true;
                }
                if (!usoPlato && jaulaAsignada.usarPlato()) {
                    usoPlato = true;
                }
                if (!usoHamaca && jaulaAsignada.usarHamaca()) {
                    usoHamaca = true;
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
