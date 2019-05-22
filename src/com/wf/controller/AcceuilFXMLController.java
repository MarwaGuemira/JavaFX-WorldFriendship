/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import com.wf.service.CategorieDao;
import com.wf.service.PublicationDao;
import com.wf.service.UtilisateurDao;
import com.wf.entity.Categorie;
import com.wf.entity.Pays;
import com.wf.entity.Publication;
import com.wf.entity.Utilisateur;

/**
 * FXML Controller class
 *
 * @author nermi
 */
public class AcceuilFXMLController implements Initializable {

    @FXML
    private JFXButton profilBTN;
    @FXML
    private JFXComboBox<Categorie> categorieCB;
    @FXML
    private Label visibility;
    @FXML
    private JFXRadioButton publicRB;
    @FXML
    private JFXRadioButton privateRB;
    @FXML
    private JFXTextField titreTXT;
    @FXML
    private JFXTextArea contenuTXT;
    @FXML
    private ImageView ImageIV;
    @FXML
    private JFXButton ajoutBTN;
    @FXML
    private JFXButton ImageBTN;
    
    String ImagetoDB;
    @FXML
    private Pane globalPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCategorie();
        try {
            affichage();
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ToggleGroup group = new ToggleGroup();
        publicRB.setToggleGroup(group);
        privateRB.setToggleGroup(group);
        // TODO
    }    

