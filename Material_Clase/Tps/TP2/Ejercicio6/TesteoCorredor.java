package Ejercicio6;

public class TesteoCorredor {
    public static void main(String[] args) {
        int numerosCorredores = 100;
        Corredor[] corredores = new Corredor[numerosCorredores];
        Thread[] lineaSalida = new Thread[numerosCorredores];

        for (int i = 0; i < lineaSalida.length; i++) {
            Corredor unCorredor = new Corredor(String.valueOf(i));
            corredores[i] = unCorredor;

            Thread corredor = new Thread(unCorredor);
            lineaSalida[i] = corredor;
        }

        for (int i = 0; i < lineaSalida.length; i++) {
            lineaSalida[i].start();
        }

        for (int i = 0; i < lineaSalida.length; i++) {
            try {
                lineaSalida[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        float mayorDistancia = 0;
        Corredor corredorGanador = null;
        for (int i = 0; i < lineaSalida.length; i++) {
            if (corredores[i].distanciaRecorridaMetros > mayorDistancia) {
                corredorGanador = corredores[i];
                mayorDistancia = corredorGanador.distanciaRecorridaMetros;
            }
        }
        try {
            System.out.println("El corredor ganador es el numero " + corredorGanador.nombreCorredor + " y recorrio "
                    + corredorGanador.distanciaRecorridaMetros + " metros");
        } catch (NullPointerException e) {
            System.out.println("Al parecer, no hay ningun corredor que haya ganado la carrera");
        }

    }
}
