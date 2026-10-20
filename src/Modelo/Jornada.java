/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author xavie
 */
public class Jornada {
    private final List<Vehiculo> listaVehiculos;
    
    public Jornada() {
        this.listaVehiculos= new ArrayList<>();
    }
    
    public void agregarVehiculo(Vehiculo v){
        listaVehiculos.add(v);
    }
    
    public List<Vehiculo> getListaVehiculos(){
        return listaVehiculos;
    }
    
    public double calcularTotalRecaudado(){
        double total=0;
        for (Vehiculo v : listaVehiculos){
            total += v.calcularImporte();
        }
        return total;
    }
}
