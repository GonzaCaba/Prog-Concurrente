
package Ejercicio3;

/**
 *
 * @author gonza
 */
public class Jaula {
    private Comida comidaOcup;
    private Rueda ruedaOcup;
    private Hamaca hamacaOcup;
    
    public Jaula(){
        this.comidaOcup = new Comida();
        this.ruedaOcup = new Rueda();
        this.hamacaOcup = new Hamaca();
    }

    public boolean ocuparComida() {
        return comidaOcup.ocuparComida();
    }

    public boolean ocuparRueda() {
        return ruedaOcup.ocuparRueda();
    }

    public boolean ocuparHamaca() {
        return hamacaOcup.ocuparHamaca();
    }
    
    public void liberarComida(){
        comidaOcup.setEstadoOcupado(false);
    }
    
    public void liberarRueda(){
        ruedaOcup.setEstadoOcupado(false);
    }
    
    public void liberarHamaca(){
        hamacaOcup.setEstadoOcupado(false);
    }
}
