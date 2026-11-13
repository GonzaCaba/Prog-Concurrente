package Ejercicio3;

public class Main {
    public static void main(String args[]) {
        Jaula unaJaula = new Jaula();
        Hamster hamster = new Hamster(unaJaula);
        Thread hamster1 = new Thread(hamster, "Hamster 1");
        Thread hamster2 = new Thread(hamster, "Hamster 2");
        Thread hamster3 = new Thread(hamster, "Hamster 3");
        hamster1.start();
        hamster2.start();
        hamster3.start();
    }
}
