/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author gonza
 */
public class CuentaBanco {
    private int balance;
    
    public CuentaBanco(){
        this.balance = 50;
    }
    
    public synchronized int getBalance(){ 
        return this.balance;
    }
    
    public synchronized void retiroBancario(int retiro){
        this.balance = this.balance-retiro; 
    }
}
