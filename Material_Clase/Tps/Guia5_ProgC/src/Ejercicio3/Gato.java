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
public class Gato implements Runnable{
    private Comedor unComedor;
    
    public Gato(Comedor aComedor){
        this.unComedor = aComedor;
    }
    
    public void run(){
        try {
            this.unComedor.gatoEntrarAlComedor();
            Thread.sleep(3000);
            this.unComedor.gatoSalirDelComedor();
        } catch (InterruptedException ex) {
            Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
