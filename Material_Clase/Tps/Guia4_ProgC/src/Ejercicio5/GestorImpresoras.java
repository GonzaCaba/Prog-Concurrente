/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import Ejercicio4.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author gonza
 */
public class GestorImpresoras {
    private boolean[] impresorasTipoA;
    private boolean[] impresorasTipoB;
    private Semaphore dispImpA;
    private Semaphore dispImpB;
    private Semaphore dispGeneral;
    
    public GestorImpresoras(){
        this.impresorasTipoA = new boolean[3];
        this.impresorasTipoB = new boolean[2];
        this.inicializarImpresoras(impresorasTipoA);
        this.inicializarImpresoras(impresorasTipoB);
        dispImpA = new Semaphore(impresorasTipoA.length);
        dispImpB = new Semaphore(impresorasTipoB.length);
    }
    
    private void inicializarImpresoras(boolean[] impresoras){
        int cantImp = impresoras.length;
        for(int varIter = 0; varIter<cantImp; varIter++){
            impresoras[varIter] = true;
        }
    }
    
    public void ocuparImpresoraGen(char tipoImpresora) throws InterruptedException {
        switch (tipoImpresora) {
            case 'a', 'A' -> this.ocuparImpresoraTipoA();
            case 'b', 'B' -> this.ocuparImpresoraTipoB();
            default -> this.ocuparCualquierImpresora();
        }
    }
    
    private void ocuparImpresoraTipoA() throws InterruptedException {
        dispImpA.acquire();
        int cantImp = impresorasTipoA.length;
        int varIter = 0;
        //Buscamos una impresora libre dentro de nuestra coleccion de impresoras.
        boolean encontro = false;
        while (varIter < cantImp && !encontro) {
            if (impresorasTipoA[varIter]) {
                impresorasTipoA[varIter] = false;
                encontro = true;
            } else {
                varIter++;
            }
        }
        System.out.println("El Cliente " + Thread.currentThread().getName() + " esta utilizando "
                + "la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO A...");
        int valorRandom = (int) (Math.floor(Math.random() * 5001 + 1));
        Thread.sleep(valorRandom);
        System.out.println("El Cliente " + Thread.currentThread().getName() + " termino de utilizar"
                + " la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO A!");
        //Liberamos la impresora y el semaforo
        impresorasTipoA[varIter] = true;
        dispImpA.release();
        
    }
    
    private void ocuparImpresoraTipoB() throws InterruptedException {
        dispImpB.acquire();
        int cantImp = impresorasTipoB.length;
        int varIter = 0;
        //Buscamos una impresora libre dentro de nuestra coleccion de impresoras.
        boolean encontro = false;
        while (varIter < cantImp && !encontro) {
            if (impresorasTipoB[varIter]) {
                impresorasTipoB[varIter] = false;
                encontro = true;
            } else {
                varIter++;
            }
        }
        System.out.println("El Cliente " + Thread.currentThread().getName() + " esta utilizando "
                + "la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO B...");
        int valorRandom = (int) (Math.floor(Math.random() * 5001 + 1));
        Thread.sleep(valorRandom);
        System.out.println("El Cliente " + Thread.currentThread().getName() + " termino de utilizar"
                + " la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO B!");
        //Liberamos la impresora y el semaforo
        impresorasTipoB[varIter] = true;
        dispImpB.release();
    }

    private void ocuparCualquierImpresora() throws InterruptedException {
        int varIter = 0;
        boolean exito = false;
        boolean encontro = false;
        char tipoUtilizado;
        while (!exito) {
            if (dispImpA.tryAcquire()) {
                varIter = 0;
                tipoUtilizado = 'A';
                exito = true;
                int cantImpA = impresorasTipoA.length;
                while (varIter < cantImpA && !encontro) {
                    if (impresorasTipoA[varIter]) {
                        impresorasTipoA[varIter] = false;
                        encontro = true;
                    } else {
                        varIter++;
                    }
                }
                System.out.println("El Cliente " + Thread.currentThread().getName() + " esta utilizando "
                        + "la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO A...");
                int valorRandom = (int) (Math.floor(Math.random() * 5001 + 1));
                Thread.sleep(valorRandom);
                System.out.println("El Cliente " + Thread.currentThread().getName() + " termino de utilizar"
                        + " la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO A!");
                //Liberamos la impresora y el semaforo
                impresorasTipoA[varIter] = true;
                dispImpA.release();
            } else if (dispImpB.tryAcquire()) {
                varIter = 0;
                exito = true;
                tipoUtilizado = 'B';
                int cantImpB = impresorasTipoB.length;
                while (varIter < cantImpB && !encontro) {
                    if (impresorasTipoB[varIter]) {
                        impresorasTipoB[varIter] = false;
                        encontro = true;
                    } else {
                        varIter++;
                    }
                }
                System.out.println("El Cliente " + Thread.currentThread().getName() + " esta utilizando "
                        + "la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO B...");
                int valorRandom = (int) (Math.floor(Math.random() * 5001 + 1));
                Thread.sleep(valorRandom);
                System.out.println("El Cliente " + Thread.currentThread().getName() + " termino de utilizar"
                        + " la IMPRESORA NUMERO " + (varIter + 1) + " del TIPO B!");
                //Liberamos la impresora y el semaforo
                impresorasTipoB[varIter] = true;
                dispImpB.release();
            }
        }
    }
}
