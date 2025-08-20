/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class Cliente implements Runnable{
    private GestorImpresoras gsImp = new GestorImpresoras();
    
    public Cliente(){}
    
    public void run(){
        try {
            gsImp.ocuparImpresora();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
