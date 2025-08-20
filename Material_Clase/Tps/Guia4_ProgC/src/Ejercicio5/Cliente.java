/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class Cliente implements Runnable{
    private GestorImpresoras gsImp = new GestorImpresoras();
    private char[] opcionesImpresion = {'A','a','b','B','x'};
    Random rt = new Random();
    
    public Cliente(){}
    
    public void run(){
        try {
            int next = rt.nextInt(opcionesImpresion.length);
            System.out.println("Hola! Soy "+Thread.currentThread().getName()+". Quiero imprimir"
                    + " unos documentos y para eso necesito una impresora de TIPO "+this.opcionesImpresion[next]);
            gsImp.ocuparImpresoraGen(this.opcionesImpresion[next]);          
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
