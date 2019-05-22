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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
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
public class AffichageEvent5Controller implements Initializable {
 private ListData listdata = new ListData();
  
int idc ;
    @FXML
    private Label nomLabel;
    @FXML
    private Label descLabel;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField idcomm;
    @FXML
    private JFXTextField textmodif;
    @FXML
    private JFXButton modifco;
    @FXML
    private ImageView imageview;
    @FXML
    private Label idpayst;
    @FXML
    private JFXDatePicker iddebutfin;
    @FXML
    private JFXDatePicker iddebut;
    @FXML
    private Label idregion;
    @FXML
    private Label idadresse;
    @FXML
    private Label idnbrpr;
    @FXML
    private Label nbrlike;
    @FXML
    private Label nbrdislike;
    @FXML
    private ScrollPane pane;
    @FXML
    private JFXButton btpart;
    @FXML
    private JFXButton btreaction;
   @FXML
    private ListView<Utilisateur> list1;
    @FXML
    private ListView<Utilisateur> list2;
    @FXML
    private JFXButton statbtn;
    @FXML
    private PieChart stat;
ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    /**
     * Initializes the controller class.
     */
           

    
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        list1.setVisible(false);
        list2.setVisible(false);
        textmodif.setVisible(false);
        modifco.setVisible(false);
        stat.setVisible(false);
        
          EvenementService pdao=EvenementService.getInstance();
        List<Evenement> eves=pdao.displayAllList();
        for(Evenement e:eves) {
            list.addAll(
                new PieChart.Data(e.getPays(), 12.0)             
        );
        }
        stat.setAnimated(true);
        stat.setData(list);
        
        
       try {
           UtilisateurService ud= new UtilisateurService();
       } catch (SQLException ex) {
           Logger.getLogger(AffichageEvent1Controller.class.getName()).log(Level.SEVERE, null, ex);
       }
         int i = MeseventpasserController.id2;
           Evenement p = new Evenement();
   EvenementService s = new EvenementService();

  
   participation_evenementService se = new participation_evenementService();
   
    List< participation_evenement> pe = se.displayAll();
       ObservableList<Utilisateur> OB2 = FXCollections.observableArrayList();
         ObservableList<String> OB3 = FXCollections.observableArrayList();
     
         
        
         for (participation_evenement ee : pe){
             System.out.println(    ee.getUser_id().getId());
             if ( ee.getEven_id().getIdevenement()==i){
            OB3.add(Integer.toString(ee.getUser_id().getId()));}
         }
      
         for (String ob :OB3){
        UtilisateurService ud = null;
            try {
                ud = new UtilisateurService();
            } catch (SQLException ex) {
                Logger.getLogger(AffichageEvent4Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
               Utilisateur k = new Utilisateur();
             k = ud.displayByimg(Integer.parseInt(ob));
           
             
         OB2.add(k);
         
         }
         
    p = s.displayById(i); 
      System.out.println("lol");
    p.getIdevenement();
    System.out.println(OB3);
    
    System.out.println("kk");
    System.out.println(OB2);
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
          
           
        list1.setCellFactory(new Callback<ListView<Utilisateur>, ListCell<Utilisateur>>() {
           @Override
           public ListCell<Utilisateur> call(ListView<Utilisateur> param) {
               ListCell<Utilisateur> cell = new ListCell<Utilisateur>(){
                  @Override
                  protected void  updateItem(Utilisateur nomeuser, boolean btl1){
                      super.updateItem(nomeuser, btl1);
                      if(nomeuser!=null){
                          Image img = new Image(getClass().getResource("../../../images/"+nomeuser.getImg()).toExternalForm());
                          ImageView imgv = new ImageView(img);
                          imgv.setFitHeight(100);
                          imgv.setFitWidth(100);
                          imgv.setPreserveRatio(true);
                          setGraphic(imgv);
//                         
       //setText(nomevenement.getNomimage());
        setText(nomeuser.getNom());
       setText(nomeuser.getUsername());
                      }
                  }
               };
               return cell;

                       }}) ;
         
      list1.setItems( OB2);
      
      
      
      
      
      
   likeevenementService le = new likeevenementService();
   
    List< likeevenement> le1 = le.displayAll();
       ObservableList<Utilisateur> OB4 = FXCollections.observableArrayList();
         ObservableList<String> OB5 = FXCollections.observableArrayList();
     
         
        
         for (likeevenement ee : le1){
           //  System.out.println(    ee.getUser_id().getId());
             if ( ee.getEven_id()==i){
            OB5.add(Integer.toString(ee.getUser_id())); }
         }
      
         for (String ob :OB5){
        UtilisateurService ud = null;
            try {
                ud = new UtilisateurService();
            } catch (SQLException ex) {
                Logger.getLogger(AffichageEvent4Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
               Utilisateur k = new Utilisateur();
             k = ud.displayByimg(Integer.parseInt(ob));
           
             
         OB4.add(k);
         
         }
         
//    p = s.displayById(i); 
//      System.out.println("lol");
//    p.getIdevenement();
//    System.out.println(OB3);
//      
      
      
      
       list2.setCellFactory(new Callback<ListView<Utilisateur>, ListCell<Utilisateur>>() {
           @Override
           public ListCell<Utilisateur> call(ListView<Utilisateur> param) {
               ListCell<Utilisateur> cell1 = new ListCell<Utilisateur>(){
                  @Override
                  protected void  updateItem(Utilisateur nomeuser1, boolean btl12){
                      super.updateItem(nomeuser1, btl12);
                      if(nomeuser1!=null){
                          Image img = new Image(getClass().getResource("../../../images/"+nomeuser1.getImg()).toExternalForm());
                          ImageView imgv = new ImageView(img);
                          imgv.setFitHeight(100);
                          imgv.setFitWidth(100);
                          imgv.setPreserveRatio(true);
                          setGraphic(imgv);
//                         
       //setText(nomevenement.getNomimage());
        setText(nomeuser1.getNom());
       setText(nomeuser1.getUsername());
                      }
                  }
               };
               return cell1;

                       }}) ;
         System.out.println("no"+OB4);
      list2.setItems( OB4);
      
      
//       ObservableList<Evenement> evee = listdata.getUsers();
//        for (Evenement e : evee) {
   
        
       // }
     int in = MeseventpasserController.id2;
        
       
        participation_evenementService pk = new participation_evenementService();
          ArrayList<participation_evenement> cm =(ArrayList<participation_evenement> )pk.cherchereve(in);
 ObservableList OB = FXCollections.observableArrayList(cm);
      ObservableList<Utilisateur> util = FXCollections.observableArrayList();
        for (participation_evenement k : cm) {
   k.getUser_id();
        
        }
  
     // list1.setItems( listdata.getUsers());
      
  
        try {
            
            pane.setContent(ListEvent());
        } catch (SQLException ex) {
            Logger.getLogger(AffichageEvent1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
    
    
    
    
    

// TODO
        retour.setOnAction(event2 -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Meseventactuel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });  
        
        btpart.setOnAction(event3 -> {
     list2.setVisible(false);
            list1.setVisible(true);
            stat.setVisible(false);
        });    
        btreaction.setOnAction(event4 -> {
       list2.setVisible(true);
            list1.setVisible(false);
              stat.setVisible(false);
        });   
  
        
           statbtn.setOnAction(event4 -> {
       list2.setVisible(false);
            list1.setVisible(false);
              stat.setVisible(true);
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
        int i = MeseventpasserController.id2;

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
   
      int i = MeseventpasserController.id2;

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
       int i = MeseventpasserController.id2;

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
     int in = MeseventpasserController.id2;
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