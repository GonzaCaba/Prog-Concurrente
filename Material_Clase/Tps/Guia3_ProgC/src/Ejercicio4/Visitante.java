/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gonza
 */
public class Visitante implements Runnable {
    private ParqueTematico pT = new ParqueTematico();
    
    public Visitante(){}
    
    public void run(){
        String[] array = {"East Zone", "North Zone", "South Zone","West Zone"};
        Random randomGenerator = new Random();
        int numRandom;
        int index;
        
        for(int varIter = 0; varIter<3;varIter++){
            index = randomGenerator.nextInt(array.length);
            //System.out.println("Area "+index);
            numRandom = (int) (Math.floor(Math.random()*6+1));
            //System.out.println("NumRandom "+numRandom);
            this.reservarEnArea(array[index], numRandom);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void reservarEnArea(String nombreArea, int cantReservas){
        System.out.println("El Cliente "+Thread.currentThread().getName()+" esta tratando"
                + " de realizar una reserva en el Area "+nombreArea+" ...");
        if(pT.seReservoEnArea(nombreArea, cantReservas)){
            System.out.println("SE HA RESERVADO CON EXITO!");
            System.out.println("El Cliente "+Thread.currentThread().getName()+
                    " RESERVO CON EXITO EN LA ZONA "+nombreArea+" PARA "
                            + "UN TOTAL DE "+cantReservas+" PERSONAS");
        }
        else{
            System.out.println("NO SE HA ENCONTRADO LA ZONA, O LA ZONA NO TIENE"
                    + " MAS DISPONIBILIDAD");
        }
    }  
}
