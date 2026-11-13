package Ejercicio4;

public class Main {
    public static void main(String args[]) {
        CajaHerramientas unacCajaHerramientas = new CajaHerramientas();
        Albañil alb = new Albañil(unacCajaHerramientas);
        Electricista elec = new Electricista(unacCajaHerramientas);
        Gasista gas = new Gasista(unacCajaHerramientas);

        Thread albañil1 = new Thread(alb, "Pedro Albañil");
        Thread albañil2 = new Thread(alb, "Juan Albañil");
        Thread electricista = new Thread(elec, "Jorge Electricista");
        Thread gasista = new Thread(gas, "Nicolas Gasista");

        albañil1.start();
        albañil2.start();
        electricista.start();
        gasista.start();
    }
}
