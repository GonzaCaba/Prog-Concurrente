/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gonza
 */
public class GestorImpresoras {
    private boolean[] impresoras;
    private Semaphore dispImp;
    
    public GestorImpresoras(){
        this.impresoras = new boolean[4];
        this.inicializarImpresoras(this.impresoras);
        dispImp = new Semaphore(impresoras.length);
    }
    
    private void inicializarImpresoras(boolean[] impresoras){
        int cantImp = impresoras.length;
        for(int varIter = 0; varIter<cantImp; varIter++){
            impresoras[varIter] = true;
        }
    }
    
    public void ocuparImpresora() throws InterruptedException{
        dispImp.acquire();
        int cantImp = impresoras.length;
        int varIter = 0;
        //Buscamos una impresora libre dentro de nuestra coleccion de impresoras.
        boolean encontro = false;
        while(varIter < cantImp && !encontro){
            if(impresoras[varIter]){
                impresoras[varIter]=false;
                encontro = true;
            }
            else{
                varIter++;
            }
        }
        System.out.println("El Cliente "+Thread.currentThread().getName()+" esta utilizando "
                + "la Impresora Numero "+(varIter+1)+"...");
        int valorRandom = (int) (Math.floor(Math.random()*5001+1));
        Thread.sleep(valorRandom);
        System.out.println("El Cliente "+Thread.currentThread().getName()+" termino de utilizar"
                + " la Impresora Numero "+(varIter+1)+"!");
        //Liberamos la impresora y el semaforo
        impresoras[varIter] = true;
        dispImp.release();
    }
}
