/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Pub;
import com.wf.service.PubService;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AffichagePubController implements Initializable {

   @FXML
    private TableView userTable;
    @FXML
    private TableColumn<Pub, Integer> colId;
    @FXML
    private TableColumn<Pub, String> colNom;
    @FXML
    private TableColumn<Pub, String> coldesc;
      @FXML
    private TableColumn<Pub, Float> colnprixsol;
    @FXML
    private TableColumn<Pub, String> colpays;
    @FXML
    private TableColumn<Pub, String> colregion;
      @FXML
    private TableColumn<Pub, Float> colnprixa;
    @FXML
    private TableColumn<Pub, String> colAdresse;
     @FXML
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label descLabel;
     @FXML
    private TextField search2;
        @FXML
    private JFXButton ajouterpub;
                @FXML
    private JFXButton affmembre;
         @FXML
    private JFXButton mespub;
      private ListData2 listdata2 = new ListData2();
    /**
     * Initializes the controller class.
     */
      @FXML
       private Label nbr; 
      
       FilteredList<Pub> filter = new FilteredList<>(listdata2.getUsers(), e -> true); 
    @FXML
    private TableColumn<?, ?> colImage;
    @FXML
    private JFXButton retour;
@FXML
    private void search2(KeyEvent event1) {
       
       search2.textProperty().addListener((observable,oldValue,newValue) -> {
           filter.setPredicate((Predicate<? super Pub>) (Pub Pub)->{
           
             if(newValue.isEmpty() || newValue==null){
                 return true;
             }
             else if((Pub.getNompublicite().contains(newValue)) || (Pub.getNompublicite().toLowerCase().contains(newValue))){
                 return true;
             }
           return false;
           });
           
       });
       SortedList sort=new SortedList(filter);
       sort.comparatorProperty().bind(userTable.comparatorProperty());
       userTable.setItems(sort);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                    PubService pdao = PubService.getInstance();
                        ObservableList<Pub>  Pub2=FXCollections.observableArrayList();
                        Pub2= (ObservableList<Pub>) pdao.displayAll();
                       
                       int k= Pub2.size();
                     
                      nbr.setText(String.valueOf(k));
                        System.out.println(k);
                        for ( Pub p : Pub2)
                            
                        {  
                            
                          //  System.out.println(p);
                           // System.out.println(p.getDatepublicitefin());  
                            LocalDate daten = LocalDate.now();
                         //   System.out.println(daten);
                            if (p.getDatepublicitefin().isBefore(daten)) {
                            pdao.deleteAuto(p); }
                        }
         retour.setOnAction(event -> {

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
        
                 userTable.setItems(listdata2.getUsers());
              
                //   colId.setCellValueFactory(new PropertyValueFactory<>("idpublicite"));
                colNom.setCellValueFactory(new PropertyValueFactory<>("nompublicite"));
                coldesc.setCellValueFactory(new PropertyValueFactory<>("contenupublicte"));
                colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
                colAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
                colregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
                colnprixa.setCellValueFactory(new PropertyValueFactory<>("prixproduit"));
                colnprixsol.setCellValueFactory(new PropertyValueFactory<>("prixremise"));
                
                
                     
                     userTable.setOnMouseClicked(event->{
//        idLabel.setText(String.valueOf(listdata2.getUsers()
//                .get(userTable.getSelectionModel().getSelectedIndex()).getIdpublicite()
//               ));
        nomLabel.setText(listdata2.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getNompublicite());
        descLabel.setText(listdata2.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getContenupublicte());
                     });
                     
//          ajouterpub.setOnAction(event -> {
//
//            try {
//                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageOffre.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } 
//            catch (IOException ex) {
//                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });    

// mespub.setOnAction(event -> {
//
//            try {
//                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/MesPubs.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } 
//            catch (IOException ex) {
//                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });     
// 
//  affmembre.setOnAction(event -> {
//
//            try {
//                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichagePub2.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } 
//            catch (IOException ex) {
//                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });  
    }    
       
    
}
