public class PingPongRunnable implements Runnable {
    private String cadena;
    private int delay;

    public PingPongRunnable(String cartel, int cantMs){
        this.cadena = cartel;
        this.delay = cantMs;
    }

    public void run(){
        for (int i=1; i<delay*10;i++){
            System.out.println(cadena + "");
            try{
                Thread.sleep(delay);
            } catch(InterruptedException e){

            };
        }
    }
}
