/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class Hilo1 implements Runnable {
    private Proceso proc;
    
    public Hilo1(Proceso pre){
        this.proc = pre;
    }
    
    public void run(){
        try {
            while(true){
                proc.pasarP1aP3();    
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
