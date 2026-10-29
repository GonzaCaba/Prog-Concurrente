public class Contador {
    int valor;

    public Contador(){
        valor = 0;
    }

    public int getValor(){
        return this.valor;
    }

    public void setValor(int unValor){
        this.valor = unValor;
    }

    public void incrementar(){
        this.valor = this.valor + 1;
    }

    public void incrementar(int unIncremento){
        this.valor = this.valor + unIncremento;
    }
}
