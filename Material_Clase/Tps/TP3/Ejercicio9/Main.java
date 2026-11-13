package Ejercicio9;

public class Main {
    public static void main(String[] args) {
        Surtidor unSurtidor = new Surtidor();
        Auto auto1 = new Auto("AB 410 FT", "Toyota", "Corolla", unSurtidor);
        Auto auto2 = new Auto("AG 123 GF", "Ford", "Focus", unSurtidor);
        Auto auto3 = new Auto("BA 100 AA", "Fiat", "Cronos", unSurtidor);
        Auto auto4 = new Auto("AZ 999 ZZ", "Renault", "Sandero", unSurtidor);
        Auto auto5 = new Auto("AC 555 KL", "Volkswagen", "Gol", unSurtidor);
        Camion unCamion = new Camion(unSurtidor);
        Camion camion = new Camion(unSurtidor);
        camion.setDaemon(true); // no impide que el programa termine cuando acaban los autos
        camion.start();
        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
        unCamion.start();
    }
}
