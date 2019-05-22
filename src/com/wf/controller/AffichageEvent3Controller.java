/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Evenement;
import com.wf.entity.Utilisateur;
import com.wf.entity.commentevenement;
import com.wf.entity.feedbackevent;
import com.wf.entity.likeevenement;
import com.wf.entity.participation_evenement;
import com.wf.service.EvenementService;
import com.wf.service.UtilisateurService;
import com.wf.service.commentevenementService;
import com.wf.service.feedbackeventservice;
import com.wf.service.likeevenementService;
import com.wf.service.participation_evenementService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AffichageEvent3Controller implements Initializable {
  private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label descLabel;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField idcomm;
  private ListData listdata = new ListData();
    @FXML
    private JFXTextField textmodif;
int idc ;
    @FXML
    private JFXButton modifco;
    @FXML
    private ImageView imageview;
    @FXML
    private JFXDatePicker iddebut;
    @FXML
    private DatePicker iddebutfin;
    @FXML
    private Label idpayst;
    @FXML
    private Label idregion;
    @FXML
    private Label idadresse;
    private Label idnbrtot;
    @FXML
    private Label idnbrpr;
    @FXML
    private Label nbrlike;
    @FXML
    private Label nbrdislike;
    @FXML
    private ScrollPane pane;
    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXCheckBox f1;
    @FXML
    private JFXCheckBox f2;
    @FXML
    private JFXCheckBox f3;
    @FXML
    private JFXCheckBox f4;
    
  private int kii = 0 ;
    private String ki ; 
//    @FXML
//    private Label iddebut;
//    @FXML
//    private Label idfin;
//  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textmodif.setVisible(false);
        modifco.setVisible(false);
       try {
           UtilisateurService ud= new UtilisateurService();
       } catch (SQLException ex) {
           Logger.getLogger(AffichageEvent1Controller.class.getName()).log(Level.SEVERE, null, ex);
       }
         int i = MesevenementreserverController.id2;
           Evenement p = new Evenement();
   EvenementService s = new EvenementService();
    p = s.displayById(i); 
    p.getIdevenement();
    System.out.println(p);
    //idLabel.setText(Integer.toString(p.getIdevenement()));
    nomLabel.setText(p.getNomevenement());
    descLabel.setText((p.getDescriptionevenement()));
// DateFormat dateFormat = new SimpleDateFormat();
  //  String strDate = dateFormat.format(p.getDatedebut());
//LocalDate s1 = (String)p.getDatedebut();
//iddebut.setText(p.getDatedebut());
    //idfin.setText(p.getDatefin());
    
  //  String k =  new String (  p.getDatedebut());
  
  iddebut.setValue(p.getDatedebut());
   iddebutfin.setValue(p.getDatefin());
      idregion.setText(p.getRegion());
         idpayst.setText(p.getPays());
            idadresse.setText(p.getAdresse());
               idnbrpr.setText(Integer.toString(p.getNbrparticipants()));
                  nbrlike.setText(Integer.toString(p.getNbrlikes()));
                     nbrdislike.setText(Integer.toString(p.getNbrdislikes()));
                
       String imagepath = "/images/"+p.getNomimage();
           Image image = new Image(imagepath);
           imageview.setImage(image);
          Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
          
          
  
        try {
            
            pane.setContent(ListEvent());
        } catch (SQLException ex) {
            Logger.getLogger(AffichageEvent1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        f1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
         f2.setSelected(false);
          f3.setSelected(false);
           f4.setSelected(false);
           
  kii = 1 ;
         ki ="oui";
        }
         });
            f2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
         f1.setSelected(false);
          f3.setSelected(false);
           f4.setSelected(false);
           
  kii = 2 ;
         ki ="looooop";
        }
         });
                 f3.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
         f2.setSelected(false);
          f1.setSelected(false);
           f4.setSelected(false);
           
  kii = 3 ;
         ki ="lol";
        }
         });
                 
                 
                      f4.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
         f2.setSelected(false);
          f3.setSelected(false);
           f1.setSelected(false);
           
  kii = 4 ;
         ki ="non";
        }
         });
  
    
    
    
    
    

