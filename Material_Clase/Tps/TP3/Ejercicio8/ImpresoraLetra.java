package Ejercicio8;

public class ImpresoraLetra extends Thread {
    private char letra;
    private int cantVeces;
    private Turno unTurno;
    private char letraQueSigue;

    public ImpresoraLetra(char unaLetra, int cantVeces, Turno unTurno, char letraQueSigue) {
        this.letra = unaLetra;
        this.cantVeces = cantVeces;
        this.unTurno = unTurno;
        this.letraQueSigue = letraQueSigue;
    }

    public void run() {
        while (true) {
            try {
                if (this.unTurno.imprimirLetra(this.letra, this.cantVeces, this.letraQueSigue)) {
                    Thread.sleep(1500);
                }
            } catch (InterruptedException ie) {
                System.out.println("Error");
            }
        }
    }

}
