/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.entity.participation_evenement;
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
public class participation_evenementService implements IService<participation_evenement>{

   private static participation_evenementService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public participation_evenementService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static participation_evenementService getInstance() {
         if(instance==null) 
            instance = new participation_evenementService();
        return instance;
     }
    @Override
    public void insert(participation_evenement o) {
        String req="insert into participation_evenement(user_id, even_id ) values ('"+o.getUser_id().getId()+"','"+o.getEven_id().getIdevenement()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }     }

    @Override
    public void delete(participation_evenement o) {
      String req="DELETE from  participation_evenement where  even_id ="+o.getEven_id().getIdevenement()+" AND user_id ="+o.getUser_id().getId()+"";

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    }

    @Override
    public List<participation_evenement> displayAll() {
          String req="select * from participation_evenement";
        List<participation_evenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                participation_evenement p = new participation_evenement();
                p.setUser_id(rs.getInt("user_id"));
            
                p.setEven_id(rs.getInt("even_id"));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      }
public List<participation_evenement> displayAll1(int id) {
          String req="select * from participation_evenement where user_id ="+id+"";
        List<participation_evenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                participation_evenement p = new participation_evenement();
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
    public participation_evenement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(participation_evenement os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       public participation_evenement chercher(int id , int id1) {
         
      
        String req="select * from  participation_evenement where user_id =  " +id+ " , even_id = "+id1+"";
           participation_evenement p= new participation_evenement();  
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
                p.setEven_id(rs.getInt("even_id"));
                p.setUser_id(rs.getInt("user_id"));
            
        
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }
        public List<participation_evenement> cherchereve( int id1) {
         
      
        String req="select * from  participation_evenement where  even_id = "+id1+"";
           List<participation_evenement> list=new ArrayList<>();
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
                
                participation_evenement p =new participation_evenement();
                p.setEven_id(rs.getInt("even_id"));
                p.setUser_id(rs.getInt("user_id"));
            
        
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
    
}
