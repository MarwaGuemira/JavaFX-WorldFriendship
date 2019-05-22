/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Feedback;
import com.wf.entity.Reclamation;
import com.wf.entity.Utilisateur;
import com.wf.service.FeedbackService;
import com.wf.service.ReclamationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public class ListFeed {
            private ObservableList<Feedback>  feeds=FXCollections.observableArrayList();
    public ListFeed() {
        Utilisateur user = LoginFXMLController.CurrentUser;
        int id = user.getId();
        FeedbackService pdao= new FeedbackService();
  
         feeds= (ObservableList<Feedback>) pdao.displayAll();
        System.out.println(feeds);
        
   
    }
     public ObservableList<Feedback> getUsers(){
        return feeds;
    } 
    
    
}
