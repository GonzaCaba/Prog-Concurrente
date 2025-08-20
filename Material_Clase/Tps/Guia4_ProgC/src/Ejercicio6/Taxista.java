/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class Taxista implements Runnable{
    private Taxi unTaxi;
    
    public Taxista(Taxi tax){
        unTaxi = tax;
    }

    public void run() {
        try {
            while (true) {
                unTaxi.dormirEnTaxi();
                this.conducirADestino();
                unTaxi.llegarADestino();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conducirADestino() throws InterruptedException{
        Thread.sleep(3500);
    }
    
}
