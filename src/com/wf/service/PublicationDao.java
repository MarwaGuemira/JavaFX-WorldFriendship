/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.wf.service;

import  com.wf.entity.Publication;
import   com.wf.util.ConnexionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import  com.wf.entity.Utilisateur;

/**
 *
 * @author nermi
 */
public class PublicationDao {
     Connection cnx;

    public PublicationDao() {
        cnx= ConnexionSingleton.getInstance().getCnx();
    }
    
    
    public void ajouterPublication(Publication p){

        try {
         
            java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
             String req = "INSERT INTO `publication`(`user_id`, `categorie_id`, `contenue`, `nomimage`, `nbrlike`, `titre`, `datepublication`, `visibilite`, `nbrdislike`) VALUES(?,?,?,?,?,?,?,?,?) ";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
            pstm.setInt(1, p.getUser_id());
            pstm.setInt(2,p.getCategorie_id());
            pstm.setString(3, p.getContenue());
            pstm.setString(4, p.getNomimage());
            pstm.setInt(5, 0);
            pstm.setString(6, p.getTitre());
            pstm.setDate(7, date);
            pstm.setInt(8, p.getVisibilite());
            pstm.setInt(9, 0);
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
     public List<Publication> DisplayAllPub() {
        try {
            String query = "SELECT * FROM publication";

           PreparedStatement pstm = cnx.prepareStatement(query);

            ResultSet result = pstm.executeQuery(query);

            List<Publication> list = new ArrayList<>();

            while (result.next()) {
                
                Publication produit = new Publication();
                produit.setTitre(result.getString("titre"));
                produit.setContenue(result.getString("contenue"));
               // produit.setDatepublication(result.getDate("datepublication"));
                produit.setNomimage(result.getString("nomimage"));
                produit.setUser_id(result.getInt("user_id"));
               

                list.add(produit);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Publication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public Utilisateur getUserPub(int id) throws SQLException{
        String req = "SELECT * FROM fos_user,publication WHERE fos_user.id=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1,id);
        ResultSet result = pstm.executeQuery();
        if (!result.next()) return null;
        String nom = result.getString("nom");
        String prenom = result.getString("prenom");
        String image = result.getString("monimage");
        
       // String img = result.getString("image");
        Utilisateur u = new Utilisateur();
     
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setImg(image);
        return u;

    }
}
