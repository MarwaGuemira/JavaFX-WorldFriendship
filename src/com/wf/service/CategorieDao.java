/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.wf.entity.Categorie;
import com.wf.util.ConnexionSingleton;

/**
 *
 * @author sfaxidorra
 */
public class CategorieDao {
  Connection cnx;

    public CategorieDao() {
        cnx= ConnexionSingleton.getInstance().getCnx();
    }
    
     public List<Categorie> ListCategories()
     {
         List<Categorie> list = new ArrayList<>();
          try {
            String req = "SELECT * FROM `categorie`";
            PreparedStatement pstm = cnx.prepareStatement(req);
            
            ResultSet result=pstm.executeQuery();
            while(result.next()){
                Categorie c = new Categorie(result.getInt("idcategorie"), result.getString("nomcategorie"), 
                        result.getInt("nbrabonnees"), result.getString("imgcatgorie"), result.getString("descriptioncategorie"));
                list.add(c);
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(CategorieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return list;
     }
     
     public void ajouterCat(Categorie e){
        try {
             
             String req = "INSERT INTO `categorie`(`nomcategorie`, `nbrabonnees`, `imgcatgorie`, `descriptioncategorie`) VALUES (?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
             pstm.setString(1, e.getNomcategorie());
             pstm.setInt(2, 0);
             pstm.setString(3, e.getImgcatgorie());
             pstm.setString(4, e.getDescriptioncategorie());

             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(CategorieDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     public void supprimerCat(int id){
         try{
             String req = "DELETE FROM `categorie` WHERE `categorie`.`idcategorie` = " + id;
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.executeUpdate();
         }
         catch (SQLException ex) {
             Logger.getLogger(CategorieDao.class.getName()).log(Level.SEVERE, null, ex);
         }
     }   
     
     public void modifierCat(Categorie t,int id){
            String request =  "UPDATE `categorie` SET `descriptioncategorie`='"+ t.getDescriptioncategorie()+ "',`nomcategorie`='"+ t.getNomcategorie()+ "' WHERE `categorie`.`idcategorie` ="+ id;
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(CategorieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

}
