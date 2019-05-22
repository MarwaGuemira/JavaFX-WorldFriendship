/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import static com.wf.controller.AfficherPubController.idp;
import com.wf.entity.Pub;
import com.wf.entity.offre;
import com.wf.service.OffreService;
import com.wf.service.PubService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class AffichageOffreController implements Initializable {

    private Label label1;
    private Label label2;
    
    
    public static int idp;
    @FXML
    private CheckBox bronze;
    @FXML
    private CheckBox silver;
    @FXML
    private CheckBox gold;
    @FXML
    private JFXButton cont;
    @FXML
    private JFXButton retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       bronze.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              silver.setSelected(false);
               gold.setSelected(false);
               
               idp=1;
           }
       });
              silver.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              bronze.setSelected(false);
               gold.setSelected(false);
               idp=3;
           }
       });
                    gold.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              silver.setSelected(false);
               bronze.setSelected(false);
               idp=4;
           }
       });
        // TODO
      
    cont.setOnAction(event -> {
        
    if(!silver.isSelected() &&!gold.isSelected() && !bronze.isSelected())
    {
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("il faut choisir packe!");
        alert.show();
    }
    else {
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AjouterPublicites.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   });
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
        
    }
  
      
    
    
}
