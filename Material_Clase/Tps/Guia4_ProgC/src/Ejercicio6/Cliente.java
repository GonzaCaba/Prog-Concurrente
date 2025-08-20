/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class Cliente implements Runnable { 
    private Taxi unTaxi;
    
    public Cliente(Taxi tax){
        unTaxi = tax;
    }
    
    public void run(){
        while(true){
            try {
                this.buscarTaxi();
                unTaxi.tomarTaxi();
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void buscarTaxi() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta caminando por la calle"
                + " buscando un taxi....");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" ha encontrado un taxi!");
    }
}
