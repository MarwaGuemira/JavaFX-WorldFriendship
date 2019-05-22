/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
//import static pidev.v1.Controllers.AffichageCatFXMLController.r;

import com.wf.service.ConcoursDAO;

import com.wf.entity.Concours;


import com.wf.service.CategorieDao;
import com.wf.entity.Categorie;

/**
 * FXML Controller class
 *
 * @author sfaxidorra
 */
public class AjoutConcoursController implements Initializable {

    @FXML
    private JFXTextField nomconcours;
    @FXML
    private JFXTextArea descriptionconcours;
    @FXML
    private JFXTextField prixgagnant;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    @FXML
    private ComboBox<Categorie> idcategorie;
    private Button ajoutConcours;
    @FXML
    private Button ajouterConcours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCategorie();
        // TODO
    }    
    
    public void initCategorie(){
        CategorieDao cd = new CategorieDao();
        ObservableList<Categorie> options = 
                FXCollections.observableArrayList(
                        cd.ListCategories()
                );
        idcategorie.setItems(options);
        System.out.println(options);
    }
    
    @FXML
    private void ajouterConcoursAction(ActionEvent event) throws IOException {
           ConcoursDAO cd= new ConcoursDAO();
        Concours c = new Concours( idcategorie.getValue().getIdcategorie(), nomconcours.getText(), 
                Date.valueOf(datedebut.getValue()),Date.valueOf(datefin.getValue()), 
                descriptionconcours.getText(),prixgagnant.getText() );
        if(c.getDatedebut().before(Date.valueOf(LocalDate.now()) ) ) 
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setContentText("Date de début dépassée");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ajouterConcours.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AjoutConcours.fxml")));
                
            }
            
        }else {
            if(c.getDatefin().before(c.getDatedebut()) ) 
            {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Erreur");
                 alert.setContentText("La date de fin ne peut pas etre apres la date de début");
                 Optional<ButtonType> result = alert.showAndWait();
                 if (result.get() == ButtonType.OK) {
                   ajouterConcours.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AjoutConcours.fxml")));
            }}
            
                 else{
        
                cd.ajouterConcours(c);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Succéss");
                alert1.setContentText("Ajouté avec succéss !");
                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result1.get() == ButtonType.OK) {
                    ajouterConcours.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageConFXML.fxml")));
                                                    } 
                    }
             
        }
    }

}
