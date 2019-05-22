/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Evenement;
import com.wf.entity.ProfitePub;
import com.wf.entity.Pub;
import com.wf.entity.Utilisateur;
import com.wf.service.EvenementService;
import com.wf.service.ProfitePubService;
import com.wf.service.PubService;
import com.wf.service.User1Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ihebm
 */
public class MesPubProfitController implements Initializable {

    @FXML
    private ScrollPane pane;
    @FXML
    private JFXButton retour;
public static int id2 ;
 @Override
    public void initialize(URL url, ResourceBundle rb) {
//        participation_evenementService es1 =new  participation_evenementService();
//        ObservableList<participation_evenement> OB1 = FXCollections.observableArrayList();
//  Utilisateur user = LoginFXMLController.CurrentUser;
//        int id50 = user.getId();
//         participation_evenementService k = new participation_evenementService(); 
//    List <participation_evenement>  event = k.displayAll1(id50);
//     
//// OB1 =  (ObservableList<participation_evenement>) es1.displayAll1(id50);
// // System.out.println(event);
//  for (participation_evenement ee : event){
//  
//    //  System.out.println(ee.getEven_id());}
//  }

         try {
            pane.setContent(ListEvent());
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
           retour.setOnAction(event2 -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficherPub.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });    
        
         
         
        
        // TODO
    }   
    
      public Node ListEvent() throws SQLException {

        VBox root0 = new VBox(20);
        HBox H0 = new HBox(10);
        VBox V2 = new VBox(10);
        
        
         //  OB2 = (ObservableList<Evenement>) es.displayAllListbyi(ee.getEven_id());
        
        
        PubService es = new PubService();
            //EvenementService es1 = new EvenementService();
        Utilisateur user = LoginFXMLController.CurrentUser;
        int id50 = user.getId();
        
          ProfitePubService k = new ProfitePubService(); 
    List <ProfitePub>  event2 = k.displayAll1(id50);
    
   // List <Pub>  event2 = es.displayAllListbyorganisateur(id50);
        //  System.out.println("loo  "+event2);
    //    ReservationService reservationService = new ReservationService();
       // ObservableList<Evenement> OB2 = FXCollections.observableArrayList();
      //   OB2 = (ObservableList<Evenement>) es.displayAll();
         
           ObservableList<Pub> OB = FXCollections.observableArrayList();
        
         for (ProfitePub ee : event2){
  
     
      Pub kk = new Pub();
      kk = es.displayById(ee.getP1().getIdpublicite());
        
 OB.add(kk);}
         
          System.out.println(OB);
        
    //     System.err.println(OB1);
        for (int i = 0; i < OB.size();i++) {
            HBox root = new HBox(10);
            root.setAlignment(Pos.CENTER_LEFT);
            root.setStyle("-fx-Border-color:  #2471A3");
            root.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));

            Pub evt = OB.get(i);
          //  Evenement evt1 = OB.get(i+1);
         //   Evenement e = new Evenement(evt.)
    //   int id2 = evt.getIdevenement();
       
            System.out.println(evt.getNomimage());
             String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+evt.getNomimage();
                        Image img=new Image(pathimage);
                       // imageview.setImage(img);
            //affiche image
//            File file = new File("../../../images/" + evt.getNomimage());
//            Image image = new Image(file.toURI().toString());
            //  Image img = new Image(getClass().getResource("http://localhost/PIDev_WorldFriendship/web/images/"+evt.getNomimage()).toExternalForm());
                      //    ImageView imgv = new ImageView(img);
            ImageView IMG = new ImageView(img);
            IMG.fitHeightProperty().set(200);
            IMG.fitWidthProperty().set(200);
            IMG.preserveRatioProperty().set(true);
            Separator sep = new Separator(Orientation.VERTICAL);
            VBox root2 = new VBox(6);
            root2.prefWidthProperty().set(200);
            root2.prefHeightProperty().set(200);
            root2.setPadding(new javafx.geometry.Insets(4, 4, 4, 4));

            //les information de evene
            //*****titre
            Label Name = new Label(evt.getNompublicite());
            Name.setFont(new javafx.scene.text.Font("Arial", 30));
            Name.setTextFill(Color.web("#17202A"));
            Label Description = new Label(evt.getContenupublicte());
            Name.setFont(new javafx.scene.text.Font("Arial", 30));
            Name.setTextFill(Color.web("#17202A"));
            Label IdEvent = new Label(String.valueOf(evt.getPoint()));
            
