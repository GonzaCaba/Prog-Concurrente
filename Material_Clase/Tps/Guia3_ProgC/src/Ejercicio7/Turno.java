
package Ejercicio7;

/**
 *
 * @author gonza
 */
public class Turno {
    int nroTurno;
    
    public Turno(){
        this.nroTurno = 0;
    }
    
    public synchronized int getNroTurno(){
        return this.nroTurno;
    }
    
    public synchronized void pasarTurno(){
        if(this.nroTurno+1 > 2){
            this.nroTurno = 0;
        }
        else{
            this.nroTurno++;
        }
    }
}
