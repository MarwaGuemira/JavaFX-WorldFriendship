/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.entity.offre;
import com.wf.entity.type_evenement;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class OffreService  implements IService<offre>{
      private static OffreService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public OffreService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static OffreService getInstance() {
         if(instance==null) 
            instance = new OffreService();
        return instance;
     }

    @Override
    public void insert(offre o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(offre o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<offre> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public offre displayById(int id) {

      String req = "SELECT * FROM offre where  idoffre =" + id ;
     offre o =new offre();
      try {
        rs = st.executeQuery(req);
        while(rs.next()){
             int idoffre =rs.getInt("idoffre");
             String nomoffre= rs.getString("nomoffre");
         
            
        }
    }
      catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      return o;
    }
    @Override
    public boolean update(offre os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
   public  List<offre> getcategorieparent() throws SQLException {
     ArrayList<offre> abc = new ArrayList<>();
//String names = retour.stream().reduce(new type_evenement()).get
        String req = "SELECT * FROM `offre` ";
        ResultSet resultat = st.executeQuery(req);
        while(resultat.next()){
             int idoffre =resultat.getInt("idoffre");
             String nomoffre= resultat.getString("nomoffre");
           abc.add(new offre( idoffre ,nomoffre));
            
        }
            
        return abc;
    }
                  
                  public  ArrayList<offre> getnomcategorie() throws SQLException {
       ArrayList<offre> retour = new ArrayList<>();
       
        String req = "SELECT  nomoffre FROM offre";
        ResultSet resultat = st.executeQuery(req);
        while(resultat.next()){
            
             String nomoffre= resultat.getString(1);
           retour.add(new offre(nomoffre) );
            
        }
            
        return retour;
    }  
    
}
