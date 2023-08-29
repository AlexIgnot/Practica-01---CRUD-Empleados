/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica01;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ígnot
 */
public class Practica01 {

    public static void main(String[] args) {
        
       DAOEmpleado dao = new DAOEmpleado();
       
        List<Empleado> lstEmpleado = dao.findAll();
        
        for(Iterator<Empleado> iterator = lstEmpleado.iterator();
                iterator.hasNext();){
            Empleado emp = iterator.next();
            System.out.println("Clave: " + emp.getClave() + ", Nombre: " + emp.getNombre() + ", Direccion: " + emp.getDireccion() + ", Teléfono: " + emp.getTelefono());
        }
        
    }
}
