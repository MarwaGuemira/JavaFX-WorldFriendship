/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.type_evenement;
import com.wf.entity.type_reclamation;
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
 * @author ihebm
 */
public class TypeReclamationService implements IService<type_reclamation> {
 
    
    
    private static TypeReclamationService instance;
       
    private Statement st;
    private ResultSet rs;
    
    public TypeReclamationService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(TypeReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static TypeReclamationService getInstance() {
         if(instance==null) 
            instance = new TypeReclamationService();
        return instance;
     }
    @Override
    public void insert(type_reclamation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(type_reclamation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<type_reclamation> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public type_reclamation displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(type_reclamation os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  public  ArrayList<type_reclamation> getcategorieparent() throws SQLException {
       ArrayList<type_reclamation> retour = new ArrayList<>();
//String names = retour.stream().reduce(new type_evenement()).get
        String req = "SELECT * FROM type_reclamation ";
        ResultSet resultat = st.executeQuery(req);
        while(resultat.next()){
             int idtype =resultat.getInt(1);
             String nomtype= resultat.getString(2);
           retour.add(new type_reclamation( idtype ,nomtype));
            
        }
            
        return retour;
    }
                  
                  public  ArrayList<type_reclamation> getnomcategorie() throws SQLException {
       ArrayList<type_reclamation> retour = new ArrayList<>();
       
        String req = "SELECT nomreclamation FROM type_evenement";
        ResultSet resultat = st.executeQuery(req);
        while(resultat.next()){
            
             String nomtype= resultat.getString(1);
           retour.add(new type_reclamation(nomtype) );
            
        }
            
        return retour;
    }
}
