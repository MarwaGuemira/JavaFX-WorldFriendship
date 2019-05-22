/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Utilisateur;
import com.wf.service.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author nermi
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton Seconnecter;
    @FXML
    private JFXButton MotdePasse;
    @FXML
    private Label Close;
    @FXML
    private JFXButton CreerCompte;
    public static Utilisateur CurrentUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAction(ActionEvent event) throws IOException, SQLException {
    
        UtilisateurService ud= new UtilisateurService();
         Utilisateur u= ud.login(username.getText(), password.getText());
           CurrentUser = u;
        if (u==null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("username ou mot de passe incorrect");
            alert.showAndWait();
        }
        else if(u.getRole().equals("admin") ){
          
               
        Seconnecter.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/Adminevenement.fxml")));
        
        }
        
         else {
          
                  Seconnecter.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/Accueil.fxml")));
     
        
        }
    }

    @FXML
    private void CreerCompteAction(ActionEvent event) throws IOException {
         Seconnecter.getScene().setRoot(FXMLLoader.load(getClass().getResource("/pidev/v1/Views/InscriptionFXML.fxml")));
    }
    
}
