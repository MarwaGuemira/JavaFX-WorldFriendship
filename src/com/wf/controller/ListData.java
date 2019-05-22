/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import com.wf.entity.Utilisateur;
import com.wf.entity.commentevenement;
import com.wf.entity.participation_evenement;
import com.wf.service.EvenementService;
import com.wf.service.User1Service;
import com.wf.service.UtilisateurService;
import com.wf.service.commentevenementService;
import com.wf.service.participation_evenementService;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marwa
 */
class ListData {
     private ObservableList<Evenement>  events=FXCollections.observableArrayList();
 private ObservableList<Evenement>  events1=FXCollections.observableArrayList();
  private ObservableList<Evenement>  events3=FXCollections.observableArrayList();
  //private ObservableList<commentevenement>  eventscom=FXCollections.observableArrayList();
  

 //private ObservableList<participation_evenement>  parevents=FXCollections.observableArrayList();
    public ListData() {
        Utilisateur user = LoginFXMLController.CurrentUser;
        int id = user.getId();
      //  int k =  116;
        EvenementService pdao= EvenementService.getInstance();
          EvenementService pdao1= EvenementService.getInstance();
         //  UtilisateurService as= new UtilisateurService();
         // commentevenementService comser = commentevenementService.getInstance();
          participation_evenementService pd =participation_evenementService.getInstance();
         events= (ObservableList<Evenement>) pdao.displayAll();
       // System.out.println( events);
        
          events1= (ObservableList<Evenement>) pdao1.displayAllListbyorganisateur(id);
          
           // eventscom =(ObservableList<commentevenement>) comser.affcom(k);
          
       // System.out.println( events1);
    //   events2 = (ObservableList<Evenement>) pdao1.displayAllListbyorganisateur(id);
       // parevents=(ObservableList<participation_evenement>)pd.displayAll();
        
    }
     public ObservableList<Evenement> getUsers(){
        return events;
    } 
    public ObservableList<Evenement> getUsers1(){
        events.clear();
      
        return events;
    }
      public ObservableList<Evenement> getUsers2(){
        return events1;
    } 
                           

//      
//        public ObservableList<commentevenement> getcommeve( ){
//
//        return eventscom;
//    } 
//public ObservableList<participation_evenement> getUsers3(){
//    return parevents;
//}
    }
    
    

