package Ejercicio4;

public class CajaHerramientas {
    private Object cucharaAlbañil;
    private Object buscaPolos;
    private Object llaveCaño;
    private Object nivelLaser;
    private Object cintaMetrica;

    public CajaHerramientas() {
        this.cucharaAlbañil = new Object();
        this.buscaPolos = new Object();
        this.llaveCaño = new Object();
        this.nivelLaser = new Object();
        this.cintaMetrica = new Object();
    }

    public void usarCucharaAlbañil() throws InterruptedException {
        synchronized (this.cucharaAlbañil) {
            System.out.println(Thread.currentThread().getName() + " esta utilizando la cuchara de albañil...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " ha terminado de utilizar la cuchara.");
        }
    }

    public void usarBuscaPolos() throws InterruptedException {
        synchronized (this.buscaPolos) {
            System.out.println(Thread.currentThread().getName() + " esta utilizando el buscapolos...");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " ha terminado de utilizar el buscapolos.");
        }
    }

    public void usarNivelLaser() throws InterruptedException {
        synchronized (this.nivelLaser) {
            System.out.println(Thread.currentThread().getName() + " esta utilizando el nivel laser...");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " ha terminado de utilizar el nivel laser.");
        }
    }

    public void usarLlaveCaño() throws InterruptedException {
        synchronized (this.llaveCaño) {
            System.out.println(Thread.currentThread().getName() + " esta utilizando la llave caño...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " ha terminado de utilizar la llave caño.");
        }
    }

    public void usarcintaMetrica() throws InterruptedException {
        synchronized (this.cintaMetrica) {
            System.out.println(Thread.currentThread().getName() + " esta utilizando la cinta metrica...");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " ha terminado de utilizar la cinta metrica.");
        }
    }
}
