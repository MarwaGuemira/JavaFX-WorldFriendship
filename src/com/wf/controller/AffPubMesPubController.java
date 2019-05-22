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
public class AffPubMesPubController implements Initializable {

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
        
         
           int i = MesPubs1Controller.id2;
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
   
    
   
}
