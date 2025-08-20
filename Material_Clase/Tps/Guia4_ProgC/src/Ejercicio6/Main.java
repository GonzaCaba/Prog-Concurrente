/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author gonza
 */
public class Main {

    public static void main(String args[]) {
        Taxi unTaxi = new Taxi();
        Taxista tx = new Taxista(unTaxi);
        Cliente cl = new Cliente(unTaxi);

        Thread cl1 = new Thread(cl, "Don Ramon");
        Thread tx1 = new Thread(tx, "Oscar");
        cl1.start();
        tx1.start();
    }

}
