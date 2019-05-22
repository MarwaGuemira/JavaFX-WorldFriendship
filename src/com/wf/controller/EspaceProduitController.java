                                                                                                            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.FavoriteProduit;
import com.wf.entity.Produit;
import com.wf.entity.Utilisateur;
import com.wf.entity.commentaireproduit;
import com.wf.service.CommentaireService;
import com.wf.service.FavoriteProdService;
import com.wf.service.ProduitService;
import com.wf.service.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EspaceProduitController implements Initializable {

    @FXML
    private Button addfavorite;
    @FXML
    private Button btnAcceuil;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnMonEspace;
    @FXML
    private ImageView idimage;
    private ToggleButton reaction;
    private Label Nom;
    private Label Prix;
    private Label d;
    private Label cat;
    public static int id;
    public static String pathimage;
    public static Image img;
    @FXML
    private Label Prixp;
    @FXML
    private Label desc;
    @FXML
    private Label categorie;
    @FXML
    private Label No;
    private Button affcom;
    @FXML
    private ListView<commentaireproduit> lv;
    @FXML
    private TextArea idtextarea;
  public static int  idprod;
    @FXML
    private ImageView idicone;
    @FXML
    private GridPane gird;
    
    public static int nb=0;
    @FXML
    private Label photo;
    @FXML
    private Label com;
    @FXML
    private Label nomuser;
    @FXML
    private Label txtAjoutCom;
    @FXML
    private Label idaffichertxt;
    @FXML
    private ImageView mail;
    @FXML
    private Label m;
    @FXML
    private Label s;
    @FXML
    private TextField txtcontenu;
    @FXML
    private Button btnmodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lv.setVisible (false);
                     idtextarea.setVisible(false);
                     idicone.setVisible(false);
photo.setVisible(false);
com.setVisible(false);
nomuser.setVisible(false);
txtAjoutCom.setVisible(false);
 btnmodif.setVisible(false);
          txtcontenu.setVisible(false);
         btnMonEspace.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficherProduit.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
           btnRetour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/EspaceVente.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
 
     Produit p= new Produit();
 ProduitService s = new ProduitService();
  int id=EspaceVenteController.idp;
 p=s.displayById(id);
 
        System.out.println("    nom p " +p.getNomproduit());
// No.setText(p.getNomproduit());
 LocalDateTime today= LocalDateTime.now();
 LocalDateTime  datemisevente=p.getDatemisevente();
        System.out.println("               "+datemisevente); 
        
        
// long diff = ChronoUnit.DAYS.between(datemisevente, today);
      //  System.out.println("     abcd     = " +diff);
   


//if(diff>=30)
//{float newp;
//            newp = (float) (p.getPrix()-(p.getPrix()*0.1));
//    s.Modifierprix(id,newp);
//    
//}
//else
//{
// Prixp.setText(Integer.toString((int)p.getPrix() ));
//}


//         
//              System.out.println(newp);
//              Prixp.setText(Float.toString(newp));
//           
//        }
//        else 
//        {
//        
//
//        }


  categorie.setText(p.getCategorie());
desc.setText(p.getDescriptionproduit());
pathimage= "/images/"+p.getNomimage();
 img=new Image(pathimage);
idimage.setImage(img);


    }

    @FXML
    private void AddToFavorite(ActionEvent event) {
    
        
         id=AfficherProduitController.id;
         Utilisateur user = LoginFXMLController.CurrentUser;
         System.out.println(user+"        "+id);
                FavoriteProduit fp = new FavoriteProduit(1,id);
            FavoriteProdService pdao = FavoriteProdService.getInstance();
       
//        ArrayList favp = ArrayList();
//       
//        if(favp.stream().forEach(cnsmr))
     if (pdao.proddisplayById(id,1))
     {
//  Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Produit déjà inséré !! ");    
         addfavorite.setText("Déjà inséré");
        
     }
     
     else
     { int id1=EspaceVenteController.idp;
         pdao.Ajouter(2, id1);
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Produit insérée avec succés!! dans votre favoris");
        alert.show();
        addfavorite.setText("Déjà inséré");
     }
        
    }

    @FXML
    private void AfficherCommentaire(MouseEvent event) throws SQLException {
        idaffichertxt.setVisible(false);
        photo.setVisible(true);
com.setVisible(true);
nomuser.setVisible(true);
        idtextarea.setVisible(true);
 idicone.setVisible(true);
 m.setVisible(true);
 s.setVisible(true);
 

//txtAjoutCom.setVisible(true);
        Comm();
          }
