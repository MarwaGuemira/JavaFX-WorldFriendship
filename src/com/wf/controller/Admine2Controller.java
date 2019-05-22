/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Evenement;
import com.wf.entity.Utilisateur;
import com.wf.entity.feedbackevent;
import com.wf.service.EvenementService;
import com.wf.service.feedbackeventservice;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class Admine2Controller implements Initializable {

    @FXML
    private JFXButton btnajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Utilisateur user = LoginFXMLController.CurrentUser;
        int id50 = user.getId();
       
        EvenementService e =  EvenementService.getInstance();
        
         List <Evenement>  event2 = e.displayAllListbyorganisateur(id50);
          System.out.println("loo  "+event2);
    //    ReservationService reservationService = new ReservationService();
//        ObservableList<Evenement> OB2 = FXCollections.observableArrayList();
//         OB2 = (ObservableList<Evenement>) es.displayAll();
          List <Evenement>  OB = new ArrayList<>();
       // ObservableList<Evenement> OB = FXCollections.observableArrayList();
        
         for (Evenement ee : event2){
  
    System.out.println(ee.getIdevenement());
     // Evenement kk = new Evenement();
    //  kk = es1.displayById(ee.getEven_id());
         //  OB2 = (ObservableList<Evenement>) es.displayAllListbyi(ee.getEven_id());
         LocalDate ki = LocalDate.now();
             System.out.println(ee); 
             if( ee.getDatedebut().isBefore(ki))
             { OB.add(ee);}
         }
          System.out.println(OB);
        
        
        feedbackeventservice f1 = feedbackeventservice.getInstance();
      //  feedbackevent f = new feedbackevent();
          List <feedbackevent>  OB2 = new ArrayList<>();
          for (Evenement ev : OB){
              System.out.println(ev.getIdevenement());
              
               List<feedbackevent> li = f1.displayAll();
        System.out.println("nn"+li);
      
//            List <feedbackevent>  feed = f1.disp(122); 
              int i=0;
            for ( feedbackevent ff : li){
                System.out.println("1-"+ff.getEven_id().getIdevenement());
                System.out.println("2-"+ev.getIdevenement());
                if (ff.getEven_id().getIdevenement() == ev.getIdevenement())
                { OB2.add(ff);
                 if(ff.getIdfeed()==1)
             {
             
             i=i+1;
             }
                 if(i==1)
                 {
                    
                 }
                
                }
              }
         
             for ( feedbackevent ff1 : OB2){
             
             if(ff1.getIdfeed()==1)
             {
             
             i=i+1;
             }
                 
             }
             if (i>30)
             {
             
             
             }
            
          
          }
          
           System.out.println("kikooo"+OB2);
         
          List <feedbackevent>  feed = f1.disp(141); 
             
            for ( feedbackevent ff : feed){
              System.out.println(ff);}
          
         
      List<feedbackevent> li = f1.displayAll();
        System.out.println("nn"+li);
      
      
    }    
    
}
