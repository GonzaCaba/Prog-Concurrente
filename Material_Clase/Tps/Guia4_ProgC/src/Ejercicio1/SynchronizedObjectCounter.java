/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author gonza
 */
public class SynchronizedObjectCounter {

    private int c = 0;
    private Object cObj = new Object();
    
    public void increment() {
        synchronized (cObj) {
            c++;
        } // Este elemento debe ser casteado a Integer
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
    }

    public int value() {
        synchronized (this) {
            return c;
        }
    }
}
