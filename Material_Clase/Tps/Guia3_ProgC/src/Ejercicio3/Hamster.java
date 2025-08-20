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
public class Hamster implements Runnable {
    private Jaula j1 = new Jaula();
    
    public Hamster(){}
    
    private void comerDelPlato() throws InterruptedException {
        boolean sigPaso = false;
        while (!sigPaso) {
            System.out.println("El Hamster " + Thread.currentThread().getName() + " esta "
                    + "tratando de comer del plato...");
            sigPaso = j1.ocuparComida();
            if(!sigPaso){
                Thread.sleep(600);
            }
        }
        System.out.println("El Hamster " + Thread.currentThread().getName() + " ESTA COMIENDO DEL PLATO!");
        Thread.sleep(1000);
        j1.liberarComida();
        System.out.println("El Hamster " + Thread.currentThread().getName() + " LIBERO EL PLATO DE COMIDA");
    }
    
    private void usarRueda() throws InterruptedException {
        boolean sigPaso = false;
        while (!sigPaso) {
            System.out.println("El Hamster "+Thread.currentThread().getName()+" esta "
                    + "tratando de usar la rueda de ejercicio...");
            sigPaso = j1.ocuparRueda();
            if(!sigPaso){
                Thread.sleep(600);
            }
        }
        System.out.println("El Hamster " + Thread.currentThread().getName() + " ESTA USANDO LA RUEDA DE EJERCICIO!");
        Thread.sleep(1000);
        j1.liberarRueda();
        System.out.println("El Hamster " + Thread.currentThread().getName() + " LIBERO LA RUEDA");
    }
    
    private void usarHamaca() throws InterruptedException {
        boolean sigPaso = false;
        while (!sigPaso) {
            System.out.println("El Hamster "+Thread.currentThread().getName()+" esta "
                    + "tratando de domir en la hamaca...");
            sigPaso = j1.ocuparHamaca();
            if(!sigPaso){
                Thread.sleep(600);
            }
        }
        System.out.println("El Hamster " + Thread.currentThread().getName() + " ESTA DURMIENDO EN LA HAMACA!");
        Thread.sleep(1000);
        j1.liberarHamaca();
        System.out.println("El Hamster " + Thread.currentThread().getName() + " LIBERO LA HAMACA");
    }
    
    public void run(){
        try {
            this.comerDelPlato();
            this.usarRueda();
            this.usarHamaca();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
