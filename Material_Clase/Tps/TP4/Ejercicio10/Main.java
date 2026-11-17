package Ejercicio10;

public class Main {
    public static void main(String[] args) {
        final int BARBEROS = 2;
        final int SILLAS = 2;
        final int CLIENTES = 8;

        Barberia barberia = new Barberia(BARBEROS, SILLAS);

        for (int i = 0; i < BARBEROS; i++) {
            Barbero barbero = new Barbero(barberia, barberia.getSillon(i));
            barbero.setDaemon(true);
            barbero.start();
        }

        for (int i = 1; i <= CLIENTES; i++) {
            new Cliente(barberia, "Cliente-" + i).start();
        }
    }
}
