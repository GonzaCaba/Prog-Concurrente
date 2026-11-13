package Ejercicio4;

public class Albañil implements Runnable {
    private CajaHerramientas ch;

    public Albañil(CajaHerramientas unaCaja) {
        this.ch = unaCaja;
    }

    public void run() {
        int eleccionHerramienta = (int) Math.random() * 2;
        int cantVeces = 0;
        try {
            while (cantVeces < 3) {
                switch (eleccionHerramienta) {
                    case 0:
                        ch.usarCucharaAlbañil();
                        break;
                    case 1:
                        ch.usarNivelLaser();
                        break;
                    case 2:
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