//         else{
//            lv.setVisible (false);
//
//           Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Ce Produit n'est pas négociable");
//        alert.show();
//          
//       }
         
        public void Comm() throws SQLException
        {
            Utilisateur bhim=LoginFXMLController.CurrentUser;
        int iduu=bhim.getId();
        ProduitService ps=ProduitService.getInstance();
//          System.out.println("aa"+id);
//     Produit p =ps.displayById(id);
//     
idprod=EspaceVenteController.idp;
Produit p =ps.displayById(idprod);
String ch =p.getEtat();
       if(ch.equals("Oui"))
         {photo.setVisible(true);

             txtAjoutCom.setVisible(true);

           idtextarea.setVisible(true);
         //  com.setVisible(false);
//nomuser.setVisible(false);
txtAjoutCom.setVisible(false);
idicone.setVisible(true);
//
          CommentaireService cs =CommentaireService.getInstance();
//        System.out.println(" = "+idprod);
//       
         ResultSet r =  cs.AfficherAll(idprod);
       // lv.setItems(observableList);
        
            while(r.next()){
              int i=0;
                commentaireproduit u = new commentaireproduit();
             
                //u.setId_categorie(r.getInt("categorie_id_categorie"));
     
                u.setIdcommentaire(r.getInt("idcommentaire"));
                u.setId_produit(r.getInt("Id_produit"));
                u.setUser_id(r.getInt("user_id"));
                u.setContenu(r.getString("contenu"));
                
        GridPane x=new GridPane();
        ImageView photo=new ImageView();
        photo.setFitHeight(30);
 photo.setFitWidth(30);
 String nn="profil-icone.png";
 int iduser=u.getUser_id().getId();
 UtilisateurService us= new UtilisateurService();
 Utilisateur user=new Utilisateur();
 user=us.displayByimg(u.getUser_id().getId());
                System.out.println(user.getImg());
 String path= "http://localhost/PIDev_WorldFriendship/web/images/"+user.getImg();
                System.out.println(path);
  Image img1=new Image(path);
 
  photo.setImage(img1);
  Label txt=new Label();
  txt.setText(u.getContenu());
                System.out.println(txt.getText());
                Label txt1=new Label();
                txt.setStyle("bold");
                txt1.setText(txt.getText());
         txt1.setStyle("bold");
         Label nom=new Label();
         nom.setText(user.getUsername());
         ImageView photo1=new ImageView();
         photo1.setFitHeight(20);
 photo1.setFitWidth(20);
         String path1= "http://localhost/PIDev_WorldFriendship/web/images/modif.png";
         Image imp =new Image(path1);
         photo1.setImage(imp);
         photo1.setOnMouseClicked((event) -> {
             txtcontenu.setVisible(true);
             btnmodif.setVisible(true);
             //u.setContenu(txtcontenu.getText());
             
    //private Button btnmodif;
         });
         
         btnmodif.setOnMouseClicked((event) -> {
             gird.getColumnConstraints();
                 //u.setContenu(txtcontenu.getText());
                // Utilisateur bhim=LoginFXMLController.CurrentUser;
        //int iduu=bhim.getId();
        //  idprod=EspaceProduitControllerController.idp;
        
               
                  try {
                     int  idcom =   cs.idcommmmm(idprod, iduu, u.getContenu());
                        System.out.println(idcom);
                               cs.ModifierComm(idcom, iduu, txtcontenu.getText());
                  } catch (SQLException ex) {
                      Logger.getLogger(EspaceProduitController.class.getName()).log(Level.SEVERE, null, ex);
                  }
       txtcontenu.setText("");
         });
         ImageView photo2=new ImageView();
         photo2.setFitHeight(20);
 photo2.setFitWidth(20);
         String path2= "http://localhost/PIDev_WorldFriendship/web/images/supp.png";
         Image imp2 =new Image(path2);
         photo2.setImage(imp2);
    GridPane.setConstraints(photo , 0, nb+1+i, 1, i+1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(nom , 1, nb+1+i, 1, i+1, HPos.CENTER, VPos.CENTER);
        GridPane.setConstraints(txt1, 2, nb+1+i, 1, i+1, HPos.CENTER, VPos.BOTTOM);
      GridPane.setConstraints(photo1, 3, nb+1+i, 1, i+1, HPos.CENTER, VPos.BOTTOM);
  GridPane.setConstraints(photo2, 4, nb+1+i, 1, i+1, HPos.CENTER, VPos.BOTTOM);

    gird.getChildren().addAll(photo);
        gird.getChildren().addAll(nom);

    gird.getChildren().addAll(txt1);
    
    
            gird.getChildren().addAll(photo1);

    gird.getChildren().addAll(photo2);
    photo1.setVisible(false);
    photo2.setVisible(false);
    
    if(u.getUser_id().getId()== iduu)
    {
        photo1.setVisible(true);
    photo2.setVisible(true);
    
    
    }
      
   
    nb++;
            }
           
         }
       else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ce Produit n'est pas négociable");
      alert.show();
            }
        
    
       
        }


        
       
       


    @FXML
    private void AddnewCommentaire(MouseEvent event) throws SQLException {
       
           Utilisateur bhim=LoginFXMLController.CurrentUser;
        int iduu=bhim.getId();
          idprod=EspaceVenteController.idp;
         
          CommentaireService cs =CommentaireService.getInstance();
         
        
       cs.AjouterComm(idprod, iduu, idtextarea.getText());
       idtextarea.setText("");
        
       //affcom.setVisible(true);
       //Comm();
      
         
    }

    @FXML
    private void ToMail(MouseEvent event) {
        
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/Mail.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void sendMail(MouseEvent event) {
         
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/SMS.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceVenteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}

