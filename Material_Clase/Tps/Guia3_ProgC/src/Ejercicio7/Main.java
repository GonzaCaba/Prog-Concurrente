/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio7;

/**
 *
 * @author gonza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Turno unT = new Turno();
        Letra a = new Letra('a',3,unT,0);
        Letra b = new Letra('b',1,unT,1);
        Letra c = new Letra('c',5,unT,2);
        
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);
        
        t1.start();
        t2.start();
        t3.start();
    }
    
}
