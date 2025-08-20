/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author gonza
 */
public class Energia {
    private int unidades;
    
    public Energia(){
        this.unidades = 10;
    }
    
    public synchronized int getEnergia(){
        return this.unidades;
    }
    
    public synchronized void revitalizarEnergia(int cantEnergia){
        if(this.unidades + cantEnergia > 10){
            this.unidades = 10;
        } else{
            this.unidades = this.unidades + cantEnergia;
        }
    }
    
    public synchronized void drenarEnergia(int cantEnergia){
        if(this.unidades + cantEnergia < 0){
            this.unidades = 0;
        } else{
            this.unidades = this.unidades + cantEnergia;
        }
    }
    
}
