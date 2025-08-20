/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gonza
 */
public class Comedor {
    private Semaphore comederos;
    private final int CAP_MAX = 2;
    private int cantAnimalesEnSala;
    private boolean gatosEnSala;
    private boolean perrosEnSala;
    private Semaphore mutex;
    
    public Comedor(){
        this.comederos = new Semaphore(this.CAP_MAX);
        this.perrosEnSala = false;
        this.gatosEnSala = false;
        this.cantAnimalesEnSala = 0;
        this.mutex = new Semaphore(1);
    }
    
    public void perroEntrarAlComedor() throws InterruptedException{
        //Adquiere el permiso del comedor
        this.comederos.acquire();
        //Adquiere el permiso del semaforo mutex para asegurar que no se pisen
        //los valores
        this.mutex.acquire();
        //Si no hay gatos en la sala, avisa que hay perros en la sala y toma
        //un permiso de los comederos.
        if(!this.gatosEnSala){
            this.perrosEnSala = true;
            this.cantAnimalesEnSala++;
            System.out.println("El perro "+Thread.currentThread().getName()+" entro a la sala "
                    + "y  esta comiendo en el comedero");
        }
        else{
            this.comederos.release();
        }
        this.mutex.release();
    }
    
    public void perroSalirDelComedor() throws InterruptedException{
        this.mutex.acquire();
        System.out.println("El perro "+Thread.currentThread().getName()+" termino de"
                + " comer y salio de la sala");
        this.cantAnimalesEnSala--;
        if(this.cantAnimalesEnSala == 0){
            this.perrosEnSala = false;
        }
        this.comederos.release();
        this.mutex.release();
    }
    
    public void gatoEntrarAlComedor() throws InterruptedException{
        //Adquiere el permiso del comedor
        this.comederos.acquire();
        //Adquiere el permiso del semaforo mutex para asegurar que no se pisen
        //los valores
        this.mutex.acquire();
        if(!this.perrosEnSala){
            this.gatosEnSala = true;
            this.cantAnimalesEnSala++;
            System.out.println("El gato "+Thread.currentThread().getName()+" entro a la sala "
                    + "y  esta comiendo en el comedero");
        }
        else{
            this.comederos.release();
        }
        this.mutex.release();
    }
    
    public void gatoSalirDelComedor() throws InterruptedException{
        this.mutex.acquire();
        System.out.println("El gato "+Thread.currentThread().getName()+" termino de"
                + " comer y salio de la sala");
        this.cantAnimalesEnSala--;
        if(this.cantAnimalesEnSala == 0){
            this.gatosEnSala = false;
        }
        this.comederos.release();
        this.mutex.release();
    }
}
