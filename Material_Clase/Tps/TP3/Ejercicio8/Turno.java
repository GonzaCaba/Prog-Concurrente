package Ejercicio8;

import java.util.concurrent.Semaphore;

public class Turno {
    private char letraQueToca;
    private Semaphore mutex;

    public Turno(char letraInicial) {
        this.letraQueToca = letraInicial;
        this.mutex = new Semaphore(1);
    }

    public boolean imprimirLetra(char letraEntrante, int cantVeces, char letraQueSigue) throws InterruptedException {
        boolean sePudo = false;
        mutex.acquire();
        if (letraEntrante == this.letraQueToca) {
            for (int i = 0; i < cantVeces; i++) {
                System.out.print(letraEntrante);
            }
            sePudo = true;
            this.letraQueToca = letraQueSigue;
        }
        mutex.release();
        return sePudo;
    }
}
