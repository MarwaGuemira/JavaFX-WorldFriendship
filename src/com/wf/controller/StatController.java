/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import com.wf.service.EvenementService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class StatController implements Initializable {

    @FXML
    private PieChart stat;
ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            

  
        // TODO
        EvenementService pdao=EvenementService.getInstance();
        List<Evenement> eves=pdao.displayAllList();
        for(Evenement e:eves) {
            list.addAll(
                new PieChart.Data(e.getPays(), 12.0)             
        );
        }
        stat.setAnimated(true);
        stat.setData(list);
        
    }
        // TODO
    }    
    

