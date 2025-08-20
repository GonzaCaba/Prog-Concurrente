
package Ejercicio6;

/**
 *
 * @author gonza
 */
public class Corredor implements Runnable {
    private String nombre;
    private int distancia = 0;
    
    public Corredor(String nombre){
        this.nombre = nombre;
    }
    
    public void run(){
        for(int i=1; i<=100; i++){
            int avance =  (int) (Math.random()*10);
            System.out.println("EL CORREDOR "+this.nombre+" AVANZO "+avance+" EN EL PASO "+i);
            this.distancia = this.distancia + avance;
            try{
                Thread.sleep(200);
            } catch (InterruptedException e){}
        }
    }
    
    public int getDistancia(){
        return this.distancia;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