// TODO
        retour.setOnAction(event2 -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/MesEvenementreserver.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });    
        
  
    // na3ref user connecter tawa 
       
          //
          participation_evenement pn = new participation_evenement(user.getId(), i);
          likeevenement like = new  likeevenement(user.getId(), i, "like");
              likeevenement dislike = new  likeevenement(user.getId(), i, "dislike");

    }
    
    
     @FXML
  private void ajoutfeed (ActionEvent event) throws ClassNotFoundException,SQLException{
         
   
         Utilisateur user = LoginFXMLController.CurrentUser;
          int i = MesevenementreserverController.id2;

              feedbackevent com = new feedbackevent(user.getId(), i, ki, kii);
            feedbackeventservice pdao = feedbackeventservice.getInstance();
            pdao.insert(com);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("feddback insérée avec succés!");
        alert.show();
                idcomm.setText("");
                
                              
      
    }
    
    
     @FXML
  private void insertcomm (ActionEvent event) throws ClassNotFoundException,SQLException{
         
   
         Utilisateur user = LoginFXMLController.CurrentUser;
          int i = MesevenementreserverController.id2;

              commentevenement com = new commentevenement(user.getId(),i,idcomm.getText());
            commentevenementService pdao = commentevenementService.getInstance();
            pdao.insert(com);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("comment insérée avec succés!");
        alert.show();
                idcomm.setText("");
                
                              
      
    }
  
       @FXML
  private void modifcomm (ActionEvent event) throws ClassNotFoundException,SQLException{
         
           System.out.println(idc);
              commentevenement com = new commentevenement(textmodif.getText(), idc);
            commentevenementService pdao = commentevenementService.getInstance();
            pdao.update(com);
              textmodif.setVisible(false);
        modifco.setVisible(false);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("comment modf avec succés!");
        alert.show();
               
                
                              
      
    }
    
    
    
   participation_evenementService k = new participation_evenementService(); 
    private  List <participation_evenement>  event = k.displayAll();
     
    public boolean  recherche (participation_evenement pn) {
    
    return event.contains(pn);
    }
    
   likeevenementService l = new likeevenementService();
   private List<likeevenement> lik = l.displayAll();


 public boolean  recherchelike (likeevenement like) {
    
    return lik.contains(like);
    }
    public boolean  recherchedislike (likeevenement dislike) {
    
    return lik.contains(dislike);
    }
   
 
  @FXML
    public void likeButton(ActionEvent event) throws ClassNotFoundException,SQLException{
   
         int i = MesevenementreserverController.id2;

       Evenement p = new Evenement();
   EvenementService s = new EvenementService();
    p = s.displayById(i); 
  int nblik = p.getNbrlikes();
  int nbdislik = p.getNbrdislikes();

    Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
          likeevenement like1 = new likeevenement(user.getId(), i, "like");
           likeevenement dislike1 = new likeevenement(user.getId(), i, "dislike");
          likeevenementService likeser = likeevenementService.getInstance();
  if (recherchelike(like1) == true )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("déja aimer");
        alert.show();
      
  }
  
  else if ( recherchedislike(dislike1) == true ) {
      likeser.update(like1);
      Evenement p1 = new Evenement(i, nblik+1, nbdislik-1);
      s.updatenbdislike(p1);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("kount disklike walit like");
        alert.show();
      
  }
  else {
 likeser.insert(like1);  
    Evenement p1 = new Evenement(i, nblik+1, nbdislik);
      s.updatenbdislike(p1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("like avec succés!");
        alert.show();
  }     
    }
     @FXML
    public void dislikeButton(ActionEvent event) throws ClassNotFoundException,SQLException{
        int i = MesevenementreserverController.id2;

        Evenement p = new Evenement();
   EvenementService s = new EvenementService();
    p = s.displayById(i); 
  int nblik = p.getNbrlikes();
  int nbdislik = p.getNbrdislikes();

    Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
          likeevenement like1 = new likeevenement(user.getId(), i, "like");
           likeevenement dislike1 = new likeevenement(user.getId(), i, "dislike");
          likeevenementService likeser = likeevenementService.getInstance();
  if (recherchedislike(dislike1) == true )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("déja ne aimer");
        alert.show();
      
  }
  
  else if ( recherchelike(like1) == true ) {
      likeser.update(dislike1);
      Evenement p1 = new Evenement(i, nblik-1, nbdislik+1);
      s.updatenbdislike(p1);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("kount like walit dislike");
        alert.show();
      
  }
  else {
 likeser.insert(dislike1);  
    Evenement p1 = new Evenement(i, nblik, nbdislik+1);
      s.updatenbdislike(p1);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("dislike avec succés!");
        alert.show();
              
                           
  }           
                           
  }     
  
 
  
    
     public Node ListEvent() throws SQLException {

        VBox root0 = new VBox(20);
        HBox H0 = new HBox(10);
        VBox V2 = new VBox(10);
           commentevenementService comser = new commentevenementService();
      int in = MesevenementreserverController.id2;
        Utilisateur user = LoginFXMLController.CurrentUser;
        int id50 = user.getId();
         
  ArrayList<commentevenement> cm =(ArrayList<commentevenement> )comser.affcom(in);
 ObservableList OB = FXCollections.observableArrayList(cm);
//////        ObservableList<commentevenement> OB = FXCollections.observableArrayList();
//////         OB = (ObservableList<commentevenement>) comser.affcom(in);
//////         
           
        
    //     System.err.println(OB1);
        for (int i = 0; i < OB.size();i++) {
            HBox root = new HBox(10);
            root.setAlignment(Pos.CENTER_LEFT);
            root.setStyle("-fx-Border-color:  #2471A3");
            root.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));

            commentevenement evt = (commentevenement) OB.get(i);
            UtilisateurService ut = new UtilisateurService();
                  Utilisateur u = new Utilisateur();
     
             u = ut.displayByimg(evt.getUser_id().getId());
               System.out.println(u.getUsername());
            System.out.println(u.getImg());
          //  Evenement evt1 = OB.get(i+1);
         //   Evenement e = new Evenement(evt.)
    //   int id2 = evt.getIdevenement();
       
      //      System.out.println(evt.getNomimage());
          //  affiche image
            File file = new File("../../../images/" + u.getImg());
