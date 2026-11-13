package Ejercicio1;

import java.util.concurrent.Semaphore;

public class CuentaBanco {
    private int balance;
    private Semaphore mutex;

    public CuentaBanco(int balance) {
        this.balance = balance;
        this.mutex = new Semaphore(1);
    }

    public int getBalance() {
        return this.balance;
    }

    public void retiroBancario(int retiro) throws InterruptedException {
        mutex.acquire();
        if (this.balance >= retiro) {
            System.out.println(Thread.currentThread().getName() + " esta realizando un retiro de: " + retiro);
            Thread.sleep(1000);
            this.balance -= retiro;
            mutex.release();
            System.out.println(Thread.currentThread().getName() + ": Retiro Realizado");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + this.balance);
        } else {
            mutex.release();
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr. "
                    + Thread.currentThread().getName());

            System.out.println("Su saldo actual es de: " + this.balance);
            Thread.sleep(1000);
        }
    }
}
