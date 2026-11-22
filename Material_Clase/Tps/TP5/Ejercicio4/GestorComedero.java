package Ejercicio4;

import java.util.concurrent.Semaphore;

public class GestorComedero {
    private Semaphore comederos;
    private int cantComederos;
    private Semaphore racionDividida; // Permite que un solo perro a la vez coma sus dos raciones en un unico
                                      // comedero. Solo se usa si la cantidad de comederos es impar.
    private int limiteTanda; // Maximo de animales de una especie que pueden pasar en una tanda si la otra
                             // especie esta esperando
    private int cantPerrosAdentro; // Representa la cantidad de perros adentro del comedor, no los que estan
                                   // comiendo
    private int cantGatosAdentro; // Mismo con los gatos
    private int cantGatosEsperando; // Gatos que todavia no pasaron al comedor
    private int cantPerrosEsperando; // Perros que todavia no pasaron al comedor
    private int cantPerrosComieronTanda; // Perros que pasaron al comedor en la tanda actual
    private int cantGatosComieronTanda; // Gatos que pasaron al comedor en la tanda actual
    private Semaphore mutexPerro;
    private Semaphore mutexGato;
    private Semaphore mutexGatoEsperando;
    private Semaphore mutexPerroEsperando;
    private Semaphore pasaAnimal;
    private Semaphore gatoNuevo; // Torniquete: si esta cerrado, los gatos nuevos se quedan bloqueados aca
    private Semaphore perroNuevo; // Torniquete: si esta cerrado, los perros nuevos se quedan bloqueados aca

    public GestorComedero(int cantComederos) {
        this.cantComederos = cantComederos;
        this.comederos = new Semaphore(cantComederos, true); // Justo: un perro que espera sus 2 permisos no es
                                                             // adelantado por los que piden 1
        this.racionDividida = new Semaphore(1);
        this.limiteTanda = cantComederos * 2;
        this.mutexPerro = new Semaphore(1);
        this.mutexGato = new Semaphore(1);
        this.pasaAnimal = new Semaphore(1, true); // Justo: respeta el orden de llegada para evitar inanicion
        this.mutexGatoEsperando = new Semaphore(1);
        this.mutexPerroEsperando = new Semaphore(1);
        this.gatoNuevo = new Semaphore(1);
        this.perroNuevo = new Semaphore(1);
        this.cantPerrosAdentro = 0;
        this.cantGatosAdentro = 0;
        this.cantPerrosComieronTanda = 0;
        this.cantGatosComieronTanda = 0;
        this.cantGatosEsperando = 0;
        this.cantPerrosEsperando = 0;
    }

    public void gatoCome() throws InterruptedException {
        // Adquiere el mutex y suma uno a la cantidad de gatos esperando para entrar a
        // la sala.
        this.mutexGatoEsperando.acquire();
        this.cantGatosEsperando++;
        this.mutexGatoEsperando.release();

        this.gatoNuevo.acquire(); // Si el torniquete esta cerrado, se queda bloqueado hasta que reabra
        this.mutexGato.acquire();
        // Si hay perros esperando y la cantidad de gatos que ya pasaron en esta tanda
        // alcanzo el limite, cede el turno.
        this.mutexPerroEsperando.acquire();
        boolean cederTurno = this.cantGatosAdentro > 0 && this.cantPerrosEsperando > 0
                && this.cantGatosComieronTanda >= this.limiteTanda;
        this.mutexPerroEsperando.release();

        if (cederTurno) {
            // Libera el mutex para que los gatos que estan adentro puedan salir, y se
            // queda en la fila de la puerta detras de los perros. Mientras tanto el
            // torniquete sigue cerrado y no entran mas gatos.
            this.mutexGato.release();
            this.pasaAnimal.acquire();
            this.mutexGato.acquire();
            this.cantGatosComieronTanda = 0;
        } else if (this.cantGatosAdentro == 0) {
            // Verifica si la puerta esta abierta para los animales de su tipo
            this.pasaAnimal.acquire(); // Si lo adquiere, no habia perros en la sala.
            this.cantGatosComieronTanda = 0;
        }

        this.cantGatosAdentro++; // Pasa el gato al comedor
        this.cantGatosComieronTanda++;
        // Decrementa en uno ya que el gato ya no esta esperando si no que ya entro
        this.mutexGatoEsperando.acquire();
        this.cantGatosEsperando--;
        this.mutexGatoEsperando.release();
        this.mutexGato.release();
        this.gatoNuevo.release(); // Reabre el torniquete para el siguiente gato
        this.comederos.acquire(); // Si hay un comedero disponible, si no se queda bloqueado

        System.out.println("Un gato ha pasado al comedor y esta comiendo");
        Thread.sleep(500 * ((int) (Math.random() * 4) + 1));
        System.out.println("Un gato ha terminado de comer y se retira del comedor");

        this.mutexGato.acquire();
        this.cantGatosAdentro--;
        this.comederos.release();
        // Si es el ultimo animal cambia el flujo y entran perros.
        if (this.cantGatosAdentro == 0) {
            this.pasaAnimal.release();
        }
        this.mutexGato.release();
    }

