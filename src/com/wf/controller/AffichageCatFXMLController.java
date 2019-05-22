/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.wf.service.CategorieDao;
import com.wf.entity.Categorie;

/**
 * FXML Controller class
 *
 * @author sfaxidorra
 */
public class AffichageCatFXMLController implements Initializable {
    public static Categorie r = null;

    @FXML
    private TableView<Categorie> demandeTB;
   
    @FXML
    private Button Supprimer;
    @FXML
    private Button valider1;
    @FXML
    private Button ajoutCat;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> nbre;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private Button afficheCon;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCatFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         valider1.setOnAction(event -> {

            try {
                
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/ModifierCatFXML.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
       
       
    }    
 public void afficher() throws SQLException {

        CategorieDao rs = new CategorieDao();
        ArrayList<Categorie> s = new ArrayList<>();
        ObservableList<Categorie> obsl = null;
        s = (ArrayList<Categorie>) rs.ListCategories();
        obsl = FXCollections.observableArrayList(s);

        demandeTB.setItems(obsl);
        nom.setCellValueFactory(new PropertyValueFactory<>("nomcategorie"));
        nbre.setCellValueFactory(new PropertyValueFactory<>("nbrabonnees"));
        image.setCellValueFactory(new PropertyValueFactory<>("imgcatgorie"));
        description.setCellValueFactory(new PropertyValueFactory<>("descritpioncategorie"));

    }
 
 @FXML
    private void ajoutCatAction(ActionEvent event) throws IOException {
        // ajoutCat.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AjoutCategorieFXML.fxml")));
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/wf/controller/AjoutCategorieFXML.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
    }

    @FXML
    private void afficheConAction(ActionEvent event) throws IOException {
        // ajoutCat.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageConFXML.fxml")));
         Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageConFXML.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

    }
    
    @FXML
    private void supprimerAction(ActionEvent event) throws IOException {
        
        r = demandeTB.getSelectionModel().getSelectedItem();
        if (r != null) {
            System.out.println(r);
            
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Comfirmation");
                alert.setContentText("Voulez vous Vraiment Supprimer la catégorie ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    CategorieDao rs = new CategorieDao();
                    rs.supprimerCat(r.getIdcategorie());
                }
            
        }
        r = null;
        //Supprimer.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageCatFXML.fxml")));
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageCatFXML.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
    }


    @FXML
    private void modifier(MouseEvent event) throws IOException {
        r = demandeTB.getSelectionModel().getSelectedItem(); 
        // valider1.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/ModifierCatFXML.fxml")));
     
        ModifierCatFXMLController mod = new ModifierCatFXMLController();
        mod.setId(r.getIdcategorie());
        }
    }

    
