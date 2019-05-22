/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Evenement;
import com.wf.service.EvenementService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AffichageMesEvenementController implements Initializable {
 @FXML
    private TableView eveTable;
    //private TableColumn<Evenement, Integer> colId;
    @FXML
    private TableColumn<Evenement, String> colNom;
    @FXML
    private TableColumn<Evenement, String> coldesc;
      @FXML
    private TableColumn<Evenement, Integer> colnbrpar;
    @FXML
    private TableColumn<Evenement, String> colpays;
    @FXML
    private TableColumn<Evenement, String> colregion;
      @FXML
    private TableColumn<Evenement, Integer> colnbtick;
    @FXML
    private TableColumn<Evenement, String> colAdresse;
 //   private TextField idLabel;
    @FXML
    private TextField nomLabel;
    @FXML
    private TextField descLabel;
   
      @FXML
    private Button modifier;
      
//       
      private ListData listdata = new ListData();
    @FXML
    private TextField search2;
    @FXML
    private JFXButton retour;
    @FXML
    private TextField pays;
    @FXML
    private TextField nbrtick;
    @FXML
    private TextField region;
    @FXML
    private TextField adresse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          modifier.setDisable(true);
          
        // TODO
                 eveTable.setItems(listdata.getUsers2());
              setCellValue();
                //   colId.setCellValueFactory(new PropertyValueFactory<>("idevenement"));
                colNom.setCellValueFactory(new PropertyValueFactory<>("nomevenement"));
                coldesc.setCellValueFactory(new PropertyValueFactory<>("descriptionevenement"));
                colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
                colAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
                colregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
                colnbrpar.setCellValueFactory(new PropertyValueFactory<>("nbrparticipants"));
                colnbtick.setCellValueFactory(new PropertyValueFactory<>("nbrtickets"));
                
      eveTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//                     
//                     userTable.setOnMouseClicked(event->{
//        idLabel.setText(String.valueOf(listdata.getUsers()
//                .get(userTable.getSelectionModel().getSelectedIndex()).getIdevenement()
//               ));
//        nomLabel.setText(listdata.getUsers()
//                .get(userTable.getSelectionModel().getSelectedIndex())
//                .getNomevenement());
//        descLabel.setText(listdata.getUsers()
//                .get(userTable.getSelectionModel().getSelectedIndex())
//                .getDescriptionevenement());
//                     });
//                     
                     
   
      retour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageEvenement.fxml"));
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
    
//        @FXML
    @FXML
    public void enable()
    {}
    private void setCellValue() {
        
        
          eveTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
                Evenement pl = listdata.getUsers2().get(eveTable.getSelectionModel().getSelectedIndex());
              //  idLabel.setText(Integer.toString(pl.getIdevenement()));
                nomLabel.setText(pl.getNomevenement());
                descLabel.setText((pl.getDescriptionevenement()));
                 pays.setText((pl.getPays()));
                                adresse.setText((pl.getAdresse()));
                 region.setText((pl.getRegion()));
                 nbrtick.setText(Integer.toString(pl.getNbrtickets()));

            modifier.setDisable(false);
            }


                // supprimer.setDisable(false);
                // anchor.setDisable(false);

          } ) ; 
//             
    }

//    
//     @FXML
//    private void updateAction(ActionEvent event) throws SQLException {
//
//        
//        String nomEvenement1E = (nomLabel.getText());
//          String etatE =( descLabel.getText());
//      
//        //System.out.println(image.getText());
//
//        //int idUser = i
//        Evenement even = new Evenement();
//
//     
//        even.setNomevenement(nomEvenement1E);
//       
//        even.setDescriptionevenement(etatE);
//        
//
//       EvenementService se = EvenementService.getInstance();
//        se.update(even);
//   
//
//        
//
//      
//        userTable.refresh();
//        
//
//    }
// 
//     @FXML
//public void refresh()
//{
//      
//          listViewEvenement.clear();
//          loadDataFromDatabase();
//          eveTable.refresh();
//                 
//                
//               
//}

    
        @FXML
  private void updateUser(ActionEvent event1) throws ClassNotFoundException, SQLException{
                
        ObservableList<Evenement> selectedRows, allusers;
        allusers = eveTable.getItems();
        selectedRows = eveTable.getSelectionModel().getSelectedItems();
        for(Evenement eve: selectedRows)
        {
     
      
      
      Evenement u=new Evenement (nomLabel.getText(),pays.getText(),region.getText(),adresse.getText(),descLabel.getText(),nbrtick.getText());
            EvenementService pdao = EvenementService.getInstance();
            pdao.update(u);
            eveTable.refresh();
             
//            listViewEvenement.clear();
//       
//            eveTable.setItems(listdata.getUsers());
//              setCellValue();
//                   colId.setCellValueFactory(new PropertyValueFactory<>("idevenement"));
//                colNom.setCellValueFactory(new PropertyValueFactory<>("nomevenement"));
//                coldesc.setCellValueFactory(new PropertyValueFactory<>("descriptionevenement"));
//                colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
//                colAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
//                colregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
//                colnbrpar.setCellValueFactory(new PropertyValueFactory<>("nbrparticipants"));
//                colnbtick.setCellValueFactory(new PropertyValueFactory<>("nbrplacestotal"));
//          
//              
//       
//            
//            
            
            
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne modifié avec succés!");
        alert.showAndWait();
  
        
        //idLabel.setText("");
                nomLabel.setText("");
        descLabel.setText("");
        }    
  }  
  
   @FXML
    public void deleteButton(){
        ObservableList<Evenement> selectedRows, allusers;
        allusers = eveTable.getItems();
        selectedRows = eveTable.getSelectionModel().getSelectedItems();
        for(Evenement eve: selectedRows)
        {
          //  User1Service pdao1 = User1Service.getInstance();
            allusers.remove(eve);
            
            
        }
    }

//    private void loadDataFromDatabase() {
//      EvenementService hs = new EvenementService();
//
//        List<Evenement> listEvenement = hs.displayAllList();
//
//       
//   for (Evenement ev : listEvenement) {
//            listViewEvenement.add(ev);
//        }
//
//        eveTable.setItems(listViewEvenement);
//    }
    
    
         FilteredList<Evenement> filter = new FilteredList<>(listdata.getUsers(), e -> true);   
    @FXML
    private void search2(KeyEvent evloent4) {
       
       search2.textProperty().addListener((observable,oldValue,newValue) -> {
           filter.setPredicate((Predicate<? super Evenement>) (Evenement Evenement)->{
           
             if(newValue.isEmpty() || newValue==null){
                 return true;
             }
             else if((Evenement.getNomevenement().contains(newValue)) || (Evenement.getNomevenement().toLowerCase().contains(newValue))){
                 return true;
             }
           return false;
           });
           
       });
       SortedList sort=new SortedList(filter);
       sort.comparatorProperty().bind(eveTable.comparatorProperty());
      eveTable.setItems(sort);
    }

    @FXML
    private void search2(ActionEvent event) {
    }

    
    

    }
    