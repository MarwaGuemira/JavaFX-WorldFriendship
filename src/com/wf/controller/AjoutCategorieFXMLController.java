/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;


import com.wf.util.UploadFile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import com.wf.service.CategorieDao;
import com.wf.entity.Categorie;

/**
 * FXML Controller class
 *
 * @author sfaxidorra
 */
public class AjoutCategorieFXMLController implements Initializable {

    @FXML
    private JFXButton AjouterBTN;
    @FXML
    private JFXTextField NomTXT;
    @FXML

    private JFXTextArea DescriptionTXT;
    @FXML
    private ImageView CategorieIV;
    @FXML
    private JFXButton UplodImageBTN;
    
    private FileChooser fc = null;
File selectedFile = null;
String ImagetoDB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCategorieAction(ActionEvent event) throws IOException {
        CategorieDao cd= new CategorieDao();
        Categorie c= new Categorie(NomTXT.getText(),ImagetoDB, DescriptionTXT.getText());
        cd.ajouterCat(c);
        AjouterBTN.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageCatFXML.fxml")));
    }

    @FXML
    private void UploadAction(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile=fc.showOpenDialog(new Stage());
        System.out.println("");
        if (selectedFile != null){

           String imagepath = selectedFile.toURI().toString();
           System.out.println("file==>  "+imagepath);
    Image image = new Image(imagepath);
           CategorieIV.setImage(image);
           
           File source = new File(selectedFile.getAbsolutePath());
           File dest = new File("C:\\xampp\\htdocs\\img");
           
           FileUtils.copyFileToDirectory(source, dest);
               Path p = Paths.get(selectedFile.getAbsolutePath());
               String file = p.getFileName().toString();
        ImagetoDB =file;
 
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialogue D'information");
            alert.setHeaderText("Veuillez sélectionner un fichier");
            alert.showAndWait();
        }
    }
}
