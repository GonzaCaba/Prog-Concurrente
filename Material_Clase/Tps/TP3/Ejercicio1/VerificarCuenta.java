package Ejercicio1;

public class VerificarCuenta implements Runnable {
    private CuentaBanco cb;

    public VerificarCuenta(CuentaBanco unaCuenta) {
        this.cb = unaCuenta;
    }

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                this.cb.retiroBancario(10);
                if (cb.getBalance() < 0) {
                    System.out.println("Cuenta esta sobregirada");
                }
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
    }
}
