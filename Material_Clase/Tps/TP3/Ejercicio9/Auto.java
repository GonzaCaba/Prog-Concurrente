package Ejercicio9;

import java.util.Random;

public class Auto extends Thread {
    private static final int CAPACIDAD_MAXIMA_TANQUE = 48;
    private static final int RESERVA = 8;

    private String patente;
    private String marca;
    private String modelo;
    private int km_recorridos;
    private int combustibleLts;
    private Surtidor surtidor;

    public Auto(String patente, String marca, String modelo, Surtidor unSurtidor) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.combustibleLts = 24;
        // SON TODOS LOS AUTOS 0KM VIVIMOS EN DUBAI
        this.km_recorridos = 0;
        this.surtidor = unSurtidor;
    }

    public String getPatente() {
        return this.patente;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getKmRecorridos() {
        return this.km_recorridos;
    }

    public void cargarCombustible() {
        int pedido = CAPACIDAD_MAXIMA_TANQUE - this.combustibleLts; // llenar el tanque
        int recibido = this.surtidor.cargarCombustibleVehiculo(pedido, this.patente);
        while (recibido < 0) { // hay un camion cargando el surtidor: espero a un lado
            System.out.println(patente + " espera a un lado porque esta el camion");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Error");
            }
            recibido = this.surtidor.cargarCombustibleVehiculo(pedido, this.patente);
        }
        this.combustibleLts += recibido;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(patente + " (" + marca + " " + modelo + ") esta recorriendo las calles");
            int km = random.nextInt(100) + 1;
            this.km_recorridos += km;
            int gastado = km / 2;
            this.combustibleLts = Math.max(0, this.combustibleLts - gastado);
            if (this.combustibleLts <= RESERVA) {
                System.out.println(patente + " llego a la reserva (" + combustibleLts + " lts), va a cargar");
                this.cargarCombustible();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                System.out.println("Error");
            }
        }
        System.out.println(
                patente + " termino. Km totales: " + km_recorridos + ", combustible: " + combustibleLts + " lts");
    }
}
