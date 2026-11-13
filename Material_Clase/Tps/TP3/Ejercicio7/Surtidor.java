package Ejercicio7;

public class Surtidor {
    private final int CAPACIDAD_MAX_SURTIDOR;
    private int capacidadActualSurtidor;

    public Surtidor() {
        CAPACIDAD_MAX_SURTIDOR = 200;
        this.capacidadActualSurtidor = CAPACIDAD_MAX_SURTIDOR;
    }

    public synchronized int cargarCombustibleVehiculo(int litros, String patente) {
        int litrosCargados = Math.min(litros, this.capacidadActualSurtidor);
        this.capacidadActualSurtidor -= litrosCargados;
        if (litrosCargados < litros) {
            System.out.println("El surtidor no tiene combustible suficiente para " + patente);
        }
        System.out.println(patente + " ha cargado " + litrosCargados + " lts");
        System.out.println("Al surtidor le quedan " + capacidadActualSurtidor + " lts");
        return litrosCargados;
    }
}
