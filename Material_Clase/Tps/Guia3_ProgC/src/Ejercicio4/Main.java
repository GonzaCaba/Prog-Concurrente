/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author gonza
 */
public class Main {
    public static void main (String args[]){
        Visitante vs = new Visitante();
        
        Thread vs1 = new Thread(vs,"Oscar Gomez");
        Thread vs2 = new Thread(vs, "Ramiro Vergutti");
        Thread vs3 = new Thread(vs, "Gonzalo Cabanne");
        Thread vs4 = new Thread(vs, "Nicolas Valenciana");
        
        vs1.start();
        vs2.start();
        vs3.start();
        vs4.start();
        
    }
}
