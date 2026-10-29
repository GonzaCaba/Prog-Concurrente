public class TestGenerador {
    public static void main(String[] args){
        Contador elContador = new Contador();
        generadorNumeros genera1, genera2;
        Thread hilo1, hilo2;
        genera1 = new generadorNumeros("soyGen_1 ",elContador, 100 ); 
        hilo1 = new Thread(genera1);
        genera2 = new generadorNumeros("soyGen_2 ",elContador, 130 ); 
        hilo2 = new Thread(genera2);
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e){}
        System.out.println("total de numeros generados por los hilos "+ elContador.getValor());
    }
}
