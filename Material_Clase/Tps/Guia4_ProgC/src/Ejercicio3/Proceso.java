/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gonza
 */
public class Proceso {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    
    public Proceso(){
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }
    
    public void pasarP1aP3() throws InterruptedException{
        sem1.acquire();
        System.out.println("Se adquirio el permiso del semaforo 1.");
        System.out.println("Realizando proceso P1...");
        Thread.sleep(2000);
        System.out.println("Proceso P1 completado, pasando a proceso P3");
        sem2.release();
    }
    
    public void pasarP3aP2() throws InterruptedException{
        sem2.acquire();
        System.out.println("Se adquirio el permiso del semaforo 2.");
        System.out.println("Realizando proceso P3...");
        Thread.sleep(2000);
        System.out.println("Proceso P3 completado, pasando a proceso P2");
        sem3.release();
    }
    
    public void pasarP2aP1() throws InterruptedException{
        sem3.acquire();
        System.out.println("Se adquirio el permiso del semaforo 3.");
        System.out.println("Realizando proceso P2...");
        Thread.sleep(2000);
        System.out.println("Proceso P2 completado, pasando a proceso P1");
        sem1.release();
    }
    
}
