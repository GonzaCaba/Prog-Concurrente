package Ejercicio7;

import java.util.concurrent.ThreadLocalRandom;

public class CompraCliente {
    private String nombre;
    private int[] productos;
    private final int PRODUCTOS_MINIMOS = 1;
    private final int PRODUCTOS_MAXIMOS = 10;

    // Constructor
    public CompraCliente(String unNombre) {
        int cantidadProductos = ThreadLocalRandom.current().nextInt(PRODUCTOS_MINIMOS, PRODUCTOS_MAXIMOS + 1);
        this.nombre = unNombre;
        this.productos = new int[cantidadProductos];
        for (int i = 0; i < cantidadProductos; i++) {
            this.productos[i] = generarTiempoMsAleatorio();
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public int[] getProductos() {
        return this.productos;
    }

    private int generarTiempoMsAleatorio() {
        int tiempoMinimo = 1;
        int tiempoMaximo = 7;
        int tiempo = (ThreadLocalRandom.current().nextInt(tiempoMinimo, tiempoMaximo + 1)) * 1000;
        return tiempo;
    }

}
