/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import static com.wf.controller.EspaceProduitController.pathimage;
import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EspaceVenteController implements Initializable {

    @FXML
    private Button détails;
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
    private Button button1;
   // private Button button5;
    @FXML
    private Button button4;
    @FXML
    private Button button3;
    @FXML
    private Button button2;
    @FXML
    private ImageView imageprecedent;
    @FXML
    private ImageView imagesuivant;
 private static int a,b,c,d,e,f,i;   
 private static int nbrpage=1;
    @FXML
    private Button button6;
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
    @FXML
    private Label NumPaga;
    
    public static int idp;
    public static float pr;
    public static String n;
    public static String cat;
    public static String desc;
    public static int id;
    @FXML
    private Button addproduit;
    @FXML
    private Button favoris;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        afficher();
//        détails.setDisable(true);
button1.setVisible(false);
button2.setVisible(false);
button3.setVisible(false);
button4.setVisible(false);
//button5.setVisible(false);
button6.setVisible(false);
détails.setVisible(false);


addproduit.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AjouterProduit.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
favoris.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceMyFavorite.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });



//       
   a=0;b=1;c=2;d=3;e=4;f=5;
             imageprecedent.setVisible(false);
        try {
            buildData();
//                   try {
        } catch (SQLException ex) {
            Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
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
                      switch (j) {
                     case 0:
                         button2.setText("Musique");
                       
                         break;
                     case 1:
                          button3.setText("Sport");
                       
                         break;
                     case 2:
                          button4.setText("Camping");
                      
                         break;
                     case 3:
                         // button5.setText("Jeux Vidéo");
                  
                         break;
                     case 4:
                          button6.setText("aaaa");
              
                         break;
  
                     default:
                         break;
                 }
               
              j++;
       
            }
////           
////
////        } catch (SQLException ex) {
////            Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
////        }
    
public void buildData() throws SQLException
{
        label.setVisible(false);
        image1.setVisible(false);
        label2.setVisible(false);
        image2.setVisible(false);
        label3.setVisible(false);
        image3.setVisible(false);
        label4.setVisible(false);
        image4.setVisible(false);
       label5.setVisible(false);
        image5.setVisible(false);
        label6.setVisible(false);
        image6.setVisible(false);
               ResultSet r; 
            i = 0;
          ProduitService su = ProduitService.getInstance();
           
          
           // Produit u = new Produit();
           //ObservableList<Produit>list =FXCollections.observableArrayList();
                  r =su.Afficher_All_Produit("Accépter");
           
    ObservableList<Produit>list =FXCollections.observableArrayList();
           
        try {
            while(r.next()){
              
                Produit u = new Produit();
             
                //u.setId_categorie(r.getInt("categorie_id_categorie"));
      u.setIdproduit(r.getInt("idproduit"));
u.setNomproduit(r.getString("nomproduit"));
                u.setNomimage(r.getString("nomimage"));
                u.setCategorie(r.getString("categorie"));
                u.setDescriptionproduit(r.getString("descriptionproduit"));
                u.setPrix(r.getFloat("prix"));
              
                
                if (i == a) {
                   
                        label.setVisible(true);
                     
                        label.setText(u.getNomproduit());//+"\n"+u.getPrix()+"Dt");
                          label.setStyle("bold");
                        image1.setVisible(true);
                        //label1.setText(u.getTitre());
                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+u.getNomimage();
                        Image img=new Image(pathimage);
                        image1.setImage(img);
                        idp=u.getIdproduit();
                        System.out.println("1  "+idp);
                }
                else if(i == b){
                       label2.setVisible(true);
                       label2.setText(u.getNomproduit());
                        image2.setVisible(true);
                       String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+u.getNomimage();
                        Image img=new Image(pathimage);
                        image2.setImage(img);
                         idp=u.getIdproduit();
                        System.out.println("2  "+idp);
                }
                    else if(i == c){
                        label3.setVisible(true);
                        image3.setVisible(true);                        
                        label3.setText(u.getNomproduit());
                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+u.getNomimage();
                        System.out.println("nom"+u.getNomimage());           
                        System.out.println(u.getIdproduit());
                        Image img=new Image(pathimage);
                        image3.setImage(img);
                                }
                      else if(i == d){
                        label4.setVisible(true);
                        image4.setVisible(true);                        
                        label4.setText(u.getNomproduit());
                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+u.getNomimage();
                        Image img=new Image(pathimage);
                        image4.setImage(img);
//                      
                      }
                   else if(i == e){
                        label5.setVisible(true);
                        image5.setVisible(true);
                        label5.setText(u.getNomproduit());                        
                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+u.getNomimage();
                        Image img=new Image(pathimage);
                        image5.setImage(img);
                       }
                     else if(i == f){
                        label6.setVisible(true);
                        image6.setVisible(true);   
                        label6.setText(u.getNomproduit());
                        String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+u.getNomimage();
                        Image img=new Image(pathimage);
                        image6.setImage(img);
 
                }
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
         NumPaga.setStyle("bold");
                NumPaga.setText("Page "+nbrpage);
                
                
              
    }
@FXML
    private void suivant(MouseEvent event) throws SQLException {
 a=a+6;b=b+6;c=c+6;d=d+6;e=e+6;f=f+6;
 nbrpage++;
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
       nbrpage--;
 if (a == 0)
        {
            imageprecedent.setVisible(false);
        }
            buildData();
    }

    @FXML
    private void AfficheMoi1(MouseEvent event) {
        ProduitService ps =ProduitService.getInstance();
        //Produit p = ps.displayById(id)
        //System.out.println(idp);
        Produit p =ps.displayByName(label.getText());
        //EspaceProduitController.id=idp;
        idp=p.getIdproduit();
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
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void AfficheMoi2(MouseEvent event) {
        ProduitService ps =ProduitService.getInstance();
        Produit p =ps.displayByName(label2.getText());
        idp=p.getIdproduit();
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi3(MouseEvent event) {
        ProduitService ps =ProduitService.getInstance();
        Produit p =ps.displayByName(label3.getText());
        idp=p.getIdproduit();
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi4(MouseEvent event) {
        ProduitService ps =ProduitService.getInstance();
       
        Produit p =ps.displayByName(label4.getText());
        idp=p.getIdproduit();

         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi5(MouseEvent event) {
        ProduitService ps =ProduitService.getInstance();
        Produit p =ps.displayByName(label5.getText());
        idp=p.getIdproduit();
       
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);          
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void AfficheMoi6(MouseEvent event) {
        ProduitService ps =ProduitService.getInstance();    
        Produit p =ps.displayByName(label6.getText());
        idp=p.getIdproduit();
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    


    
}
