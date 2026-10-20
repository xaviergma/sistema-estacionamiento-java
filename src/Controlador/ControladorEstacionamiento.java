/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
/**
 *
 * @author xavie
 */
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorEstacionamiento {
    
    private final VistaIngreso vIngreso;
    private final VistaDetalle vDetalle;
    private final Jornada jornada;

    public ControladorEstacionamiento(VistaIngreso vIngreso, VistaDetalle vDetalle, Jornada jornada) {
        this.vIngreso = vIngreso;
        this.vDetalle = vDetalle;
        this.jornada = jornada;
        this.vIngreso.btnCalcular.addActionListener((ActionEvent e) -> {
            guardarVehiculo();
        });
        this.vIngreso.btnVerDetalle.addActionListener((ActionEvent e) -> {
            mostrarDetalle();
        });
        this.vDetalle.btnVolver.addActionListener((ActionEvent e) -> {
            vDetalle.setVisible(false);
            vIngreso.setVisible(true); 
        });
    }

    public void iniciar() {
        vIngreso.setTitle("Sistema de Estacionamiento");
        vIngreso.setLocationRelativeTo(null);
        vIngreso.setVisible(true);
    }


    private void guardarVehiculo() {
        try {
            String patente = vIngreso.txtPatente.getText();
            int horas = Integer.parseInt(vIngreso.txtHoras.getText());
            String tipo = (String) vIngreso.cbTipo.getSelectedItem();

            Vehiculo vehiculo = null;
            switch (tipo) {
                case "Auto" -> vehiculo = new Auto(patente, horas);
                case "Moto" -> vehiculo = new Moto(patente, horas);
                case "Camioneta" -> vehiculo = new Camioneta(patente, horas);
                default -> {
                }
            }

            if (vehiculo != null) {
                jornada.agregarVehiculo(vehiculo);
                double aPagar = vehiculo.calcularImporte(); 
                JOptionPane.showMessageDialog(vIngreso, "Guardado exitosamente.\nImporte a cobrar: $" + aPagar);
                
                vIngreso.txtPatente.setText("");
                vIngreso.txtHoras.setText("");
            }
            
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(vIngreso, "Error: Las horas deben ser un número entero.");
        }
    }

    private void mostrarDetalle() {
        vDetalle.modeloTabla.setRowCount(0);

        for (Vehiculo v : jornada.getListaVehiculos()) {
            
            String tipoVehiculo = v.getClass().getSimpleName(); 
            
            vDetalle.modeloTabla.addRow(new Object[]{
                v.getPatente(), 
                tipoVehiculo, 
                v.getHoras(), 
                "$" + v.calcularImporte()
            });
        }

        vDetalle.lblTotal.setText("Total Recaudado: $" + jornada.calcularTotalRecaudado());

        vIngreso.setVisible(false);
        vDetalle.setLocationRelativeTo(null);
        vDetalle.setVisible(true);
    }
}