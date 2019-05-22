/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Evenement;
import com.wf.entity.Pub;
import com.wf.entity.Reclamation;
import com.wf.entity.Utilisateur;
import com.wf.service.EvenementService;
import com.wf.service.ReclamationService;
import com.wf.service.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.function.Predicate;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class AffichageReclamationController implements Initializable {
    @FXML
    private TableView<Reclamation> reclamview;
    @FXML
    private TableColumn<Reclamation, String> descreclam;
    @FXML
    private TableColumn<Reclamation, String> titrereclam;
    @FXML
    private TableColumn<Reclamation, String> datereclam;
        @FXML
    private TableColumn<Reclamation, String> etatreclam;
        private ListData3 listdata = new ListData3();
        @FXML
        private TextField search2;
   FilteredList<Reclamation> filter = new FilteredList<>(listdata.getUsers(), e -> true); 
        private  int id ;
private String recla ; 

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
        
                         reclamview.setItems(listdata.getUsers());
              
                   descreclam.setCellValueFactory(new PropertyValueFactory<>("descriptionreclam"));
                titrereclam.setCellValueFactory(new PropertyValueFactory<>("titrereclam"));
    datereclam.setCellValueFactory(new PropertyValueFactory<>("datereclam"));
      etatreclam.setCellValueFactory(new PropertyValueFactory<>("etatreclam"));
    setCellValue();
    } 
    
        private void setCellValue() {
        
        
          reclamview.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
               Reclamation rl = listdata.getUsers().get(reclamview.getSelectionModel().getSelectedIndex());
//                setId(rl.getIdreclam());
//                setRecla(rl.getTitrereclam());
          // idreclam.setText(Integer.toString(rl.getIdreclam()));
//                descreclam1.setText(rl.getDescriptionreclam());
//                titrereclam1.setText((rl.getTitrereclam()));
//                 etatreclam1.setText((rl.getEtatreclam()));
////            modifier.setDisable(false);
            }


                // supprimer.setDisable(false);
                // anchor.setDisable(false);

          } ) ;            
    }
              @FXML
           void TraiterButton(ActionEvent event) throws ClassNotFoundException,SQLException{
                ObservableList<Reclamation> selectedRows, allusers;
        allusers =reclamview.getItems();
        selectedRows = reclamview.getSelectionModel().getSelectedItems();
                  UtilisateurService ut = new UtilisateurService();
                  Utilisateur u = new Utilisateur();
                 
        for(Reclamation rec: selectedRows)
        {  u = ut.displayBymail(rec.getUser_id().getId());
         
            
            System.out.println(u.getEmail());
              Reclamation p1=new Reclamation (rec.getIdreclam(),rec.getEtatreclam());
               ReclamationService r2 =  ReclamationService.getInstance();
               
               r2.TraiterReclam(p1);
        
              final String username = "worldfrienship1@gmail.com";
        final String password = "world1996";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ihebmensi9@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(u.getEmail())
            );
            message.setSubject("ya 7obby");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Votre reclamation est bien traité");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        } 
        }
           
           
           @FXML
    private void search2(KeyEvent event1) {
       
       search2.textProperty().addListener((observable,oldValue,newValue) -> {
           filter.setPredicate((Predicate<? super Reclamation>) (Reclamation Rec)->{
           
             if(newValue.isEmpty() || newValue==null){
                 return true;
             }
             else if((Rec.getDescriptionreclam().contains(newValue)) || (Rec.getDescriptionreclam().toLowerCase().contains(newValue))){
                 return true;
             }
           return false;
           });
           
       });
       SortedList sort=new SortedList(filter);
       sort.comparatorProperty().bind(reclamview.comparatorProperty());
       reclamview.setItems(sort);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecla() {
        return recla;
    }

    public void setRecla(String recla) {
        this.recla = recla;
    }
           
           
           
}
