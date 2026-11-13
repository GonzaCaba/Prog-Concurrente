package Ejercicio4;

public class Electricista implements Runnable {
    private CajaHerramientas ch;

    public Electricista(CajaHerramientas unaCaja) {
        this.ch = unaCaja;
    }

    public void run() {
        int eleccionHerramienta = (int) Math.random();
        int cantVeces = 0;
        try {
            while (cantVeces < 3) {
                switch (eleccionHerramienta) {
                    case 0:
                        ch.usarBuscaPolos();
                        break;
                    case 1:
                        ch.usarcintaMetrica();
                        break;
                }
                cantVeces++;
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
