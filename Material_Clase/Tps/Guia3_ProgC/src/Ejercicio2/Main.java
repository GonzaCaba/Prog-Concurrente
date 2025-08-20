/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author gonza
 */
public class Main {
    public static void main(String[] args) {
        Energia unaEnergia = new Energia();
        Personaje p1 = new Personaje("La Criatura Oscura",-3,unaEnergia);
        Personaje p2 = new Personaje("El Sanador",2,unaEnergia);
        
        Thread criaturaOscura = new Thread(p1);
        Thread sanador = new Thread(p2);
        
        criaturaOscura.start();
        sanador.start();
    }
}
