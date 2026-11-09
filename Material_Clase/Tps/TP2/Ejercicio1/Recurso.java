public class Recurso {
    public Recurso() {
    }

    public void uso() {
        Thread t = Thread.currentThread();
        System.out.println("soy " + t.getName() + " y estoy usando el recurso");
    }
}
