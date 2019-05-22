/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Evenement;
import com.wf.entity.Pub;
import com.wf.service.EvenementService;
import com.wf.service.PubService;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AfficherPubController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView imageprecedent;
    @FXML
    private ImageView imagesuivant;
 private static int a,b,c,d,e,f,i;   
 private static int nbrpage=1;
    @FXML
    private Label label;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    
    private Label NumPaga;
    
    public static int idp;
    public static float pr;
    public static String n;
    public static String cat;
    public static String desc;
    public static int id;
    private Label label1;
    @FXML
    private Label label41;
    @FXML
    private Label label21;
    @FXML
    private Label label51;
    @FXML
    private Label label31;
    @FXML
    private Label label61;
    @FXML
    private Label label11;
    @FXML
    private JFXButton ajoutpub;
    @FXML
    private JFXButton mespub;
    @FXML
    private JFXButton pubprofite;
    @FXML
    private JFXButton retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        afficher();
//        détails.setDisable(true);

//       
   a=0;b=1;c=2;d=3;e=4;f=5;
             imageprecedent.setVisible(false);
        try {
            buildData();
//                   try {
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
        }

            
           
//         ServiceCategorie sucat = ServiceCategorie.getInstance();
           int j =0;
//       
//      
//             ResultSet res = sucat.affichercategories();
//            while(res.next()){
//                
//                Categorie c = new Categorie();
//                c.setId_categorie(res.getInt("id_categorie"));
//                c.setTitre(res.getString("titre"));
//                c.setDescription(res.getString("description"));
//             
//                      switch (j) {
//                     case 0:
//                         button2.setText("Musique");
//                       
//                         break;
//                     case 1:
//                          button3.setText("Sport");
//                       
//                         break;
//                     case 2:
//                          button4.setText("Camping");
//                      
//                         break;
//                     case 3:
//                          button5.setText("Jeux Vidéo");
//                  
//                         break;
//                     case 4:
//                          button6.setText("aaaa");
//              
//                         break;
//  
//                     default:
//                         break;
//                 }
//               
              j++;
       
              
              
              
               pubprofite.setOnAction(event -> {
        
   
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/MesPubProfit.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   });   
               
              
                  mespub.setOnAction(event -> {
        
   
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/pubajout.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   });  
          retour.setOnAction(event -> {
        
   
        
    
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Accueil.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   });
            }
////           
////
////        } catch (SQLException ex) {
////            Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
////        }
    
