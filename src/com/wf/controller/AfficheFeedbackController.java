/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Feedback;
import com.wf.entity.Pub;
import com.wf.entity.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class AfficheFeedbackController implements Initializable {

    @FXML
    private TableView<Feedback> tablefeed;
    @FXML
    private TableColumn<Feedback, Integer> note;
    @FXML
    private TableColumn<Feedback, String> descfeed;
    @FXML
    private TableColumn<Feedback, String> datefeed;
    @FXML
    private Button btn;
    @FXML
    private TextField search2;
    private Rating r;
    private ListFeed listdata = new ListFeed();
 FilteredList<Feedback> filter = new FilteredList<>(listdata.getUsers(), e -> true); 
        @FXML
    private Button btn2;
    
     
     
     
     
     
     
     
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       System.out.println(listdata.getUsers());
        
                              tablefeed.setItems(listdata.getUsers());
//              r.ratingProperty().setValue(f.getNote());
                  note.setCellValueFactory(new PropertyValueFactory<>("note"));
                descfeed.setCellValueFactory(new PropertyValueFactory<>("descfeedback"));
    datefeed.setCellValueFactory(new PropertyValueFactory<>("datefeedback"));
    
        
               btn.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/PieChartFeedback.fxml"));
                Scene scene = new Scene(page1,1000,1000);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
                              btn2.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/feedbacketreclamAdmin.fxml"));
                Scene scene = new Scene(page1,1000,1000);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        // TODO
    }    
    @FXML
    private void search2(KeyEvent event1) {
       
       search2.textProperty().addListener((observable,oldValue,newValue) -> {
           filter.setPredicate((Predicate<? super Feedback>) (Feedback Feed)->{
           
             if(newValue.isEmpty() || newValue==null){
                 return true;
             }
             else if((Integer.toString( Feed.getNote()).contains(newValue)) ){
                 return true;
             }
           return false;
           });
           
       });
       SortedList sort=new SortedList(filter);
       sort.comparatorProperty().bind(tablefeed.comparatorProperty());
       tablefeed.setItems(sort);
    }
}
