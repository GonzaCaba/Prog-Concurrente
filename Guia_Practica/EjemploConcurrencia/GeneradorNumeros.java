public class generadorNumeros implements Runnable{
    private String nombre;
    private Contador cuenta;
    private int cantidad;

    public generadorNumeros(String unNombre, Contador unContador, int maximo){
        this.nombre = unNombre;
        this.cuenta = unContador;
        this.cantidad = maximo;
    }

    public void run(){
        int totalNro = 0;
        double nroAleatorio;
        for(int i=1;i<cantidad;i++){
            nroAleatorio = Math.random() * 10;
            if(nroAleatorio > 5 && nroAleatorio < 6){
                totalNro++;
            }
        }
        this.cuenta.incrementar(totalNro);
        System.out.println("hilo "+this.nombre + "genero "+totalNro+" numeros");
    }
}