public void buildData() throws SQLException
{
        label11.setVisible(false);
        image1.setVisible(false);
        label21.setVisible(false);
        image2.setVisible(false);
        label31.setVisible(false);
        image3.setVisible(false);
        label41.setVisible(false);
        image4.setVisible(false);
       label51.setVisible(false);
        image5.setVisible(false);
        label61.setVisible(false);
        image6.setVisible(false);
               ResultSet rs; 
            i = 0;
          PubService su = PubService.getInstance();
           
          
           // Produit u = new Produit();
           //ObservableList<Produit>list =FXCollections.observableArrayList();
                  rs =su.afficherPub1();
           
    ObservableList<Pub>list =FXCollections.observableArrayList();
           
        try {
            while(rs.next())
            {
              
                Pub p = new Pub();
                
                p.setIdpublicite(rs.getInt(1));
                p.setNompublicite(rs.getString("nompublicite"));
                p.setContenupublicte(rs.getString("contenupublicte"));
                 p.setNomimage(rs.getString("nomimage"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                   p.setPoint(rs.getInt("point"));
                    p.setPrixproduit(rs.getFloat("prixproduit"));
                     p.setPrixremise(rs.getFloat("prixremise"));
                     p.setNbrprofit(rs.getInt("nbrprofit"));
                      p.setDatepublicite(LocalDate.parse(rs.getString("datepublicite"), DateTimeFormatter.ISO_DATE) );
                    
                
                     
            //         p.setDatefin(LocalDate.parse(rs.getString("datefin"), DateTimeFormatter.ISO_DATE) );
                
              
                
                if (i == a) {
                   
                        label.setVisible(true);
                        label.setText(p.getNompublicite());//+"\n"+u.getPrix()+"Dt");
                        image1.setVisible(true);
                        label11.setText(Integer.toString(p.getIdpublicite()));
                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        Image img=new Image(pathimage);
                        image1.setImage(img);
                        idp=p.getIdpublicite();
                        System.out.println("1  "+idp);
                }
                else if(i == b){
                       label2.setVisible(true);
                       label2.setText(p.getNompublicite());
                                               label21.setText(Integer.toString(p.getIdpublicite()));

                        image2.setVisible(true);
                       String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        Image img=new Image(pathimage);
                        image2.setImage(img);
                         idp=p.getIdpublicite();
                        System.out.println("2  "+idp);
                }
                    else if(i == c){
                        image3.setVisible(true);                        
                       label3.setText(p.getNompublicite());
                                               label31.setText(Integer.toString(p.getIdpublicite()));

                       String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        System.out.println("nom"+p.getNomimage());           
                        System.out.println(p.getIdpublicite());
                        Image img=new Image(pathimage);
                        image3.setImage(img);
                                }
                      else if(i == d){
                        image4.setVisible(true);                        
                        label4.setText(p.getNompublicite());
                                                label41.setText(Integer.toString(p.getIdpublicite()));

                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        Image img=new Image(pathimage);
                        image4.setImage(img);
//                      
                      }
                   else if(i == e){
                        image5.setVisible(true);
                        label5.setText(p.getNompublicite());       
                                                label51.setText(Integer.toString(p.getIdpublicite()));

                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        Image img=new Image(pathimage);

                        image5.setImage(img);
                       }
                     else if(i == f){
                        image6.setVisible(true);   
                        label6.setText(p.getNompublicite());
                                                label61.setText(Integer.toString(p.getIdpublicite()));

                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                        Image img=new Image(pathimage);
                        image6.setImage(img);
 
                }
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
        }
      //   NumPaga.setStyle("bold");
             //   NumPaga.setText("Page "+nbrpage);
                //nbrpage++;
                
              
    }
@FXML
    private void suivant(MouseEvent event) throws SQLException {
 a=a+6;b=b+6;c=c+6;d=d+6;e=e+6;f=f+6;
         imageprecedent.setVisible(true);
            buildData();
                 if (b == i || a == i || c == i || d == i|| e == i || f == i)
        {
            imagesuivant.setVisible(false);
        }
            
            
    }
    @FXML
    private void precedent(MouseEvent event) throws SQLException {
 a=a-6;b=b-6;c=c-6;d=d-6;e=e-6;f=f-6;
 imagesuivant.setVisible(true);
       
 if (a == 0)
        {
            imageprecedent.setVisible(false);
        }
            buildData();
    }

    @FXML
    private void AfficheMoi1(MouseEvent event) {
        PubService ps =PubService.getInstance();
        //Produit p = ps.displayById(id)
        //System.out.println(idp);
        System.out.println(label.getText());
        String k =label.getText();
        System.out.println(label11.getText());
        int b =Integer.parseInt(label11.getText());
       
        Pub p =ps.displayById(b);
        //EspaceProduitController.id=idp;
       System.out.println(p);
               // System.out.println(p1);

        idp=p.getIdpublicite();
        System.out.println(idp);
//        pr=p.getPrix();
//        n=p.getNomproduit();
//        System.out.println("ll"+n);
//        cat=p.getCategorie();
////        desc=p.getDescriptionproduit();
//        EspaceProduitController.pathimage="/images/"+p.getNomimage();
//       Image img ;
//       EspaceProduitController.img=new Image(pathimage);
//        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffPub.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void AfficheMoi2(MouseEvent event) {
        PubService ps =PubService.getInstance();
//        Evenement p =ps.displayById(Integer.parseInt(label21.getText()));
    int b =Integer.parseInt(label21.getText());
       
        Pub p =ps.displayById(b);
        idp=p.getIdpublicite();
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffPub.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi3(MouseEvent event) {
       PubService ps =PubService.getInstance();    
                Pub p =ps.displayById(Integer.parseInt(label31.getText()));

         idp=p.getIdpublicite();
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffPub.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi4(MouseEvent event) {
       PubService ps =PubService.getInstance();    
       
      //  Evenement p =ps.displayById(Integer.parseInt(label41.getText()));
          int b =Integer.parseInt(label41.getText());
       
        Pub p =ps.displayById(b);
          idp=p.getIdpublicite();

         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Affpub.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi5(MouseEvent event) {
       PubService ps =PubService.getInstance();    
        //      Evenement p =ps.displayById(Integer.parseInt(label51.getText()));
    int b =Integer.parseInt(label51.getText());
       
        Pub p =ps.displayById(b);
  idp=p.getIdpublicite();
       
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AffPub.fxml"));
                Scene scene = new Scene(page1);          
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi6(MouseEvent event) {
       PubService ps =PubService.getInstance();    
       //         Evenement p =ps.displayById(Integer.parseInt(label61.getText()));
    int b =Integer.parseInt(label61.getText());
       
       Pub p =ps.displayById(b);
       idp=p.getIdpublicite();
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Affpub.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPubController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
       
    
}

