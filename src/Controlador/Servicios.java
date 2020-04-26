/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Servicios.*;
import Vista.*;

/**
 *
 * @author usuario
 */
public class Servicios {
    
    Vista vista;
    
    public void Alquilar(Alquiler alquiler){
        
        try{
            UsuarioServicios us = new UsuarioServicios();
            us.Guardar(Conexion.obtener(), alquiler.getUsuario());
            
        }catch(Exception e){
            
        }
    }
    
}
