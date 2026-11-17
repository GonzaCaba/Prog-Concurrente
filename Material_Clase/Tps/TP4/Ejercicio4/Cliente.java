package Ejercicio4;

public class Cliente implements Runnable {
    private GestorImpresoras centroFotocopiado;

    public Cliente(GestorImpresoras unGestor) {
        this.centroFotocopiado = unGestor;
    }

    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                this.centroFotocopiado.imprimirMaterial();
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
