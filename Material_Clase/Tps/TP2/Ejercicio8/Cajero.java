package Ejercicio8;

public class Cajero implements Runnable {
    private String nombre;
    private long initialTime;
    private CompraCliente compraCliente;

    public Cajero(String unNombre, long initialTime, CompraCliente compraCliente) {
        this.nombre = unNombre;
        this.initialTime = initialTime;
        this.compraCliente = compraCliente;
    }

    public void run() {
        IO.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.compraCliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + " seg");
        for (int i = 0; i < this.compraCliente.getProductos().length; i++) {
            this.esperarXsegundos(this.compraCliente.getProductos()[i]);
            System.out.println("Procesando el producto " + (i + 1) + " -> Tiempo: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
        }

        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + this.compraCliente.getNombre()
                + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
    }

    public void esperarXsegundos(int tiempo) {
        try {
            Thread.currentThread().sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

}
