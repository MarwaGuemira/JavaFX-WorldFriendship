/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.ProfitePub;
import com.wf.entity.Pub;
import com.wf.entity.ReactionPub;
import com.wf.entity.Utilisateur;
import com.wf.service.ProfitePubService;
import com.wf.service.PubService;
import com.wf.service.ReactionPubService;
import com.wf.service.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class AffPubController implements Initializable {
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label descLabel;

    

    @FXML
    private ImageView imageview;
    @FXML
    private JFXButton retour;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         retour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficherPub.fxml"));
                Scene scene = new Scene(page1,1000,1000);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
         
           int i = AfficherPubController.idp;
     Pub p = new Pub();
   PubService s = new PubService();
    p = s.displayById(i); 
   
    //idLabel.setText(Integer.toString(p.getIdpublicite()));
    nomLabel.setText(p.getNompublicite());
    descLabel.setText((p.getContenupublicte()));
 String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        Image img=new Image(pathimage);
                        imageview.setImage(img);
      
       
               
 }   
    
    
       ProfitePubService k = new ProfitePubService();  

//          ReactionPub like = new  ReactionPub(i,user.getId(), "like");
//              ReactionPub dislike = new  ReactionPub(i,user.getId(),  "dislike");
//   pdao1.
 private  List <ProfitePub>  pubs = k.displayAll();


   
    public boolean  recherche (ProfitePub pn) {
    
    return pubs.contains(pn);
    }
    
    ReactionPubService l = new ReactionPubService();
   private List<ReactionPub> lik = l.displayAll();


 public boolean  recherchelike (ReactionPub k) {
    
    return lik.contains(k);
    }
    public boolean  recherchedislike (ReactionPub dislike) {
    
    return lik.contains(dislike);
    }
   
    
    
    @FXML
    public void ProfiterButton(ActionEvent event) throws ClassNotFoundException,SQLException{
   
      int i = AfficherPubController.idp;
      Pub p = new Pub();  
   PubService s = new PubService();
    p = s.displayById(i); 
   
  int nbpoint = p.getPoint();
   System.out.println(nbpoint);
  int nb = p.getNbrprofit();
  
  
 
//          int use = user.getId();
//          System.out.println(use);
  Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
         System.out.println(user.getNom()); 
        Utilisateur user1 = new Utilisateur(); 
  UtilisateurService us = new UtilisateurService();
//
  user1 = us.displayById(user.getId());
   int nbtotal = user1.getPoint();
         System.out.println(nbtotal);
//         
   ProfitePub pn = new ProfitePub(i, user.getId());
  ProfitePubService paj= ProfitePubService.getInstance(); 
  
 
  if (recherche(pn) == true )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("déja participer");
        alert.show();
      
  }
  
  else 
  {if (nbtotal < nbpoint)
  {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Desolé pas de point");
        alert.show();
  }
  else {
  Pub p1 = new Pub(p.getIdpublicite(),nb+1 );
   PubService s1 = new PubService();
   s1.updateNbrProfit(p1);
  Utilisateur u1 = new Utilisateur(user.getId(),nbtotal-nbpoint);
   UtilisateurService s2 = new UtilisateurService();
   s2.updatePoint(u1);
        paj.insert(pn);
           
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez profité cette Publicité!");
        alert.show();
              
  }                         
  }     
     
    }
    
      @FXML
    public void likeButton(ActionEvent event) throws ClassNotFoundException,SQLException{
   
      int i = AfficherPubController.idp;
       Pub p = new Pub();
   PubService s = new PubService();
    p = s.displayById(i); 
  int nblik = p.getNbrlikes();
  int nbdislik = p.getNbrdislikes();
 String nom= p.getNompublicite();
    Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
          ReactionPub like1 = new ReactionPub(i,user.getId(), "like");
           ReactionPub dislike1 = new ReactionPub(i,user.getId(), "dislike");
          ReactionPubService likeser = ReactionPubService.getInstance();
  if (recherchelike(like1) == true )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("déja aimer");
        alert.show();
      
  }
  
  else if ( recherchedislike(dislike1) == true ) {
      likeser.update(like1);
      Pub p1 = new Pub(i,nom, nblik+1, nbdislik-1);
      s.updateNbDisLike(p1);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("kount disklike walit like");
        alert.show();
      
  }
  else {
 likeser.insert(like1);  
    Pub p1 = new Pub(i,nom, nblik+1, nbdislik);
      s.updateNbDisLike(p1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("like avec succés!");
        alert.show();
  }     
    }
     @FXML
    public void dislikeButton(ActionEvent event) throws ClassNotFoundException,SQLException{
      int i = AfficherPubController.idp;
       Pub p = new Pub();
   PubService s = new PubService();
    p = s.displayById(i); 
  int nblik = p.getNbrlikes();
  int nbdislik = p.getNbrdislikes();
String nom= p.getNompublicite();
    Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
          ReactionPub like1 = new ReactionPub( i,user.getId(), "like");
           ReactionPub dislike1 = new ReactionPub(i,user.getId(), "dislike");
          ReactionPubService likeser = ReactionPubService.getInstance();
  if (recherchedislike(dislike1) == true )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("déja ne aimer");
        alert.show();
      
  }
  
  else if ( recherchelike(like1) == true ) {
      likeser.update(dislike1);
      Pub p1 = new Pub(i,nom, nblik-1, nbdislik+1);
      s.updateNbDisLike(p1);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("kount like walit dislike");
        alert.show();
      
  }
  else {
 likeser.insert(dislike1);  
    Pub p1 = new Pub(i,nom, nblik, nbdislik+1);
      s.updateNbDisLike(p1);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("dislike avec succés!");
        alert.show();
              
                           
  }           
                           
  }  
    
}