            Name.setFont(new javafx.scene.text.Font("Arial", 30));
            Name.setTextFill(Color.web("#17202A"));
             Label prix = new Label(String.valueOf(evt.getPrixproduit()));
            Name.setFont(new javafx.scene.text.Font("Arial", 30));
            Name.setTextFill(Color.web("#17202A"));
             
     
              IMG.setOnMousePressed( event ->{
                  System.out.println(evt.getIdpublicite());
              int  id5=evt.getIdpublicite();
                  System.out.println(id5);
                  id2 =id5 ;
                try {
               
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffPubMesPro.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
              });
           
            
          
         //   Separator sep2 = new Separator(Orientation.VERTICAL);

//            String date = DateFormat.getDateInstance().format(evt.getDate());
//            Label p = new Label(date);
//            Name.setFont(new javafx.scene.text.Font("Arial", 30));
//            Name.setTextFill(Color.web("#17202A"));

          //  VBox root3 = new VBox(3);
         //   Separator sep3 = new Separator(Orientation.VERTICAL);
//              Separator sep4 = new Separator(Orientation.VERTICAL);
//
//          VBox root7 = new VBox(6);
//            //affiche image
//            File file = new File("../../../images/" + evt1.getNomimage());
//            Image image = new Image(file.toURI().toString());
//              Image img1 = new Image(getClass().getResource("../../../images/"+evt1.getNomimage()).toExternalForm());
//                      //    ImageView imgv = new ImageView(img);
//            ImageView IMG1 = new ImageView(img1);
//            IMG1.fitHeightProperty().set(200);
//            IMG1.fitWidthProperty().set(200);
//            IMG1.preserveRatioProperty().set(true);
//            Separator sep7 = new Separator(Orientation.VERTICAL);
//            VBox root3 = new VBox(6);
//            root3.prefWidthProperty().set(200);
//            root3.prefHeightProperty().set(200);
//            root3.setPadding(new javafx.geometry.Insets(2, 2, 2, 2));
//
//            //les information de evene
//            //*****titre
//            Label Name1 = new Label(evt1.getNomevenement());
//            Name1.setFont(new javafx.scene.text.Font("Arial", 30));
//            Name1.setTextFill(Color.web("#17202A"));
//            Label Description1 = new Label(evt1.getDescriptionevenement());
//            Name.setFont(new javafx.scene.text.Font("Arial", 30));
//            Name.setTextFill(Color.web("#17202A"));
//            Label IdEvent1 = new Label(String.valueOf(evt1.getNbrplacestotal()));
//            
//            Name.setFont(new javafx.scene.text.Font("Arial", 30));
//            Name.setTextFill(Color.web("#17202A"));
//             Label prix1 = new Label(Integer.toString(evt1.getNbrparticipants()));
//            Name.setFont(new javafx.scene.text.Font("Arial", 30));
//            Name.setTextFill(Color.web("#17202A"));
//         //   Separator sep2 = new Separator(Orientation.VERTICAL);
//
////            String date = DateFormat.getDateInstance().format(evt.getDate());
////            Label p = new Label(date);
////            Name.setFont(new javafx.scene.text.Font("Arial", 30));
////            Name.setTextFill(Color.web("#17202A"));
//
//          //  VBox root3 = new VBox(3);
//         //   Separator sep3 = new Separator(Orientation.VERTICAL);
//             
//          IMG1.setOnMousePressed( event ->{
//                  System.out.println(evt1.getIdevenement());
//              int  id6=evt.getIdevenement();
//                  System.out.println(id6);
//                  id2 =id6 ;
//                try {
//               
//                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffichageEvent2.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } 
//            catch (IOException ex) {
//                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//              });
// Separator sep8 = new Separator(Orientation.VERTICAL);
            root2.getChildren().addAll(Name, Description,IdEvent,prix);
            root2.setId(String.valueOf(evt.getIdpublicite()));
//            root3.getChildren().addAll(Name1, Description1,IdEvent1,prix1);
//            root3.setId(String.valueOf(evt.getIdevenement()));
            root.getChildren().addAll(IMG, sep, root2);

          //  root3.getChildren().addAll(btn);

            root0.getChildren().add(root);
            root0.setPrefSize(820, 700);
            root0.setPadding(new javafx.geometry.Insets(0, 0, 0, 0));

        }
        return root0;

    }
    private void ajeve(ActionEvent event) throws IOException {
        
           Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/wf/controller/Meseventpasser.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setTitle("Reservations!");
                primaryStage.setScene(scene);
                primaryStage.show();
    }

}
