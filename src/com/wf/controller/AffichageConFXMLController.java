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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
//import static pidev.v1.Controllers.AffichageCatFXMLController.r;
import com.wf.service.CategorieDao;
import com.wf.service.ConcoursDAO;
import com.wf.entity.Categorie;
import com.wf.entity.Concours;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sfaxidorra
 */
public class AffichageConFXMLController implements Initializable {
    public static Concours r = null;

    @FXML
    private TableView<Concours> demandeTB;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> cat;
    @FXML
    private TableColumn<?, ?> debut;
    @FXML
    private TableColumn<?, ?> fin;
    @FXML
    private TableColumn<?, ?> desc;
    @FXML
    private Button ajoutConcours;
    @FXML
    private Button suppConcours;
    @FXML
    private TextField recherche;
    @FXML
    private Button enCours;
    @FXML
    private Label nbr;
    @FXML
    private Label nbr2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();
            calc();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCatFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 public void afficher() throws SQLException {

        ConcoursDAO rs = new ConcoursDAO();
        ArrayList<Concours> s = new ArrayList<>();
        ObservableList<Concours> obsl = null;
        s = (ArrayList<Concours>) rs.ListConcours();
        obsl = FXCollections.observableArrayList(s);

        demandeTB.setItems(obsl);
        nom.setCellValueFactory(new PropertyValueFactory<>("nomconcours"));
        cat.setCellValueFactory(new PropertyValueFactory<>("categorie_id"));
        debut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        fin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        desc.setCellValueFactory(new PropertyValueFactory<>("descriptionconcours"));

    }

    @FXML
    private void ajoutConcoursAction(ActionEvent event) throws IOException {
        // ajoutConcours.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AjoutConcours.fxml")));
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/wf/controller/AjoutConcours.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
   
    }

    @FXML
    private void suppConcoursAction(ActionEvent event) throws IOException {
        r = demandeTB.getSelectionModel().getSelectedItem();
        
        if (r != null) {
            System.out.println(r);
            
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Comfirmation");
                alert.setContentText("Voulez vous Vraiment Supprimer le concours ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    ConcoursDAO rs = new ConcoursDAO();
                    rs.supprimerConcours(r.getIdconcours());
                }
            
        }
        r = null;
        suppConcours.getScene().setRoot(FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageConFXML.fxml")));
   
    }

    @FXML
    private void rechercheAction(ActionEvent event) throws SQLException {
        
        String nom1 = recherche.getText();
        ConcoursDAO rs = new ConcoursDAO();
        ArrayList<Concours> s = new ArrayList<>();
        ObservableList<Concours> obsl = null;
        s = (ArrayList<Concours>) rs.rechercheCon(nom1);
        obsl = FXCollections.observableArrayList(s);

        demandeTB.setItems(obsl);
        nom.setCellValueFactory(new PropertyValueFactory<>("nomconcours"));
        cat.setCellValueFactory(new PropertyValueFactory<>("categorie_id"));
        debut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        fin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        desc.setCellValueFactory(new PropertyValueFactory<>("descriptionconcours"));
    }

    @FXML
    private void enCoursAction(ActionEvent event) throws SQLException {
        ConcoursDAO rs = new ConcoursDAO();
        ArrayList<Concours> s = new ArrayList<>();
        ObservableList<Concours> obsl = null;
        s = (ArrayList<Concours>) rs.enCours();
        obsl = FXCollections.observableArrayList(s);

        demandeTB.setItems(obsl);
        nom.setCellValueFactory(new PropertyValueFactory<>("nomconcours"));
        cat.setCellValueFactory(new PropertyValueFactory<>("categorie_id"));
        debut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        fin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        desc.setCellValueFactory(new PropertyValueFactory<>("descriptionconcours"));
    }

    @FXML
    private void calculNbr(MouseEvent event) throws SQLException {
        
    }
    
    private void calc() throws SQLException{
        ConcoursDAO rs = new ConcoursDAO();
        ArrayList<Concours> s = new ArrayList<>();
        ObservableList<Concours> obsl = null;
        s = (ArrayList<Concours>) rs.ListConcours();
        String nb ="("+Integer.toString( s.size())+")";
        
        nbr.setText(nb);
        s = (ArrayList<Concours>) rs.enCours();
        nb ="("+Integer.toString( s.size())+")";
        nbr2.setText(nb);
    }
    
}
