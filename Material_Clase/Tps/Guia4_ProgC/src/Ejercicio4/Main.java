/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author gonza
 */
public class Main {
    public static void main (String args[]){
        Cliente c = new Cliente();
        Thread t1 = new Thread(c,"Oscar Romero");
        Thread t2 = new Thread(c,"Nicolas Vazques");
        Thread t3 = new Thread(c,"Leonel Messi");
        Thread t4 = new Thread(c, "Jesus Cristo");
        Thread t5 = new Thread(c,"Leonardo Davinchi");
        Thread t6 = new Thread(c, "Socrates");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
