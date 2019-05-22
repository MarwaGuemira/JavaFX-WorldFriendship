/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import com.wf.controller.AffichageCatFXMLController;
import com.wf.service.CategorieDao;
import com.wf.entity.Categorie;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sfaxidorra
 */
public class ModifierCatFXMLController implements Initializable {

    @FXML
    private AnchorPane modifCat;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField description;
     private static int id;
    private static Categorie off;
    
    public static Categorie getRec()
    {
        return off;
    }

    public static void setId(int id) {
        ModifierCatFXMLController.id = id;
    }
    public static void setRec(Categorie off)
            {
                ModifierCatFXMLController.off=off;
            }
    @FXML
    private Button valider;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       off = AffichageCatFXMLController.r;
       nom.setText(off.getNomcategorie());
       description.setText(off.getDescriptioncategorie());
       

    }    

   

    @FXML
    private void modifCatAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmation");
        alert.setContentText("Vouler vous vraiment modifier la catgégorie ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            CategorieDao recl = new CategorieDao();

           Categorie of = new Categorie();
            of.setDescriptioncategorie(description.getText());
            of.setNomcategorie(nom.getText());
           
            recl.modifierCat(of,id);
           valider.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageCatFXML.fxml")));
             
        
    }
    }
    
}
