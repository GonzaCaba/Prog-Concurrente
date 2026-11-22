package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        GestorPiscina uPiscina = new GestorPiscina(2);
        Persona unaPersona = new Persona(uPiscina);
        Thread persona1 = new Thread(unaPersona, "Juan");
        Thread persona2 = new Thread(unaPersona, "Maria");
        Thread persona3 = new Thread(unaPersona, "Nicolas");
        Thread persona4 = new Thread(unaPersona, "Agustina");
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
    }
}