//            Image image = new Image(file.toURI().toString());
              Image img = new Image(getClass().getResource("../../../images/"+u.getImg()).toExternalForm());
                      //    ImageView imgv = new ImageView(img);
            ImageView IMG = new ImageView(img);
            IMG.fitHeightProperty().set(80);
            IMG.fitWidthProperty().set(70);
            IMG.preserveRatioProperty().set(true);
 Separator sep = new Separator(Orientation.VERTICAL);
            VBox root2 = new VBox(6);
            root2.prefWidthProperty().set(80);
            root2.prefHeightProperty().set(70);
            root2.setPadding(new javafx.geometry.Insets(4, 4, 4, 4));

            //les information de evene
            //*****titre
            Label Name = new Label(evt.getComment());
            Name.setFont(new javafx.scene.text.Font("Arial", 14));
            Name.setTextFill(Color.web("#17202A"));
           
           
       Label nom = new Label(u.getUsername());
            nom.setFont(new javafx.scene.text.Font("Arial", 12));
            nom.setTextFill(Color.web("#17202A"));
//         

 Separator sep3 = new Separator(Orientation.VERTICAL);

  Menu menu = new Menu ("mod");

MenuItem choice1Item = new MenuItem ("modifier 1");
MenuItem choice2Item = new MenuItem ("supprimer 2");
//ToggleGroup toggleGroup = new ToggleGroup ();
//toggleGroup.getToggles (). add (choice1Item);
//toggleGroup.getToggles (). add (choice2Item);
menu.getItems (). addAll (choice1Item , choice2Item);
//menu.getItems (). add (choice2Item);
MenuBar menuBar = new MenuBar ();
menuBar.getMenus (). add (menu);
//     
//
//                          
       idc = evt.getIdcomment();
                          System.out.println(idc);
       commentevenement cn = new commentevenement(idc);
         commentevenement cn1 = new commentevenement(idc);
       choice1Item.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        comser.delete(cn);  
      }   }); 
  choice2Item.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
              textmodif.setVisible(true);
        modifco.setVisible(true);
      textmodif.setText(evt.getComment());
      
      }   }); 
////                          System.out.println(" , ");
////                          
////                          Utilisateur u = new Utilisateur(nomcomevenement.getUser_id().getId());
////                              UtilisateurService ud2= new UtilisateurService();
////                              ud2.login2(nomcomevenement.getUser_id().getId());
////                          System.out.println(u.getId());
////         setText(nomcomevenement.getUser_id().getUsername()+" :");                 
//        setText(nomcomevenement.getComment());
//       //
      //   Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
       int k = evt.getUser_id().getId();
       int l = user.getId();
//                          System.out.println(k);
//                          System.out.println(l);
//       if (k == l ) {
//       setGraphic(menuBar); }




            root2.getChildren().addAll(nom,Name);
            root2.setId(String.valueOf(evt.getIdcomment()));
//       
 if (k == l ) {

            root.getChildren().addAll( IMG , sep, root2,sep3 ,menuBar );

 }
 else {            root.getChildren().addAll( IMG , sep, root2 );
}
    

            root0.getChildren().add(root);
            root0.setPrefSize(820, 700);
            root0.setPadding(new javafx.geometry.Insets(0, 0, 0, 0));

        }
        return root0;

    }

    
    
}