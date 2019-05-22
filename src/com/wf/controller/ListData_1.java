/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;


import com.wf.entity.Pub;
import com.wf.entity.Utilisateur;

import com.wf.service.PubService;
import com.wf.service.User1Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marwa
 */
class ListData2 {
     private ObservableList<Pub>  Pubs=FXCollections.observableArrayList();
     private ObservableList<Pub>  Pubs2=FXCollections.observableArrayList();

    public ListData2() 
    {
         Utilisateur user = LoginFXMLController.CurrentUser;
          int id = user.getId();
        PubService pdao= PubService.getInstance();
         Pubs= (ObservableList<Pub>) pdao.displayAll();
        System.out.println( Pubs);
        
    
                PubService pdao2= PubService.getInstance();

          Pubs2= (ObservableList<Pub>) pdao2.displayAllListbyorganisateur(id);
        System.out.println( Pubs2);
    }
    
    public ObservableList<Pub> getUsers()
    {
        return Pubs;
    }
      
    public ObservableList<Pub> getUsers2()
    {
        return Pubs2;
    }

}
