package Ejercicio2_Mod;

public class Main {
    public static void main(String[] args) {
        Confiteria unaConfiteria = new Confiteria();
        Empleado unEmpleado = new Empleado(unaConfiteria);
        Mozo unMozo = new Mozo(unaConfiteria);
        Cocinero unCocinero = new Cocinero(unaConfiteria);
        Thread cocinero = new Thread(unCocinero);
        Thread mozo = new Thread(unMozo);
        mozo.start();
        cocinero.start();
        Thread cliente1 = new Thread(unEmpleado, "Joaquin");
        Thread cliente2 = new Thread(unEmpleado, "Matias");
        Thread cliente3 = new Thread(unEmpleado, "Agustina");
        Thread cliente4 = new Thread(unEmpleado, "Gonzalo");
        Thread cliente5 = new Thread(unEmpleado, "Mateo");
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
    }
}
