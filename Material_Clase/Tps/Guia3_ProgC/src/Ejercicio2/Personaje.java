/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author gonza
 */
public class Personaje implements Runnable{
    public String nombre;
    public int cantEnergia;
    public Energia aEnergy;
    
    public Personaje(String nombre, int energia, Energia aEnergy){
        this.nombre = nombre;
        this.cantEnergia = energia;
        this.aEnergy = aEnergy;
    }
    
    private void revitalizarEnergia() throws InterruptedException {
        System.out.println("Tranquilo! " + this.nombre + " esta revitalizando tu energia!");
        aEnergy.revitalizarEnergia(cantEnergia);
        System.out.println("Se han revitalizado " + cantEnergia + " unidades de energia...");
        System.out.println("Tu energia actual es de "+this.aEnergy.getEnergia()+" unidades");
        Thread.sleep(500);
    }
    
    private void drenarEnergia() throws InterruptedException {
        System.out.println("Oh no! Cuidado! " + this.nombre + " esta drenando tu energia!");
        aEnergy.drenarEnergia(cantEnergia);
        System.out.println("Se han drenado " + cantEnergia + " unidades de energia...");
        System.out.println("Tu energia actual es de "+this.aEnergy.getEnergia()+" unidades");
        Thread.sleep(500);
    }
    
    public void run(){
        for(int i = 0; i<3; i++){
            if(this.aEnergy.getEnergia()>0){
                try{
                    if(cantEnergia>0)
                        this.revitalizarEnergia();
                    else
                        this.drenarEnergia();
                } catch (InterruptedException e) {}
            } else{
                System.out.println("Oh no! TE QUEDASTE SIN ENERGIA!");
            }
        }
    }
    
}
