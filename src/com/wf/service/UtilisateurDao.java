/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.wf.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import  com.wf.entity.Utilisateur;
import com.wf.util.ConnexionSingleton;


/**
 *
 * @author nermi
 */
public class UtilisateurDao {
     Connection cnx;
    public UtilisateurDao() throws SQLException{
        cnx = ConnexionSingleton.getInstance().getCnx();
    } 
     public void ajouterUser(Utilisateur u){
        try {
            u.setDatenaissance(u.getDatenaissance());
            java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
             String req = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `nom`, `prenom`, `monimage`, `pays`, `numero_tel`, `datede_naissance`, `point`, `region`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
             pstm.setString(1, u.getUsername());
             pstm.setString(2, u.getUsername());
             pstm.setString(3,u.getEmail());
              pstm.setString(4,u.getEmail());
             pstm.setBoolean(5, true);
             pstm.setString(6, u.getPassword());
             pstm.setDate(7, date);
             pstm.setString(8, null);
             pstm.setString(9,null);
             pstm.setString(10, "user");
             pstm.setString(11, u.getNom());
             pstm.setString(12, u.getPrenom());
             pstm.setString(13,u.getImg());
             pstm.setString(14,u.getPays());
             pstm.setString(15,u.getTelephone());
             pstm.setDate(16,u.getDatenaissance());
             pstm.setInt(17,u.getBonus());
             pstm.setString(18,u.getRegion());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
     public Utilisateur login(String usern, String passw)
     {
          try {
            String req = "SELECT * FROM `fos_user` WHERE username=? and password=? ";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setString(1, usern);
            pstm.setString(2, passw);
            ResultSet result=pstm.executeQuery();
            if (!result.next())
            return null;
            
            System.out.println("test");
            int id = result.getInt("id");
            String username = result.getString("username");
            String email = result.getString("email");
            boolean enabled = result.getBoolean("enabled");
            String password = result.getString("password");
            Date lastLogin = result.getDate("last_login");
            String role = result.getString("roles");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String pays = result.getString("pays");
              String region = result.getString("region");
            String confirmationToken =  result.getString("confirmation_token");
            //AdresseService ads = new AdresseService();
            //Adresse adresse = ads.getAdresse(result.getInt("adresse"));
            String telephone = result.getString("numero_tel");
            String img = result.getString("monimage");
            System.out.println("test");
           
            //return new Utilisateur(id, username, email, enabled, password, lastLogin,confirmationToken, role, nom, prenom, telephone, img);
  return Utilisateur.getInstance(id, username,  email,  enabled, password, lastLogin,confirmationToken, role,  nom,  prenom,telephone, pays ,region);

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
     }

    public Utilisateur getUser(int id) throws SQLException{
        String req = "Select * from fos_user where id = ?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1,id);
        ResultSet result = pstm.executeQuery();
        result.next();
        String nom = result.getString("nom");
        String prenom = result.getString("prenom");
        String telephone = result.getString("numero_tel");
        String Pays = result.getString("pays");
        String region = result.getString("region");
        String image = result.getString("monimage");
        
       // String img = result.getString("image");
        Utilisateur u = new Utilisateur();
        u.setTelephone(telephone);
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setPays(Pays);
        u.setRegion(region);
        u.setImg(image);
        return u;

    }
    
    public void updateProfil(Utilisateur u){
        try {
            
             String req = "UPDATE `fos_user` SET `nom`=?,`prenom`=?,`pays`=?,`region`=?,`numero_tel`=? WHERE `id`="+u.getId();
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, u.getNom());
             pstm.setString(2, u.getPrenom());
             pstm.setString(3, u.getPays());
             pstm.setString(4, u.getRegion());
             pstm.setString(5, u.getTelephone()); 

             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
   
    
}
