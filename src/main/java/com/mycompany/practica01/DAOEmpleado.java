/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ígnot
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado save(Empleado pojo) {
        
        ConexionDB con = ConexionDB.getInstance();
        String sql = "Insert into empleado (clave, nombre, dirección, telefono) values + " + " ('" + pojo.getClave() + "', '" + pojo.getNombre() + "', '"
                + " ('" + pojo.getDireccion() + "', '" + pojo.getTelefono() + "')'";
        
        boolean res = con.execute(sql);
        
        if (res) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Guardado");            
        }
        else{
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Error...");
            return pojo;
        }
                
    }

    @Override
    public Empleado update(Empleado pojo, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado findById(Long id) {
        
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE id = ?";
        
        try {
            
        } catch (Exception e) {
        }
    }

    @Override
    public List<Empleado> findAll() {
        
        try {
            
             ConexionDB con = ConexionDB.getInstance();
        
        ResultSet reg = con.select("Select * from 'nombre tabla /cambiar/'");
        
        List<Empleado> lstEmpleado = new ArrayList<>();
        
        while(reg.next()){
            
            Empleado emp = new Empleado();
            emp.setClave(reg.getInt(1));
            emp.setNombre(reg.getString(2));
            emp.setDireccion(reg.getString(3));
            emp.setTelefono(reg.getString(4));
            lstEmpleado.add(emp);
            
        }        
        return lstEmpleado;
       
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }
        
                
       
    }
    

        
    
}
