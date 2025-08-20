/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gonza
 */
public class Taxi {
    private boolean disponibilidad;
    private String patente;
    private Semaphore taxistaDuerme;
    private Semaphore clienteEnViaje;
    
    public Taxi(){
        this.patente = "AB-479-FT";
        this.clienteEnViaje = new Semaphore(0);
        this.taxistaDuerme = new Semaphore(0);
    }
    
    public void tomarTaxi() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta subiendo al taxi.");
        System.out.println(Thread.currentThread().getName()+" despierta al taxista.");
        System.out.println("El taxista se pone en viaje.");
        taxistaDuerme.release();
        clienteEnViaje.acquire();
    }
    
    public void dormirEnTaxi() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" se acomoda y duerme");
        taxistaDuerme.acquire();
    }
    
    public void llegarADestino() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" llega al destino.");
        System.out.println("El cliente se baja");
        clienteEnViaje.release();
    }
}
