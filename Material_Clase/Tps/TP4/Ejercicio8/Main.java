package Ejercicio8;

public class Main {
    public static void main(String[] args) {
        Confiteria unaConfiteria = new Confiteria();
        Empleado unEmpleado = new Empleado(unaConfiteria);
        Mozo unMozo = new Mozo(unaConfiteria);
        Thread mozo = new Thread(unMozo);
        mozo.start();
        Thread cliente1 = new Thread(unEmpleado, "Joaquin");
        Thread cliente2 = new Thread(unEmpleado, "Matias");
        Thread cliente3 = new Thread(unEmpleado, "Agustina");
        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
}
