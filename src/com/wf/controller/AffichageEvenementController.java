/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.wf.entity.Evenement;

import com.wf.service.EvenementService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AffichageEvenementController implements Initializable {
//  private ObservableList<Evenement> listViewEvenement;
//    @FXML
//    private TableView eveTable;
//    @FXML
//    private TableColumn<Evenement, Integer> colId;
//    @FXML
//    private TableColumn<Evenement, String> colNom;
//    @FXML
//    private TableColumn<Evenement, String> coldesc;
//      @FXML
//    private TableColumn<Evenement, Integer> colnbrpar;
//    @FXML
//    private TableColumn<Evenement, String> colpays;
//    @FXML
//    private TableColumn<Evenement, String> colregion;
//      @FXML
//    private TableColumn<Evenement, Integer> colnbtick;
//    @FXML
//    private TableColumn<Evenement, String> colAdresse;
//     @FXML
//    private Label idLabel;
//    @FXML
//    private Label nomLabel;
//    @FXML
//    private Label descLabel;
//       @FXML
   // private TextField search2;
      @FXML
    private JFXButton btmeseve;
    @FXML
    private JFXButton btajout;
    public static int idev ;
        @FXML
    private ListView<Evenement> listview; 
 private ListData listdata = new ListData();
//    @FXML
//    private TableColumn<?, ?> colImage;
//    @FXML
//    private ImageView imageview;
//    @FXML
//    private Label image;
    @FXML
    private JFXButton btnvoir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        
        listview.setCellFactory(new Callback<ListView<Evenement>, ListCell<Evenement>>() {
           @Override
           public ListCell<Evenement> call(ListView<Evenement> param) {
               ListCell<Evenement> cell = new ListCell<Evenement>(){
                  @Override
                  protected void  updateItem(Evenement nomevenement, boolean btl1){
                      super.updateItem(nomevenement, btl1);
                      if(nomevenement!=null){
                          Image img = new Image(getClass().getResource("../../../images/"+nomevenement.getNomimage()).toExternalForm());
                          ImageView imgv = new ImageView(img);
                          imgv.setFitHeight(100);
                          imgv.setFitWidth(100);
                          imgv.setPreserveRatio(true);
                          setGraphic(imgv);
//                         
       //setText(nomevenement.getNomimage());
        setText(nomevenement.getNomevenement());
        setText(nomevenement.getDescriptionevenement());
                      }
                  }
               };
               return cell;

                       }}) ;
         
//       ObservableList<Evenement> evee = listdata.getUsers();
//        for (Evenement e : evee) {
        Label a = new Label();
         a.setText("lolo");
        
       // }
        
        
        
  setCellValue();
  
      listview.setItems( listdata.getUsers());
      
           
   btajout.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AjouterEvenement.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
           btmeseve.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageMesEvenement.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
        btnvoir.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageEvent1.fxml"));
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
        
        
          listview.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
                Evenement pl = listdata.getUsers().get(listview.getSelectionModel().getSelectedIndex());
             idev =  pl.getIdevenement();
//                idLabel.setText(Integer.toString(pl.getIdevenement()));
//                nomLabel.setText(pl.getNomevenement());
//                descLabel.setText((pl.getDescriptionevenement()));
////                image.setText(listdata.getUsers()
//                .get(eveTable.getSelectionModel().getSelectedIndex())
//                .getNomimage());
//   
//   
//    String imagepath = "/images/"+listdata.getUsers()
//                .get(eveTable.getSelectionModel().getSelectedIndex())
//                .getNomimage();
//           //System.out.println("file==>  "+imagepath);
//           Image image = new Image(imagepath);
//           imageview.setImage(image);
                //image.setText(value);
//            modifier.setDisable(false);
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

    
//        @FXML
//  private void updateUser(ActionEvent event1) throws ClassNotFoundException, SQLException{
//                
//        ObservableList<Evenement> selectedRows, allusers;
//        allusers = eveTable.getItems();
//        selectedRows = eveTable.getSelectionModel().getSelectedItems();
//        for(Evenement eve: selectedRows)
//        {
//     
//      
//      
//      Evenement u=new Evenement (Integer.parseInt(idLabel.getText()),nomLabel.getText(),descLabel.getText());
//            EvenementService pdao = EvenementService.getInstance();
//            pdao.update(u);
//             
////            listViewEvenement.clear();
////       
////            eveTable.setItems(listdata.getUsers());
////              setCellValue();
////                   colId.setCellValueFactory(new PropertyValueFactory<>("idevenement"));
////                colNom.setCellValueFactory(new PropertyValueFactory<>("nomevenement"));
////                coldesc.setCellValueFactory(new PropertyValueFactory<>("descriptionevenement"));
////                colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
////                colAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
////                colregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
////                colnbrpar.setCellValueFactory(new PropertyValueFactory<>("nbrparticipants"));
////                colnbtick.setCellValueFactory(new PropertyValueFactory<>("nbrplacestotal"));
////          
////              
////       
////            
////            
//            
//            
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Personne modifié avec succés!");
//        alert.showAndWait();
//  
//        
//        idLabel.setText("");
//                nomLabel.setText("");
//        descLabel.setText("");
//        }    
//  }  
//  
//   @FXML
//    public void deleteButton(){
//        ObservableList<Evenement> selectedRows, allusers;
//        allusers = eveTable.getItems();
//        selectedRows = eveTable.getSelectionModel().getSelectedItems();
//        for(Evenement eve: selectedRows)
//        {
//          //  User1Service pdao1 = User1Service.getInstance();
//            allusers.remove(eve);
//            
//        }
//    }

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
//    
//         FilteredList<Evenement> filter = new FilteredList<>(listdata.getUsers(), e -> true);   
//    @FXML
//    private void search2(KeyEvent evloent4) {
//       
//       search2.textProperty().addListener((observable,oldValue,newValue) -> {
//           filter.setPredicate((Predicate<? super Evenement>) (Evenement Evenement)->{
//           
//             if(newValue.isEmpty() || newValue==null){
//                 return true;
//             }
//             else if((Evenement.getNomevenement().contains(newValue)) || (Evenement.getNomevenement().toLowerCase().contains(newValue))){
//                 return true;
//             }
//           return false;
//           });
//           
//       });
//       SortedList sort=new SortedList(filter);
//       sort.comparatorProperty().bind(listview.comparatorProperty());
//      listview.setItems(sort);
//    }

    public int getIdev() {
        return idev;
    }

    public void setIdev(int idev) {
        this.idev = idev;
    }
    

    }
    
