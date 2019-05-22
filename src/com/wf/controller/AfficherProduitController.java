/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Houssem
 */
public class AfficherProduitController implements Initializable{
@FXML
private TableView<Produit> idtable;
@FXML
private  TableColumn<Produit,String>idn;
@FXML
private TableColumn<Produit,Float> idp;
@FXML
private TableColumn<Produit,String> idd;
    @FXML
    private TableColumn<Produit,String> idi;
    @FXML
    private Button modifier;
    @FXML
    private Button details;
    @FXML
    private Button supprimer;
    
     private   ListData_2 listdata = new ListData_2();
    @FXML
    private TextField newPrix;
    @FXML
    private TextField newCategorie;
    @FXML
    private TextField newNamee;
    @FXML
    private AnchorPane newDescription;
    public static int id;
    @FXML
    private Label labelnom;
    @FXML
    private Button ajout;
    @FXML
    private Button Myfav;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modifier.setDisable(true);
        details.setDisable(true);
        supprimer.setDisable(true);
//        labelnom.setText(value);
//        //throw new UnsupportedOperationException("Not supported yet.");
         loadProduit();
         setCellValue();
         
       
        idn.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
        idp.setCellValueFactory(new PropertyValueFactory<>("prix"));
        idd.setCellValueFactory(new PropertyValueFactory<>("descriptionproduit"));
        idi.setCellValueFactory(new PropertyValueFactory<>("categorie"));

idtable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  details.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
  ajout.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AjouterProduit.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
  Myfav.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceMyFavorite.fxml"));
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
  public void loadProduit() 
  {
        
      ProduitService s = new ProduitService();
      ObservableList observableList = (ObservableList) s.displayAll();
      idtable.setItems(observableList);
        
    }
  
    private void setCellValue() {
        
        
          idtable.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
                Produit pl = listdata.getUsers().get(idtable.getSelectionModel().getSelectedIndex());
                                id=pl.getIdproduit();
                newNamee.setText(pl.getNomproduit());
                
                
                newPrix.setText(Integer.toString((int) pl.getPrix()));
                newCategorie.setText((pl.getCategorie()));
               // newDescription.setText((pl.getDescriptionproduit()));
                
           modifier.setDisable(false);
           details.setDisable(false);
        supprimer.setDisable(false);
            }

          } ) ; 
//             
    }

//To change body of generated methods, choose Tools | Templates.
    
      @FXML
  private void updateUser(ActionEvent event1) throws ClassNotFoundException, SQLException{
                
        ObservableList<Produit> selectedRows, allusers;
        allusers = idtable.getItems();
        selectedRows = idtable.getSelectionModel().getSelectedItems();
        for(Produit eve: selectedRows)
        {
            int x= eve.getIdproduit();
//      Produit p=new Produit ( x,newNamee.getText(),
//              Integer.parseInt(newPrix.getText()),
//              //newDescription.getText(),
//              newCategorie.getText());
//            ProduitService pdao = ProduitService.getInstance();
//            
//            pdao.update(p);
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Votre Produit est modifié avec succés!");
        alert.showAndWait();
  
        
        newNamee.setText("");
                newPrix.setText("");
        newCategorie.setText("");
       // allusers.notify();
       // newDescription.setText("");        }    
  }  }
  
@FXML
    public void deleteButton(){
        ObservableList<Produit> selectedRows, allusers;
        allusers = idtable.getItems();
        selectedRows = idtable.getSelectionModel().getSelectedItems();
        for(Produit eve: selectedRows)
        {
          //  User1Service pdao1 = User1Service.getInstance();
            ProduitService ps = ProduitService.getInstance();
            
            allusers.remove(eve);
  ps.delete(eve);
        }
    }
  

    @FXML
    private void detailsAcrtion(ActionEvent event) {
    }

}
