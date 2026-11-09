package Ejercicio8;

public class TesteoCompra {
    void main() {
        CompraCliente compra1 = new CompraCliente("CompraCliente1");
        CompraCliente compra2 = new CompraCliente("CompraCliente2");

        long initialTime = System.currentTimeMillis();

        Cajero cajero1 = new Cajero("Gustavo", initialTime, compra1);
        Cajero cajero2 = new Cajero("Nicolas", initialTime, compra2);

        Thread t1 = new Thread(cajero1);
        Thread t2 = new Thread(cajero2);

        t1.start();
        t2.start();
    }
}
