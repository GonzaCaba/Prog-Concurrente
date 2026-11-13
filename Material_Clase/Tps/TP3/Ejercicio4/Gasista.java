package Ejercicio4;

public class Gasista implements Runnable {
    private CajaHerramientas ch;

    public Gasista(CajaHerramientas unaCaja) {
        this.ch = unaCaja;
    }

    public void run() {
        int eleccionHerramienta = (int) Math.random();
        int cantVeces = 0;
        try {
            while (cantVeces < 3) {
                switch (eleccionHerramienta) {
                    case 0:
                        ch.usarLlaveCaño();
                        break;
                    case 1:
                        ch.usarNivelLaser();
                        break;
                }
                cantVeces++;
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
