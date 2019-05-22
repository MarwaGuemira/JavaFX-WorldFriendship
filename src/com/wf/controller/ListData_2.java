/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Produit;
import com.wf.entity.Utilisateur;
import com.wf.service.ProduitService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class ListData_2 {
      private ObservableList<Produit>  events=FXCollections.observableArrayList();
 private ObservableList<Produit>  events1=FXCollections.observableArrayList();
    public ListData_2() {
      //  Utilisateur user = LoginFXMLController.CurrentUser;
        //int id = user.getId();
        ProduitService pdao= ProduitService.getInstance();
         ProduitService pdao1= ProduitService.getInstance();
         events= (ObservableList<Produit>) pdao.displayAll();
        System.out.println( events);
        
    // events1= (ObservableList<Produit>) pdao1.displayById(0);
//        System.out.println( events1);
    }
     public ObservableList<Produit> getUsers(){
        return events;
    } 
     public ObservableList<Produit> getprod(){
        return events;
    } 
}
