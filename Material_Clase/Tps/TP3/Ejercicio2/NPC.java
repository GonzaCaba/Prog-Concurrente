package Ejercicio2;

public class NPC implements Runnable {
    private int ptsInflinge;
    private Energia atacchedPlayer;

    public NPC(int ptsInflinge, Energia atacchedPlayer) {
        this.ptsInflinge = ptsInflinge;
        this.atacchedPlayer = atacchedPlayer;
    }

    public void run() {
        try {
            while (this.atacchedPlayer.inflingirPuntos(this.ptsInflinge)) {
            }
        } catch (InterruptedException ie) {
            System.out.println("Error");
        }
    }
}
