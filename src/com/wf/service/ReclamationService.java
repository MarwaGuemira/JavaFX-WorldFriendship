/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.entity.Reclamation;
import com.wf.util.ConnectionDB;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class ReclamationService implements IService<Reclamation>{
   private static ReclamationService instance;

   
    private Statement st;
    private ResultSet rs;
    

    
    public ReclamationService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static ReclamationService getInstance() {
         if(instance==null) 
            instance = new ReclamationService();
        return instance;
     }

    @Override
    public void insert(Reclamation o) {
  
Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            java.sql.Date datereclam = new java.sql.Date(currentDate.getTime());
   String req="insert into reclamation (user_id,descriptionreclam ,titrereclam, datereclam,etatreclam,type_id) values ('"+o.getUser_id().getId()+"','"+o.getDescriptionreclam()+"','"+o.getTitrereclam()+"','"+datereclam+"','"+"non"+"','"+o.getType_id().getId()+"')";
        try {
                        
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void delete(Reclamation o) {
               String req="DELETE from reclamation where idreclam="+o.getIdreclam();

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public List<Reclamation> displayAll() {
      String req="select * from Reclamation";
        ObservableList<Reclamation> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Reclamation p=new Reclamation();
                p.setIdreclam(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
                p.setDescriptionreclam(rs.getString("descriptionreclam"));
                 p.setTitrereclam(rs.getString("titrereclam"));
                 p.setDatereclam(LocalDate.parse(rs.getString("datereclam"), DateTimeFormatter.ISO_DATE) );
                   p.setEtatreclam(rs.getString("etatreclam"));

                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    }
      public List<Reclamation> displayAllList() {
        String req="select * from reclamation";
        List<Reclamation> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Reclamation p=new Reclamation();
                 
                p.setIdreclam(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
                p.setDescriptionreclam(rs.getString("descriptionreclam"));
                 p.setTitrereclam(rs.getString("titrereclam"));
                   p.setEtatreclam(rs.getString("etatreclam"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Reclamation displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Reclamation os) {
        String qry = "UPDATE reclamation SET etatreclam = '"+os.getEtatreclam()+"', descriptionreclamation = '"+os.getDescriptionreclam()+"' WHERE idreclam= "+os.getIdreclam();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;      }
        public boolean TraiterReclam(Reclamation os) {
        String qry = "UPDATE reclamation SET  etatreclam =  '"+"traiter"+"'  WHERE idreclam= "+os.getIdreclam();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
}

