/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package sistema;

/**
 *
 * @author xavie
 */
import Modelo.Jornada;
import Vista.VistaIngreso;
import Vista.VistaDetalle;
import Controlador.ControladorEstacionamiento;

public class Main {
    
    public static void main(String[] args) {
 
        Jornada modelo = new Jornada();
        VistaIngreso ventanaIngreso = new VistaIngreso();
        VistaDetalle ventanaDetalle = new VistaDetalle();
        ControladorEstacionamiento controlador = new ControladorEstacionamiento(ventanaIngreso, ventanaDetalle, modelo);
        controlador.iniciar();
    }
    
}

