package Ejercicio9;

public class Surtidor {
    private final int CAPACIDAD_MAX_SURTIDOR;
    private int capacidadActualSurtidor;
    private boolean camionPresente;

    public Surtidor() {
        CAPACIDAD_MAX_SURTIDOR = 200;
        this.capacidadActualSurtidor = CAPACIDAD_MAX_SURTIDOR;
        this.camionPresente = false;
    }

    // El camion llega: desde ahora los autos no pueden cargar.
    // Si un auto esta cargando, el camion espera a que termine (synchronized).
    public synchronized void llegaCamion() {
        this.camionPresente = true;
        System.out.println("--- Llego el camion: los autos se hacen a un lado ---");
    }

    // El camion termina de cargar: los autos pueden volver a la fila.
    public synchronized void terminaCamion() {
        this.capacidadActualSurtidor = CAPACIDAD_MAX_SURTIDOR;
        this.camionPresente = false;
        System.out.println("--- El camion cargo el surtidor al maximo (" + CAPACIDAD_MAX_SURTIDOR
                + " lts): los autos vuelven a la fila ---");
    }

    // Devuelve los litros cargados, o -1 si hay un camion y el auto debe esperar.
    public synchronized int cargarCombustibleVehiculo(int litros, String patente) {
        if (this.camionPresente) {
            return -1;
        }
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
