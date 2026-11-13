package Ejercicio1.IncisoC;

public class VerificarCuenta implements Runnable {
    private CuentaBanco cb;

    public VerificarCuenta(CuentaBanco unaCuenta) {
        this.cb = unaCuenta;
    }

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                if (!this.cb.hacerRetiro(10)) {
                    System.out.println("Cuenta esta sobregirada");
                }
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
    }
}
