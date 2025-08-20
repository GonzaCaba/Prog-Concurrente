/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class TesteoHilos {

    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try {
            miHilo.join();
        } catch (InterruptedException ex) {}
        System.out.println("En el main");
    }
}