    public void perroCome() throws InterruptedException {
        // Adquiere el mutex y suma uno a la cantidad de perros esperando para entrar a
        // la sala.
        this.mutexPerroEsperando.acquire();
        this.cantPerrosEsperando++;
        this.mutexPerroEsperando.release();

        this.perroNuevo.acquire(); // Si el torniquete esta cerrado, se queda bloqueado hasta que reabra
        this.mutexPerro.acquire();
        // Si hay gatos esperando y la cantidad de perros que ya pasaron en esta tanda
        // alcanzo el limite, cede el turno.
        this.mutexGatoEsperando.acquire();
        boolean cederTurno = this.cantPerrosAdentro > 0 && this.cantGatosEsperando > 0
                && this.cantPerrosComieronTanda >= this.limiteTanda;
        this.mutexGatoEsperando.release();

        if (cederTurno) {
            // Libera el mutex para que los perros que estan adentro puedan salir, y se
            // queda en la fila de la puerta detras de los gatos. Mientras tanto el
            // torniquete sigue cerrado y no entran mas perros.
            this.mutexPerro.release();
            this.pasaAnimal.acquire();
            this.mutexPerro.acquire();
            this.cantPerrosComieronTanda = 0;
        } else if (this.cantPerrosAdentro == 0) {
            // Verifica si la puerta esta abierta para los animales de su tipo
            this.pasaAnimal.acquire(); // Si lo adquiere, no habia gatos en la sala.
            this.cantPerrosComieronTanda = 0;
        }

        this.cantPerrosAdentro++; // Pasa el perro al comedor
        this.cantPerrosComieronTanda++;
        // Decrementa en uno ya que el perro ya no esta esperando si no que ya entro
        this.mutexPerroEsperando.acquire();
        this.cantPerrosEsperando--;
        this.mutexPerroEsperando.release();
        this.mutexPerro.release();
        this.perroNuevo.release(); // Reabre el torniquete para el siguiente perro

        // Si la cantidad de comederos es impar, un solo perro a la vez puede comer sus
        // dos raciones en un unico comedero (una despues de la otra), asi el comedero
        // que sobra no queda sin usar. Con un solo comedero todos los perros comen asi.
        boolean comeDividido = false;
        if (this.cantComederos == 1) {
            this.racionDividida.acquire();
            comeDividido = true;
        } else if (this.cantComederos % 2 == 1) {
            comeDividido = this.racionDividida.tryAcquire();
        }

        if (comeDividido) {
            this.comederos.acquire(); // Un comedero para sus dos raciones
        } else {
            this.comederos.acquire(2); // Dos comederos a la vez, si no hay se queda bloqueado
        }

        System.out.println("Un perro ha pasado al comedor y esta comiendo");
        Thread.sleep(500 * ((int) (Math.random() * 4) + 1));
        if (comeDividido) {
            System.out.println("Un perro termino su primera racion y sigue con la segunda en el mismo comedero");
            Thread.sleep(500 * ((int) (Math.random() * 4) + 1));
        }
        System.out.println("Un perro ha terminado de comer y se retira del comedor");

        this.mutexPerro.acquire();
        this.cantPerrosAdentro--;
        if (comeDividido) {
            this.comederos.release();
            this.racionDividida.release();
        } else {
            this.comederos.release(2);
        }
        // Si es el ultimo animal cambia el flujo y entran gatos.
        if (this.cantPerrosAdentro == 0) {
            this.pasaAnimal.release();
        }
        this.mutexPerro.release();
    }
}
