/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author gonza
 */
public class Area {
    private final String nombreArea;
    private int disponibilidad;
    
    public Area(String nombre, int disp){
        nombreArea = nombre;
        disponibilidad = disp;
    }

    public synchronized int getDisponibilidad() {
        return disponibilidad;
    }

    public synchronized void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public synchronized String getNombreArea() {
        return nombreArea;
    }
    
    public synchronized boolean reservar(int disp){
        boolean exito = false;
        if(this.disponibilidad-disp > 0){
            this.disponibilidad = this.disponibilidad-disp;
            exito = true;
        }
        return exito;
    }
    
    public synchronized void imprimirZona(){
        System.out.println("Area: "+nombreArea+"\nDisponibilidad: "+disponibilidad);
    }
}