    @FXML
    private void ProfilAction(ActionEvent event) throws IOException {
           profilBTN.getScene().setRoot(FXMLLoader.load(getClass().getResource("/pidev/v1/Views/ModifierCompteFXML.fxml")));
       
    }
     public void initCategorie(){
       CategorieDao cd= new CategorieDao();
       ObservableList<Categorie> options = 
        FXCollections.observableArrayList(
                cd.ListCategories()
        );
        categorieCB.setItems(options);
        System.out.println(options);
      
    }

   
    @FXML
    private void ImageAction(ActionEvent event) throws IOException {
          FileChooser fc = new FileChooser();
       // fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg",".bmp", ".png", ".gif"));
        File selectedFile =fc.showOpenDialog(new Stage());
        System.out.println("");
        if (selectedFile != null){
            System.out.println(selectedFile.getName());
       System.out.println(selectedFile.getAbsolutePath());
       visibility.setText(selectedFile.getAbsolutePath());

           String imagepath = selectedFile.toURI().toString();
       //  System.out.println("file==>  "+imagepath);
           Image image = new Image(imagepath);
           ImageIV.setImage(image);
           
           File source = new File(selectedFile.getAbsolutePath());
           File dest = new File("C:\\xampp\\htdocs\\PIDev_WorldFriendship\\PIDev_WorldFriendship\\web\\img");
           
           FileUtils.copyFileToDirectory(source, dest);
//               System.out.println("file uploaded ^^");
               Path p = Paths.get(selectedFile.getAbsolutePath());
               String file = p.getFileName().toString();
//               System.out.println("your link :))))))))");
 //             System.out.println("http://localhost/pidev/images/"+file);
        ImagetoDB =file;

           
 
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialogue D'information");
            alert.setHeaderText("Veuillez sélectionner un fichier");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();

            //System.out.println("not a valid File ");
        }
    }
     @FXML
    private void AjouterPubAction(ActionEvent event) {
//        System.out.println(Utilisateur.getInstance().getId());
        int visibilite = 0;
        if (privateRB.isSelected())
                {
                    visibilite=0;
                }
        if (publicRB.isSelected())
                {
                    visibilite=1;
                }
        Publication p = new Publication(Utilisateur.getInstance().getId(),categorieCB.getValue().getIdcategorie(),contenuTXT.getText(),ImagetoDB,titreTXT.getText(),visibilite);
   PublicationDao pd=new PublicationDao();
   pd.ajouterPublication(p);
    }
    
    
    
    
    public void affichage() throws SQLException{
    
        
        PublicationDao PS = new PublicationDao();
        ObservableList<Publication> OL= FXCollections.observableArrayList(PS.DisplayAllPub());
 
 
        Float a = 1F;
        Double y1 = 45D;
        Double y2 = 45D;
        Double y3 = 45D;
        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();
        pane1.setPrefHeight(120);
	pane1.setPrefWidth(2000);
        pane2.setPrefHeight(120);
	pane2.setPrefWidth(2000);
        pane3.setPrefHeight(120);
	pane3.setPrefWidth(2000);
        pane1.setLayoutX(50);
	pane1.setLayoutY(65);
        pane2.setLayoutX(pane1.getLayoutX() + 300);
	pane2.setLayoutY(95);
        pane3.setLayoutX(pane2.getLayoutX() + 300);
	pane3.setLayoutY(95);
        
       
        for(int i=0; i<OL.size();i++){
                Publication p= OL.get(i);
                Utilisateur u=  PS.getUserPub(p.getUser_id());
                Pane pane = new Pane();
                pane.setPrefHeight(75);
                pane.setPrefWidth(700);
                pane.setLayoutX(10);
                pane.setLayoutY(y1);
                Button button = new Button();
                button.setText("...");
                button.setPrefHeight(10);
                button.setPrefWidth(10);
                button.setLayoutX(295);
                button.setStyle("-fx-background-color: FFFFFF" );
                button.setStyle("-fx-background-radius: 5");
                button.setOnMouseClicked(e -> {
                   
                });
                Label label = new Label();
                Label contenu = new Label();
                //String rep = Integer.toString(OLL.size());
                Label username;
                if (u==null){
                  username= new Label("null");
                }
                else {
                 username = new Label(u.getNom()+" "+u.getPrenom());
                }
                Label reponse = new Label("edit");
                //Date date = new Date();
               // String str = new SimpleDateFormat("yyyy/MM/dd").format(m.getDate_Creation());
                
                
               // File file = new File("D:\\wamp64\\www\\cultureImage\\" + m.getImage());
                //Image images = new Image(file.toURI().toString());
                //System.out.println("ok");
                
                
                contenu.setText("date publication");
                 contenu.setLayoutX(70);
               contenu.setLayoutY(40);
                
                
                
                
                
                label.setText(p.getContenue());
                label.setPrefHeight(10);
                label.setPrefWidth(100);
                label.setLayoutX(120);
                label.setLayoutY(100);
                Label image = new Label();
                image.setText("username");
                //label.setFont(new Font(8));
                image.setStyle("-fx-font-size:1.3em ;");
                image.setStyle("-fx-font-weight:bolder");
                //System.out.println(m);
                ImageView imageuser = new ImageView("file:///C:/xampp/htdocs/PIDev_WorldFriendship/PIDev_WorldFriendship/web/img/"+p.getNomimage());
             ImageView imageuser2 = new ImageView("file:///C:/xampp/htdocs/PIDev_WorldFriendship/PIDev_WorldFriendship/web/img/"+p.getNomimage());
               imageuser.setFitHeight(50);
                imageuser.setFitWidth(50);
                imageuser.setLayoutX(10);
                imageuser.setLayoutY(10);
              imageuser2.setFitHeight(100);
                imageuser2.setFitWidth(100);
                imageuser2.setLayoutX(550);
                imageuser2.setLayoutY(80);
                
               image.setLayoutX(65);
               image.setLayoutY(10);
               username.setLayoutX(110);
               username.setLayoutY(60);
                Label sujet = new Label("bla ");
                sujet.setLayoutX(95D);
                sujet.setLayoutY(5);
                Button button1 = new Button();
                button1.setText("Commenter");
                button1.setPrefHeight(15);
                button1.setPrefWidth(80);
                button1.setLayoutX(37);
                button1.setLayoutY(115);
                button1.setStyle("-fx-background-color: FFFFFF" );
                button1.setOnMouseClicked(e -> {
                   
                });
                //Image voir = new Image(getClass().getResourceAsStream("file:///D:/wamp64/www/cultureImage/eye.png"));
               //button2.setGraphic(new ImageView(voir));
                Button button2 = new Button();
                button2.setText("delete");
                button2.setPrefHeight(15);
                button2.setPrefWidth(60);
                button2.setLayoutX(600);
                button2.setLayoutY(30);
               
                
                reponse.setPrefHeight(15);
                reponse.setPrefWidth(40);
                reponse.setLayoutX(550);
                reponse.setLayoutY(30);
                
                button2.setStyle("-fx-background-color: FFFFFF" );
                button2.setOnMouseClicked(e -> {
                    
                    
                    
                });
                
             //  pane.setStyle("-fx-background-color: FFFFFF" );
                pane.setStyle("-fx-background-radius:30px;-fx-border-radius:30px");
                image.setStyle("-fx-font-size:18;-fx-font-weight:bolder;-fx-fill: #485460;-fx-font-family: Quicksand");
                label.setStyle("-fx-font-size:10;");
           
             //  pane.setStyle("-fx-border-color: black");
                 //pane.setStyle("-fx-background-radius: 5");
                //pane.getChildren().add(button);
               // pane.getChildren().add(button1);
                pane.getChildren().add(button2);
                pane.getChildren().add(label);
                pane.getChildren().add(username);
               // pane.getChildren().add(sujet);
                pane.getChildren().add(image);
                pane.getChildren().add(imageuser);
              //  pane.getChildren().add(imageuser2);
                pane.getChildren().add(contenu);
                 pane.getChildren().add(reponse);
                pane1.getChildren().add(pane);
                
                globalPane.getChildren().add(pane);
                //globalPane.getChildren().add(sujet);
                y1 += 155D ;
        
        }
    
    }

  
}
