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
    
    public static void main (String args[]){
        Hamster h1 = new Hamster();
        Thread t1 = new Thread(h1,"Pupi");
        Thread t2 = new Thread(h1,"Pepo");
        Thread t3 = new Thread(h1,"Popi");
        t1.start();
        t2.start();
        t3.start();
    }
}
