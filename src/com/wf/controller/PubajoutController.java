/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class PubajoutController implements Initializable {

    @FXML
    private JFXButton mespubs;
    @FXML
    private JFXButton ajouterpubs;
    @FXML
    private JFXButton retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        mespubs.setOnAction(event -> {
        
   
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/MesPubs1.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   });  
        
        
          ajouterpubs.setOnAction(event -> {
        
   
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageOffre.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   });  
        
          retour.setOnAction(event -> {
        
   
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Accueil.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   });
            }
        
        // TODO
    }    
    
