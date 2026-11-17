package Ejercicio6;

public class Main {
    public static void main(String[] args) {
        Taxi unTaxi = new Taxi();
        Cliente unCliente = new Cliente(unTaxi);
        Taxista unTaxista = new Taxista(unTaxi);
        Thread taxista = new Thread(unTaxista, "Juan");
        Thread cliente1 = new Thread(unCliente, "Romelio");
        Thread cliente2 = new Thread(unCliente, "Matilda");
        Thread cliente3 = new Thread(unCliente, "Josefina");
        taxista.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
}
