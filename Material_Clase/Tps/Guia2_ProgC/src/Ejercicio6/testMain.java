
package Ejercicio6;


public class testMain {

    public static void main(String[] args) {
        Corredor[] corredores = new Corredor[3];
        Thread[] hilos = new Thread[corredores.length];
        for(int i=0; i<corredores.length; i++){
            corredores[i] = new Corredor("Corredor "+(i+1));
            hilos[i] = new Thread(corredores[i]);
        }
        System.out.println("CORREDORES PREPARANDOSE.....");
        for(int i=0; i<corredores.length; i++)
            hilos[i].start();
        System.out.println("CORREDORES EN CARRERA....");
        try{
            for(int i=0; i<corredores.length; i++)
                hilos[i].join();
        }catch(InterruptedException e){}
        System.out.println("--- CARRERA FINALIZADA ---");
        Corredor corMasRapido = null;
        int mayorDistancia = -10;
        for(int i=0; i<corredores.length; i++){            
            if(corredores[i].getDistancia() > mayorDistancia){
                mayorDistancia = corredores[i].getDistancia();
                corMasRapido = corredores[i];
            }
        }
        System.out.println("El corredor que hizo la mayor distancia fue el "+corMasRapido.getNombre()+" y recorrio "+mayorDistancia+"km");
    }
    
}
