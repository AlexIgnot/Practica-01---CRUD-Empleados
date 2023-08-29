package com.mycompany.practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    
    public static ConexionDB cx = null;
    public static ConexionDB getInstance(){
        if (cx == null) {
            cx = new ConexionDB();
            return cx;
        }
    }

    private Connection con = null;
    
    public ConexionDB() {
        
        try {
            String url="jdbc:ostgresql://localhost5432/ejemplo";
            
            con = DriverManager.getConnection(url, "postgres", "postgres");
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Se conectó");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean execute(String sql){
        Statement st = null;
        try {
            st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{            
             if(st != null){
                 try {
                     st.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
        
        
    }

     public ResultSet select(String sql){
         Statement st = null;
         ResultSet reg = null;
         
         try {
             st  = con.createStatement();             
             reg = st.executeQuery(sql);
             return reg;             
         } 
         catch (SQLException ex) {
             Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         } 
         finally{
             if(st != null){
                 try {
                     st.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             if(reg != null){
                 try {
                     reg.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
     }
    
}
