/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author gonza
 */
public class ThreadEjemploRunnable implements Runnable {
    private String nombre;
    
    public ThreadEjemploRunnable(String nom){
        this.nombre = nom;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.nombre);
        }
        System.out.println("Termina thread " + this.nombre);
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadEjemploRunnable("Maria Jose"));
        Thread t2 = new Thread(new ThreadEjemploRunnable("Jose Maria"));
        t1.start();
        t2.start();
        System.out.println("Termina thread "+Thread.currentThread().getName());
    }
    
}
