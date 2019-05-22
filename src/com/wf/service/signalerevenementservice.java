/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.participation_evenement;
import com.wf.entity.signalerevenement;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marwa
 */
public class signalerevenementservice implements IService<signalerevenement>{
    
      private static signalerevenementservice instance;

   
    private Statement st;
    private ResultSet rs;
    
    public signalerevenementservice() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static signalerevenementservice getInstance() {
         if(instance==null) 
            instance = new signalerevenementservice();
        return instance;
     }

    @Override
    public void insert(signalerevenement o) {
              
 String req="insert into signalevenement (user_id,even_id) values ('"+o.getUser_id().getId()+"','"+o.getEven_id().getIdevenement()+"')";

        try {
            st.executeUpdate(req);
       } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }  }

    @Override
    public void delete(signalerevenement o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<signalerevenement> displayAll() {
     
    String req="select * from signalevenement";
        List<signalerevenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                signalerevenement p = new signalerevenement();
                p.setUser_id(rs.getInt("user_id"));
            
                p.setEven_id(rs.getInt("even_id"));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public signalerevenement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(signalerevenement os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public List<signalerevenement> displayAll1(int id) {
          String req="select * from signalevenement where even_id ="+id+"";
        List<signalerevenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                signalerevenement p = new signalerevenement();
                p.setUser_id(rs.getInt("user_id"));
            
                p.setEven_id(rs.getInt("even_id"));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      }  
}
