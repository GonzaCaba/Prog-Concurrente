package Ejercicio7;

public class TesteoCompra {
    public static void main(String[] args) {
        CompraCliente compra1 = new CompraCliente("CompraCliente1");
        CompraCliente compra2 = new CompraCliente("CompraCliente2");

        long initialTime = System.currentTimeMillis();

        Cajero cajero1 = new Cajero("Gustavo", initialTime, compra1);
        Cajero cajero2 = new Cajero("Nicolas", initialTime, compra2);

        cajero1.start();
        cajero2.start();
    }
}
