package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        ParqueAtracciones newPark = new ParqueAtracciones(3);
        ControlTren conductor = new ControlTren(newPark);
        VendedorTickets vendedor = new VendedorTickets(newPark);
        Pasajero unosPasajeros = new Pasajero(newPark);
        Thread unConductor = new Thread(conductor);
        Thread unVendedor = new Thread(vendedor);
        unVendedor.setDaemon(true);
        unConductor.setDaemon(true);
        unConductor.start();
        unVendedor.start();
        for (int i = 0; i < 6; i++) {
            Thread unPasajero = new Thread(unosPasajeros, ("Pasajero " + (i + 1)));
            unPasajero.start();
        }
    }
}
