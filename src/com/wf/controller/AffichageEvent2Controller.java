/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Evenement;
import com.wf.entity.Utilisateur;
import com.wf.entity.commentevenement;
import com.wf.entity.likeevenement;
import com.wf.entity.participation_evenement;
import com.wf.service.EvenementService;
import com.wf.service.UtilisateurService;
import com.wf.service.commentevenementService;
import com.wf.service.likeevenementService;
import com.wf.service.participation_evenementService;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AffichageEvent2Controller implements Initializable {

     private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label descLabel;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField idcomm;
    @FXML
    private ListView<commentevenement> listcomm;
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
    @FXML
    private Label idnbrtot;
    @FXML
    private Label idnbrpr;
    @FXML
    private Label nbrlike;
    @FXML
    private Label nbrdislike;
    @FXML
    private JFXButton participer;
    @FXML
    private JFXButton annuler;
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
        participer.setVisible(false);
       try {
           UtilisateurService ud= new UtilisateurService();
       } catch (SQLException ex) {
           Logger.getLogger(AffichageEvent1Controller.class.getName()).log(Level.SEVERE, null, ex);
       }
         int i = AfficheEvenementsController.id2;
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
                  idnbrtot.setText(Integer.toString(p.getNbrplacestotal()));
           String imagepath = "/images/"+p.getNomimage();
           Image image = new Image(imagepath);
           imageview.setImage(image);
          Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
          
           
           commentevenementService comser = new commentevenementService();
   
           listcomm.setCellFactory(new Callback<ListView<commentevenement>, ListCell<commentevenement>>() {
           @Override
           public ListCell<commentevenement> call(ListView<commentevenement> param) {
               ListCell<commentevenement> cell = new ListCell<commentevenement>(){
                  @Override
                  protected void  updateItem(commentevenement nomcomevenement, boolean btl1){
                      super.updateItem(nomcomevenement, btl1);
                      if(nomcomevenement!=null){
                         
                          
                          
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
     

                          
       idc = nomcomevenement.getIdcomment();
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
      textmodif.setText(nomcomevenement.getComment());
      
      }   }); 
//                          System.out.println(" , ");
//                          
//                          Utilisateur u = new Utilisateur(nomcomevenement.getUser_id().getId());
//                              UtilisateurService ud2= new UtilisateurService();
//                              ud2.login2(nomcomevenement.getUser_id().getId());
//                          System.out.println(u.getId());
//         setText(nomcomevenement.getUser_id().getUsername()+" :");                 
        setText(nomcomevenement.getComment());
       //
         Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
       int k = nomcomevenement.getUser_id().getId();
       int l = user.getId();
                          System.out.println(k);
                          System.out.println(l);
       if (k == l ) {
       setGraphic(menuBar); }
                   }
                  }
               };
               return cell;

                       }}) ;
//           

 
            ArrayList<commentevenement> cm =(ArrayList<commentevenement> )comser.affcom(i);
 ObservableList obs = FXCollections.observableArrayList(cm);
        listcomm.setItems(obs);
     //  ObservableList<commentevenement> eventscom = (ObservableList<commentevenement>)comser.affcom(i);
//        
//listcomm.setItems( listdata.getcommeve());
   
  
    
    
    
    
    

// TODO
      retour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficheEvenements.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
  private void insertcomm (ActionEvent event) throws ClassNotFoundException,SQLException{
         
   
         Utilisateur user = LoginFXMLController.CurrentUser;
   int i = AfficheEvenementsController.id2;
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
    public void ParticiperButton(ActionEvent event) throws ClassNotFoundException,SQLException{
   
    int i = AfficheEvenementsController.id2;
    Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
  participation_evenement pn = new participation_evenement(user.getId(), i);
  participation_evenementService paj= participation_evenementService.getInstance(); 
  if (recherche(pn) == true )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("déja participer");
        alert.show();
      
  }
  
  else {
       Evenement p = new Evenement();
   EvenementService s = new EvenementService();
    p = s.displayById(i); 
  int nb = p.getNbrparticipants();
  int nbtotal = p.getNbrtickets();
  if (nbtotal == nb)
  {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Desolé pas de nombre de place ");
        alert.show();
  }
  else {
  Evenement p1 = new Evenement(p.getIdevenement(),nb+1 );
   EvenementService s1 = new EvenementService();
   s1.updatenbpar(p1);

        paj.insert(pn);
           
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
          participer.setVisible(false);
     annuler.setVisible(true);
              
  }                         
  }     
    }
    
     @FXML
    public void AnnulerrButton(ActionEvent event) throws ClassNotFoundException,SQLException{
   
    int i = AfficheEvenementsController.id2;
    Utilisateur user = new Utilisateur();
          user = LoginFXMLController.CurrentUser;
  participation_evenement pn = new participation_evenement(user.getId(), i);
  participation_evenementService paj= participation_evenementService.getInstance(); 
  if (recherche(pn) == false )
  {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("vous n'avez pas déja participer");
        alert.show();
      
  }
  
  else {
       Evenement p = new Evenement();
   EvenementService s = new EvenementService();
    p = s.displayById(i); 
  int nb = p.getNbrparticipants();
 
  Evenement p1 = new Evenement(p.getIdevenement(),nb-1 );
   EvenementService s1 = new EvenementService();
   s1.updatenbpar(p1);

            paj.delete(pn);
           
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("vous avez annuler  avec succés!");
        alert.show();
     participer.setVisible(true);
     annuler.setVisible(false);
                         
  }     
    }

  @FXML
    public void likeButton(ActionEvent event) throws ClassNotFoundException,SQLException{
   
  int i = AfficheEvenementsController.id2;
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
 int i = AfficheEvenementsController.id2;
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
  
 
    
}
