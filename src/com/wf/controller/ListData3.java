/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import com.wf.entity.Reclamation;
import com.wf.entity.Utilisateur;
import com.wf.service.EvenementService;
import com.wf.service.ReclamationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public class ListData3 {
        private ObservableList<Reclamation>  recs=FXCollections.observableArrayList();
    public ListData3() {
        Utilisateur user = LoginFXMLController.CurrentUser;
        int id = user.getId();
        ReclamationService pdao= ReclamationService.getInstance();
  
         recs= (ObservableList<Reclamation>) pdao.displayAll();
        System.out.println(recs);
        
   
    }
     public ObservableList<Reclamation> getUsers(){
        return recs;
    } 
   
}
