/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author gonza
 */
public class Hamaca {
    boolean estadoOcupado;
    public Hamaca(){
        this.estadoOcupado = false;
    }

    public synchronized boolean isEstadoOcupado() {
        return estadoOcupado;
    }

    public synchronized void setEstadoOcupado(boolean estadoOcupado) {
        this.estadoOcupado = estadoOcupado;
    }
    
    public synchronized boolean ocuparHamaca(){
        boolean exito = false;
        if(!estadoOcupado){
            this.estadoOcupado = true;
            exito = true;
        }
        return exito;
    }
}
