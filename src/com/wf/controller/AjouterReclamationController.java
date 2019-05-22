/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Evenement;
import com.wf.entity.Reclamation;
import com.wf.entity.Utilisateur;
import com.wf.entity.type_evenement;
import com.wf.entity.type_reclamation;
import com.wf.service.EvenementService;
import com.wf.service.ReclamationService;
import com.wf.service.TypeReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author ihebm
 */
public class AjouterReclamationController implements Initializable{
    @FXML
 private JFXTextField txtdesc;
        @FXML
 private JFXTextField txttitre;
      @FXML
    private JFXComboBox<type_reclamation> txttyperec;
//     @FXML
//    private JFXDatePicker txtdatdeb;
    @FXML
    private JFXButton onbt3;
     
@Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
       TypeReclamationService k =  new TypeReclamationService ();
     ObservableList<type_reclamation>  rec3=FXCollections.observableArrayList(k.getcategorieparent());
     txttyperec.setItems(rec3);
     //  rec3 = (ObservableList<type_reclamation>) k.getcategorieparent();
         System.out.println(rec3);
         txttyperec.setOnAction((event) -> {
             
             int id = txttyperec.getSelectionModel().getSelectedItem().getId();
             
         });
         
       }
        catch(SQLException ex) {
       Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
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
        });}
    
    
    
     @FXML
    
     private void insertRec (ActionEvent event) throws ClassNotFoundException,SQLException{
     
         
   //LocalDate date1 =txtdatdeb.getValue() ;
  
        // Utilisateur user = LoginFXMLController.CurrentUser;
         Reclamation rec1 = new Reclamation();
         // ArrayList a = new  ArrayList();
         // a.add("lool");
        //  a.add("kik");
//        ObservableList<String> a = FXCollections.observableArrayList();
//        
//        a.add("lool");
//         a.add("kik");
       //  txttypeeve.setItems(options);
//    txttitre.setItems(a);
//   //"Coupure","Publicite indésirable","evenement pas claire"
//  // );
//         System.out.println(txttitre);
//         rec1.setDatereclam(new Date());

  //  k.displayAll()
//type_reclamations k = type_reclamation.;
Utilisateur user = LoginFXMLController.CurrentUser;
   type_reclamation c =(type_reclamation) txttyperec.getValue();
            Reclamation rec = new Reclamation(user.getId(),txtdesc.getText(),c.getId());
           ReclamationService pdrec = ReclamationService.getInstance();
            pdrec.insert(rec);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
                    String title = "Congratulations sir";
        String message = "You've successfully created your first Tray Notification";
        NotificationType notification = NotificationType.SUCCESS;
  
        TrayNotification tray = new TrayNotification();
         //  Image img = new Image("/image/bg.png");
        tray.setTitle(title);
        tray.setMessage(message);

        tray.setNotificationType(notification);
        //tray.showAndWait();
         tray.showAndDismiss(Duration.seconds(10));
        alert.show();
                txtdesc.setText("");
                // txttitre.setText("");  

     }
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public String toString() {
        return   "txttitre=" + txttitre + '}';
    }
    
    
}
