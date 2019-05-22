/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Evenement;
import com.wf.entity.Feedback;
import com.wf.entity.Utilisateur;
import com.wf.entity.type_evenement;
import com.wf.service.EvenementService;
import com.wf.service.FeedbackService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class AjouterFeedbackController implements Initializable {

    @FXML
    private Label msg;
    @FXML
    private Rating rating;
  @FXML
 private JFXTextField desc;

 private int note;
    @FXML
    private JFXButton onbt3;
    /**
     * Initializes the controller class.
     */
 
     
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
          onbt3.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Feedbacketreclam.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
           rating.setUpdateOnHover(true);
           rating.setPartialRating(true);
                       rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old, Number newT) {
              msg.setText("Rating"+newT);
    
         System.out.println(newT);
               
                
         note= newT.intValue() ;
                System.out.println(note);
            }
    });    
    
}
    
     @FXML
  private void insertFeedback (ActionEvent event) throws ClassNotFoundException,SQLException{
         
 
         Utilisateur user = LoginFXMLController.CurrentUser;

              Feedback f = new Feedback(user.getId(),note, desc.getText());
            FeedbackService pdao = FeedbackService.getInstance();
            pdao.insert(f);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
                desc.setText("");

                              
      
    }
 
}
