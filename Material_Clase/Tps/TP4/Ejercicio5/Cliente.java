package Ejercicio5;

import java.util.Random;

public class Cliente implements Runnable {
    private GestorImpresoras centroFotocopiado;

    public Cliente(GestorImpresoras unGestor) {
        this.centroFotocopiado = unGestor;
    }

    public void run() {
        try {
            Random random = new Random();
            int nroRandom = random.nextInt(3);
            char eleccionRandom = 0;
            switch (nroRandom) {
                case 0:
                    eleccionRandom = 'A';
                    break;
                case 1:
                    eleccionRandom = 'B';
                    break;
                case 2:
                    eleccionRandom = 'X';
                    break;
            }
            for (int i = 0; i < 2; i++) {
                this.centroFotocopiado.imprimirMaterial(eleccionRandom);
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
