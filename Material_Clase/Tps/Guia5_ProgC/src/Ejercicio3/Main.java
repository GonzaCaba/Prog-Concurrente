/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author gonza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comedor unComedor = new Comedor();
        Gato pG = new Gato(unComedor);
        Perro pP = new Perro(unComedor);
        
        Thread colPerro[] = new Thread[10];
        Thread colGato[] = new Thread[10];
        
        for(int varIter=0; varIter < colPerro.length; varIter++){
            colPerro[varIter] = new Thread(pP,("Prro. "+(varIter+1)));
            
        }
        for(int varIter=0; varIter < colGato.length; varIter++){
            colGato[varIter] = new Thread(pG,("Gto. "+(varIter+1)));
            
        }
        for(int varIter=0; varIter < colGato.length; varIter++){
            colGato[varIter].start();
            colPerro[varIter].start();
        }
    }
    
}
