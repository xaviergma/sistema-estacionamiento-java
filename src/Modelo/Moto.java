/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author xavie
 */
public class Moto extends Vehiculo {

    public Moto(String patente, int horas) {
        super(patente, horas);
        
        
    }

    @Override
    public double calcularImporte() {
       return getHoras()*500.0;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 

    
    
}
