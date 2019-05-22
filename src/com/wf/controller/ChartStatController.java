/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

///**
// * FXML Controller class
// *
// * @author Marwa
// */
//public class ChartStatController implements Initializable {

//    @FXML
//    private CategoryAxis Xaxe;
//    @FXML
//    private BarChart<String, Integer> barc;
//
//
//    private ObservableList<String> names = FXCollections.observableArrayList();
//
//    private ListData listData = new ListData();
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//        
//            names = FXCollections
//                .observableArrayList(listData.getUsers().stream()
//                        .map(p -> p.getNbrlikes()).collect(Collectors.toList()));
//    Xaxe.setCategories(names);
//    
//    
//    }
//    public void setXYData(List<Evenement> persons) {
//        
//        
//        List<String> distinctNames=persons.stream()
//                .map(p->p.getNom())
//                .distinct()
//                .collect(Collectors.toList());
//        
//       
//        
//        int[] nameCounter =new int[distinctNames.size()];
//       
//        
//        
//        for (Evenement p : persons) {
//            String name = p.getNomevenement();
//             nameCounter[]++;
//        }
//
//        XYChart.Series<String, Integer> series = new XYChart.Series<>();
//
//        // Create a XYChart.Data object for each month. Add it to the series.
//        for (int i = 0; i < monthCounter.length; i++) {
//            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
//        }
//
//        barChart.getData().add(series);
//    }
        // TODO
//    }    
//    
//}
