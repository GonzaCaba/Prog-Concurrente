package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Energia jugador = new Energia(10);
        NPC criaturaOscura = new NPC(-4, jugador);
        NPC sanador = new NPC(3, jugador);
        Thread hiloNPC1 = new Thread(criaturaOscura, "La Criatura Oscura");
        Thread hiloNPC2 = new Thread(sanador, "El Sanador");
        hiloNPC1.start();
        hiloNPC2.start();
    }
}
