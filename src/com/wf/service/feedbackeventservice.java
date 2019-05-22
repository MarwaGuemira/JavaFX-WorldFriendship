/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.entity.Feedback;
import com.wf.entity.feedbackevent;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marwa
 */
public class feedbackeventservice implements IService<feedbackevent>{
  
       private static feedbackeventservice instance;

   
    private Statement st;
    private ResultSet rs;
    
    public feedbackeventservice() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static feedbackeventservice getInstance() {
         if(instance==null) 
            instance = new feedbackeventservice();
        return instance;
     }

    @Override
    public void insert(feedbackevent o) {
      
            
 String req="insert into feedbackevent (nomfeed,idfeed,user_id,even_id) values ('"+o.getNomfeed()+"','"+o.getIdfeed()+"','"+o.getUser_id().getId()+"','"+o.getEven_id().getIdevenement()+"')";

        try {
            st.executeUpdate(req);
       } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }    
    
    }

    @Override
    public void delete(feedbackevent o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<feedbackevent> displayAll() {
           String req="select * from feedbackevent ";
       // List<feedbackevent> list=new ArrayList<>();
         ObservableList<feedbackevent> list=FXCollections.observableArrayList();  
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                  feedbackevent p=new feedbackevent();
                p.setId(rs.getInt("id"));
                 p.setIdfeed(rs.getInt("idfeed"));
                p.setEven_id(rs.getInt("even_id"));
            
                 p.setNomfeed(rs.getString("nomfeed"));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      
    }

    @Override
    public feedbackevent displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(feedbackevent os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
        public List<feedbackevent> disp(int id) {
       String req="select * from feedbackevent WHERE even_id =  " +id+ "";
      //  List<feedbackevent> list=new ArrayList<>();
          ObservableList<feedbackevent> list=FXCollections.observableArrayList();  
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                  feedbackevent p=new feedbackevent();
                p.setId(rs.getInt("id"));
                 p.setIdfeed(rs.getInt("idfeed"));
                p.setEven_id(rs.getInt("even_id"));
            
                 p.setNomfeed(rs.getString("nomfeed"));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 
    
    
    
}
