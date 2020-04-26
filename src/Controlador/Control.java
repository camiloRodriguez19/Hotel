/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
import Servicios.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Control implements ActionListener {
    
    Vista vista;
    Alquiler alquiler;
    TipoHabitacion tipoHabitacion;
    Usuario usuario;
    Conexion conexion;
    UsuarioServicios usuarioServicio;

    public Control() throws SQLException, ClassNotFoundException {
        
    vista = new Vista();
    alquiler = new Alquiler();
    tipoHabitacion = new TipoHabitacion();
    usuario = new Usuario();
    conexion = new Conexion();
    usuarioServicio = new UsuarioServicios();
    vista.InicializarListener(this);
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnRegistrar){
            
            String identificacion = vista.txtDocumento.getText();
            String id = identificacion.substring(identificacion.length()-4);
            usuario = new Usuario(id, vista.txtNombre.getText(), identificacion, Integer.parseInt(vista.txtEdad.getText()));
            try {
                usuarioServicio.Guardar(conexion.getCnx(), usuario);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Control c = new Control();
        c.vista.setVisible(true);
    }
}
