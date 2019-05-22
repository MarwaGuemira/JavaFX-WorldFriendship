/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import static com.wf.controller.AfficherProduitController.id;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
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
public class AdminEspaceProduitController implements Initializable {
 ObservableList<String> Acceptationlist= FXCollections.observableArrayList("Accépter","Non");
    @FXML
    private TableColumn<Produit, String> nomp;
    @FXML
    private TableColumn<Produit, Float> prixp;
    @FXML
    private TableColumn<Produit, String> catp;
    @FXML
    private TableColumn<Produit, String> etatp;
    @FXML
    private TableColumn<Produit, String> datep;
    @FXML
    private TableView<Produit> idtable;
    @FXML
    private Label idtxt;
ListData_2 listdata=new ListData_2();
    @FXML
    private Button btnacp;
    @FXML
    private ComboBox<String> idcom;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  idtable.setVisible(false);
        // TODO
 loadProduit();
         setCellValue();
         idcom.setValue("Non");
         idcom.setItems(Acceptationlist);
         
       
        nomp.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
        prixp.setCellValueFactory(new PropertyValueFactory<>("prix"));
        catp.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        etatp.setCellValueFactory(new PropertyValueFactory<>("etat"));
                datep.setCellValueFactory(new PropertyValueFactory<>("datemisevente"));


idtable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  
  
    }    
  public void loadProduit() 
  {
        
      ProduitService s = new ProduitService();
      ObservableList observableList = (ObservableList) s.AfficherProdNonAcpt("Non");
      idtable.setItems(observableList);
        
    }
  
    private void setCellValue() {
        
        
          idtable.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
                Produit pl = listdata.getUsers().get(idtable.getSelectionModel().getSelectedIndex());
                                id=pl.getIdproduit();
                
            }

          } ) ; 
//             
  //  }
   
}
    @FXML
    private void updateProdAdmin(ActionEvent event1) throws ClassNotFoundException, SQLException{
                
        ObservableList<Produit> selectedRows, allusers;
        allusers = idtable.getItems();
        selectedRows = idtable.getSelectionModel().getSelectedItems();
        for(Produit eve: selectedRows)
        {
            int x= eve.getIdproduit();
Produit u=new Produit (idcom.getValue());
            ProduitService pdao = ProduitService.getInstance();
            pdao.ModifAdmin(x,idcom.getValue());
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Produit est modifié avec succés!");
        alert.showAndWait();
  
        
//        newNamee.setText("");
//                newPrix.setText("");
//        newCategorie.setText("");
       // allusers.notify();
       // newDescription.setText("");        }    
  }  }
}    
    

