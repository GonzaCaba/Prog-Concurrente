/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author gonza
 */
public class Main {
    public static void main(String args[]){
        Proceso p = new Proceso();
        Hilo1 h1 = new Hilo1(p);
        Hilo2 h2 = new Hilo2(p);
        Hilo3 h3 = new Hilo3(p);
        
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        t1.start();
        t2.start();
        t3.start();
    }
}
