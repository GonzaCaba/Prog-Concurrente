package Ejercicio8;

public class Main {
    public static void main(String[] args) {
        Turno unTurno = new Turno('A');
        ImpresoraLetra letraA = new ImpresoraLetra('A', 1, unTurno, 'B');
        ImpresoraLetra letraB = new ImpresoraLetra('B', 2, unTurno, 'C');
        ImpresoraLetra letraC = new ImpresoraLetra('C', 3, unTurno, 'A');
        letraA.start();
        letraB.start();
        letraC.start();
    }
}
