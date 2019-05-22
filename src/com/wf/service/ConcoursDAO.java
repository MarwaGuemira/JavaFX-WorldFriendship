/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.wf.entity.Categorie;
import com.wf.entity.Concours;
import com.wf.entity.Concours;
import com.wf.util.ConnexionSingleton;

/**
 *
 * @author sfaxidorra
 */
public class ConcoursDAO {
    Connection cnx;

    public ConcoursDAO(){
        cnx= ConnexionSingleton.getInstance().getCnx();
    }
    
     public List<Concours> ListConcours()
     {
         List<Concours> list = new ArrayList<>();
          try {
            String req = "SELECT * FROM `concours`";
            PreparedStatement pstm = cnx.prepareStatement(req);
            
            ResultSet result=pstm.executeQuery();
            while(result.next()){
                Concours c = new Concours(result.getInt("idconcours"),result.getInt("categorie_id"), 
                        result.getString("nomconcours"),result.getDate("datedebut"), 
                        result.getDate("datefin"), result.getString("descriptionconcours"), 
                        result.getString("prixgagnant"));
                list.add(c);
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(ConcoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return list;
     }
     public void ajouterConcours(Concours e){
        try {
             
             String req = "INSERT INTO `concours`(`categorie_id`, `nomconcours`, `datedebut`, `datefin`, `descriptionconcours`, `prixgagnant` ) VALUES (?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, e.getIdcategorie());
             pstm.setString(2, e.getNomconcours());
             pstm.setDate(3, e.getDatedebut());
             pstm.setDate(4, e.getDatefin());
             pstm.setString(5, e.getDescriptionconcours());
             pstm.setString(6, "");

             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ConcoursDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void supprimerConcours(int id){
         try{
             String req = "DELETE FROM `concours` WHERE `concours`.`idconcours` = " + id;
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.executeUpdate();
         }
         catch (SQLException ex) {
             Logger.getLogger(ConcoursDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     
     public void modifierConcours(Concours t,int id){
            String request =  "UPDATE `concours` SET `descriptionconcours`='"+ t.getDatefin()+ "',`datefin`='"+ t.getDatefin()+ "' WHERE `concours`.`idconsours` ="+ id;
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(ConcoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ArrayList<Concours> rechercheCon(String nom) throws SQLException {
 
       ArrayList<Concours> list = new ArrayList<>();
       //Statement stm = cnx.createStatement();
        String req = " SELECT * FROM `concours` WHERE concours.nomconcours ='"+nom+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
        ResultSet result=pstm.executeQuery(req);
        while(result.next()){
                Concours c = new Concours(result.getInt("idconcours"),result.getInt("categorie_id"), 
                        result.getString("nomconcours"),result.getDate("datedebut"), 
                        result.getDate("datefin"), result.getString("descriptionconcours"), 
                        result.getString("prixgagnant"));
                list.add(c);
            }
            
        return list;
    }
     
     public ArrayList<Concours> enCours() throws SQLException {
 
       ArrayList<Concours> list = new ArrayList<>();
       //Statement stm = cnx.createStatement();
        String req = " SELECT * FROM `concours` WHERE concours.datedebut < Now()AND concours.datefin > Now() ";
        PreparedStatement pstm = cnx.prepareStatement(req);
        ResultSet result=pstm.executeQuery(req);
        while(result.next()){
                Concours c = new Concours(result.getInt("idconcours"),result.getInt("categorie_id"), 
                        result.getString("nomconcours"),result.getDate("datedebut"), 
                        result.getDate("datefin"), result.getString("descriptionconcours"), 
                        result.getString("prixgagnant"));
                list.add(c);
            }
            
        return list;
    }

    
}
