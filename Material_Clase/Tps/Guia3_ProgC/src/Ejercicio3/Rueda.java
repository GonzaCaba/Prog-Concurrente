/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author gonza
 */
public class Rueda {
    boolean estadoOcupado;
    public Rueda(){
        this.estadoOcupado = false;
    }

    public synchronized boolean isEstadoOcupado() {
        return estadoOcupado;
    }

    public synchronized void setEstadoOcupado(boolean estadoOcupado) {
        this.estadoOcupado = estadoOcupado;
    }
    
    public synchronized boolean ocuparRueda(){
        boolean exito = false;
        if(!estadoOcupado){
           this.estadoOcupado = true;
           exito = true;
        }
        return exito;     
    }
}
