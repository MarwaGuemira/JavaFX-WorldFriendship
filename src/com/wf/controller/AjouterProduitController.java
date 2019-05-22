/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.sun.javaws.Main;
import com.wf.entity.Produit;
import com.wf.entity.Utilisateur;
import com.wf.entity.fos_user;
import com.wf.service.ProduitService;
import com.wf.service.User1Service;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Houssem
 */
public class AjouterProduitController implements Initializable {
    
    ObservableList<String> idcombolist= FXCollections.observableArrayList("Oui","Non");
        ObservableList<String> idcatlist= FXCollections.observableArrayList("Musique","Sport","Camping");
        ObservableList<String> Acpt= FXCollections.observableArrayList("Non","Accépter");

     @FXML
    private TextField Nomp;
    @FXML
    private TextField Prix;
       @FXML
    private ComboBox<String> idcat;
       @FXML
    private TextArea iddesc;
       @FXML
        private ImageView idimage;
      private String ImgToDb;
    @FXML
    private Button monespace;
    @FXML
    private ComboBox<String> idcombobox;
    @FXML
    private Label errnom;
    @FXML
    private Label errTel;
    
       @FXML
    private void insertProduit(ActionEvent event) throws ClassNotFoundException,SQLException{
     boolean isNomEmpty = Validation.TextFieldValidation.isTexteFieldNoEmpty(Nomp, errnom, "champ Vide ");
     boolean isTelNum = Validation.TextFieldValidation.isTexteFieldTypeNumber(Prix, errTel, "Veuillez entrer un Prix Valide !! ");

        
           LocalDateTime date =LocalDateTime.now();
      Utilisateur user = LoginFXMLController.CurrentUser;
      String AcptProd="Non";
                 Produit u;
         u = new Produit(Nomp.getText(),Float.parseFloat(Prix.getText()),idcat.getValue(),iddesc.getText(),ImgToDb,
         idcombobox.getValue(),date,Acpt.get(0));
           System.out.println(u.toString());
            ProduitService pdao = ProduitService.getInstance();
            pdao.insert(u);
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Produit insérée avec succés!");
        alert.show();
                Nomp.setText("");
       // idcat.setText("");
        Prix.setText("");
        iddesc.setText("");
        
        
   
    
    }
   
    @FXML
    private void ProductPicture(ActionEvent event) throws IOException{
     FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile =fc.showOpenDialog(new Stage());
        System.out.println("");
        if (selectedFile != null){
            //System.out.println(selectedFile.getName());
//            System.out.println(selectedFile.getAbsolutePath());
//            btnup.setText(selectedFile.getAbsolutePath());

           String imagepath = selectedFile.toURI().toString();
           //System.out.println("file==>  "+imagepath);
    Image image = new Image(imagepath);
           idimage.setImage(image);
           
           File source = new File(selectedFile.getAbsolutePath());
            File dest = new File("C:\\xampp\\htdocs\\PIDev_WorldFriendship\\web\\images");
           
           FileUtils.copyFileToDirectory(source, dest);
//               System.out.println("file uploaded ^^");
               Path p = Paths.get(selectedFile.getAbsolutePath());
               String file = p.getFileName().toString();
//               System.out.println("your link :))))))))");
//               System.out.println("http://localhost/pidev/images/"+file);
               ImgToDb =file;

           
 
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialogue D'information");
            alert.setHeaderText("Veuillez sélectionner un fichier");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();

            //System.out.println("not a valid File ");
        }
    }
   
        //throw new UnsupportedOperationException("Not supported yet.");
         

    @Override
    public void initialize(URL location, ResourceBundle resources)  
    { idcombobox.setValue("Oui");
    idcombobox.setItems(idcombolist);
    idcat.setValue("Musique");
    idcat.setItems(idcatlist);
    //idcatlist.se
        
        monespace.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/MonEspaceProduit.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }   

    
    




         
    }    

