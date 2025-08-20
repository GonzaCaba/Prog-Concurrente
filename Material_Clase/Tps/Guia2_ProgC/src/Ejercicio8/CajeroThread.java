/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

import Ejercicio7.*;

/**
 *
 * @author gonza
 */
public class CajeroThread implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    // Constructor, y métodos de acceso
    public CajeroThread(String nomb, Cliente unCliente, long ms) {
        this.nombre = nomb;
        this.cliente = unCliente;
        this.initialTime = ms;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
    
    public void run() {
        System.out.println("El cajero " + this.nombre +
            " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
            " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime)/1000+"seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)+ " del cliente "+cliente.getNombre()
                + "->Tiempo: " + (System.currentTimeMillis() - this.initialTime)/1000+"seg");
        }
        System.out.println("El cajero " + this.nombre +" HA TERMINADO DE PROCESAR " +
                cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }
    
    public void esperarXsegundos(int seg){
        int cantMs = seg*1000;
        try {
            Thread.sleep(cantMs);
        } catch (InterruptedException ex) {}
    }
}
