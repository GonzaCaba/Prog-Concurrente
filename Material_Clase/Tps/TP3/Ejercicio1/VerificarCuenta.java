package Ejercicio1;

public class VerificarCuenta implements Runnable {
    private CuentaBanco cb;

    public VerificarCuenta(CuentaBanco unaCuenta) {
        this.cb = unaCuenta;
    }

    private void hacerRetiro(int unRetiro) throws InterruptedException {
        if (this.cb.getBalance() >= unRetiro) {
            System.out.println(Thread.currentThread().getName() + " esta realizando un retiro de: " + unRetiro);
            Thread.sleep(1000);
            cb.retiroBancario(unRetiro);
            System.out.println(Thread.currentThread().getName() + ": Retiro Realizado");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + cb.getBalance());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr. "
                    + Thread.currentThread().getName());

            System.out.println("Su saldo actual es de: " + cb.getBalance());
            Thread.sleep(1000);
        }
    }

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                this.hacerRetiro(10);
                if (cb.getBalance() < 0) {
                    System.out.println("Cuenta esta sobregirada");
                }
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
    }
}
