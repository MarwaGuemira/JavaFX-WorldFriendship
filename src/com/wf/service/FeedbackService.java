/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Feedback;
import com.wf.entity.ReactionPub;
import com.wf.entity.Reclamation;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public class FeedbackService implements IService<Feedback>{

       private static FeedbackService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public FeedbackService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static FeedbackService getInstance() {
         if(instance==null) 
            instance = new FeedbackService();
        return instance;
     }
    
    
    @Override
    public void insert(Feedback o) {
        Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            java.sql.Date datefeed = new java.sql.Date(currentDate.getTime());
        String req="insert into feedback (user_id,note,descriptionfeedback,datefeedback) values ('"+o.getUser_id().getId()+"','"+o.getNote()+"','"+o.getDescfeedback()+"','"+datefeed+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Feedback o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Feedback> displayAll() {
      String req="select * from feedback";
        ObservableList<Feedback> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Feedback p=new Feedback();
                p.setIdfeedback(rs.getInt("idfeedback"));
              //  p.setUser_id(rs.getInt("user_id"));
                p.setNote(rs.getInt("note"));
                 p.setDescfeedback(rs.getString("descriptionfeedback"));
//                 p.setDatefeedback(LocalDate.parse(rs.getString("datefeedback"), DateTimeFormatter.ISO_DATE) );
                   p.setDatefeedback(LocalDate.parse(rs.getString("datefeedback"), DateTimeFormatter.ISO_DATE) );  
  
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    }
      public List<Feedback> displayAllList() {
        String req="select * from feedback ";
        List<Feedback> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                  Feedback p=new Feedback();
                p.setIdfeedback(rs.getInt("idfeedback"));
                p.setUser_id(rs.getInt("user_id"));
                p.setNote(rs.getInt("note"));
                 p.setDescfeedback(rs.getString("descriptionfeedback"));
                 p.setDatefeedback(LocalDate.parse(rs.getString("datefeedback"), DateTimeFormatter.ISO_DATE) );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Feedback displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Feedback os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
