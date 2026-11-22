package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        GestorComedero unComedor = new GestorComedero(2);
        Gato gatos = new Gato(unComedor);
        Perro perros = new Perro(unComedor);
        for (int i = 0; i < 10; i++) {
            Thread unGato = new Thread(gatos);
            Thread unPerro = new Thread(perros);
            unGato.start();
            unPerro.start();
        }
    }
}
