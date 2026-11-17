package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        GestorImpresoras miGestor = new GestorImpresoras();
        Cliente clientes = new Cliente(miGestor);
        for (int i = 0; i < 10; i++) {
            Thread clienteNro = new Thread(clientes, ("Cliente" + (i + 1)));
            clienteNro.start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
