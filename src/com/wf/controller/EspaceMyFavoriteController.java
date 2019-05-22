/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import static com.wf.controller.AfficherProduitController.id;
import com.wf.entity.Produit;
import com.wf.service.FavoriteProdService;
import com.wf.service.ProduitService;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EspaceMyFavoriteController implements Initializable {

    @FXML
    private TableColumn<Produit, String> Nomp;
    @FXML
    private TableColumn<Produit, Float> prix;
    @FXML
    private TableColumn<Produit, String> Categorie;
    @FXML
    private TableColumn<Produit, String> Description;
    @FXML
    private Button Retour;
    @FXML
    private Button Espace_Vente;
    @FXML
    private Button Accueil;
    @FXML
    private TableView<Produit> idtable;
    @FXML
    private Button supprimerproduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Espace_Vente.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceVente.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Retour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceVente.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         Accueil.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Accueil.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         supprimerproduit.setDisable(true);
            
        MyFavoriteProduit();
        setCellValue();
        
        Nomp.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        Categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        Description.setCellValueFactory(new PropertyValueFactory<>("descriptionproduit"));
    } 
    public void MyFavoriteProduit()
    {
    ProduitService s = new ProduitService();
      ObservableList observableList = (ObservableList) s.AfficherMyFavoriteProduit(2);
      idtable.setItems(observableList);
    }
    private void setCellValue() {
        
        
          idtable.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
               
        supprimerproduit.setDisable(false);
            }

          } ) ; 
//             
    }

    @FXML
    private void delete(ActionEvent event) {
          ObservableList<Produit> selectedRows, allusers;
        allusers = idtable.getItems();
        selectedRows = idtable.getSelectionModel().getSelectedItems();
        for(Produit eve: selectedRows)
        {
          //  User1Service pdao1 = User1Service.getInstance();
            FavoriteProdService ps = FavoriteProdService.getInstance();
            int a=eve.getIdproduit();
            allusers.remove(eve);
  ps.Effacer(a,2);
        }
    }
}
