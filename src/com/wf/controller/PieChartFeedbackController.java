/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Feedback;
import com.wf.service.FeedbackService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class PieChartFeedbackController implements Initializable {
    @FXML
    private PieChart pieChart;
    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    @FXML
    private Label nbrv;
    @FXML
    private Button btn;
    @FXML
    private Rating r;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int i=0;
        int j=0;
        int k=0;
        int l =0;
        int e=0;
        int moy=0;
              FeedbackService pdao=FeedbackService.getInstance();
        List<Feedback> pers=pdao.displayAllList();
         List<Integer> no=new ArrayList<>();
       // System.out.println(pdao.moyennenote());
        for(Feedback p:pers) {
            int ko  = p.note;
            moy = moy+ko;
            if (p.getNote()==1){
                i= i+1; }
            else if(p.getNote()==2){
                   j=j+1;
            }
             else if(p.getNote()==3){
                  k=k+1;
            }
             else if(p.getNote()==4){
                   l=l+1;
            }
             else {
                  e=e+1;
            }
         
        }
        int nbrvote=e+i+j+k+l;
        System.out.println(moy/nbrvote); 
        
        no.add(e);
            no.add(i);
              no.add(j);
                no.add(k);
                  no.add(l);
                  
                   List<String> no1=new ArrayList<>();
        for(int m : no) {
        
          list.addAll(
                new PieChart.Data(Integer.toString(m),m)             
        );}
        pieChart.setAnimated(true);
        pieChart.setData(list);
        
       nbrv.setText(Integer.toString(nbrvote));
        float m=(e*5+i+j*2+k*3+l*4)/nbrvote;
        System.out.println(e);
         System.out.println(i);
          System.out.println(j);
           System.out.println(k);
            System.out.println(l);
        System.out.println(m);
        r.ratingProperty().setValue(m);
       
        r.setDisable(true);
                                 btn.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficheFeedback.fxml"));
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

    }    
    

