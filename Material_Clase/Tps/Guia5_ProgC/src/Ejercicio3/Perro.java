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
public class Perro implements Runnable{
    private Comedor unComedor;
    
    public Perro(Comedor aComedor){
        this.unComedor = aComedor;
    }
    
    public void run(){
        try {
            this.unComedor.perroEntrarAlComedor();
            Thread.sleep(3000);
            this.unComedor.perroSalirDelComedor();
        } catch (InterruptedException ex) {
            Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
