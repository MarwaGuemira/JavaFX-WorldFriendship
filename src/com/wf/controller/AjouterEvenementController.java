/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Evenement;
import com.wf.entity.Utilisateur;
import com.wf.entity.type_evenement;
import com.wf.service.EvenementService;
import com.wf.service.TypeevenementService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AjouterEvenementController implements Initializable  {
// @FXML
//    private TextField txtNom;
//    @FXML
//    private TextField txtDescription;
//      @FXML
//    private TextField txtPays;
//    @FXML
//    private TextField txtRegion;
//      @FXML
//    private TextField txtAdresse;
//    @FXML
//    private TextField txtnbrpart;
//      @FXML
//    private TextField txtnbrti;
//     @FXML
//    private JFXDatePicker txtdatdeb;
//         @FXML
//    private JFXDatePicker txtdatdeb2;
//      @FXML
//    private JFXComboBox<type_evenement> txttypeeve;
//        @FXML
//    private ImageView imageView;
    
    private String ImgToDb;
    @FXML
    private JFXButton retour;
    @FXML
    private Label labelplace;
    @FXML
    private ImageView imageView;
    @FXML
    private JFXDatePicker txtdatdeb;
    @FXML
    private JFXDatePicker txtdatdeb2;
    @FXML
    private JFXTextField txtNom;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtPays;
    @FXML
    private JFXTextField txtRegion;
    @FXML
    private JFXTextField txtAdresse;
    @FXML
    private JFXComboBox<type_evenement> txttypeeve;
    @FXML
    private JFXCheckBox gratuit;
    @FXML
    private JFXCheckBox payer;
    @FXML
    private JFXTextField txtnbrti;
    @FXML
    private JFXTextField prixtick;
    @FXML
    private Label prixtic;
    private String k ="true";
    @FXML
    private Label errnomeve;
    @FXML
    private Label errdesc;
    @FXML
    private Label errdatedebut;
    @FXML
    private Label errdatefin;
    @FXML
    private Label errpays;
    @FXML
    private Label errregion;
    @FXML
    private Label erradresse;


            @FXML
    public void BtnUpAction(ActionEvent event) throws IOException{
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
           imageView.setImage(image);
           
           File source = new File(selectedFile.getAbsolutePath());
           File dest = new File("C:\\xampp\\htdocs\\PIDev_WorldFriendship\\web\\images");
           FileUtils.copyFileToDirectory(source, dest);
           //               System.out.println("file uploaded ^^");
           Path p = Paths.get(selectedFile.getAbsolutePath());
           String file = p.getFileName().toString();
           //               System.out.println("your link :))))))))");
//               System.out.println("http://localhost/pidev/images/"+file);
ImgToDb = ""+file; 
 
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialogue D'information");
            alert.setHeaderText("Veuillez sélectionner un fichier");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();

            //System.out.println("not a valid File ");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prixtic.setVisible(false);
        prixtick.setVisible(false);
        labelplace.setVisible(false);
        txtnbrti.setVisible(false);
        
        
     try {
         TypeevenementService Tpev = new TypeevenementService();
         
         ObservableList<type_evenement> options = FXCollections.observableArrayList(Tpev.getcategorieparent());
         txttypeeve.setItems(options);
         
         txttypeeve.setOnAction((event)->{
             int id = txttypeeve.getSelectionModel().getSelectedItem().getIdtype();
//             ObservableList<type_evenement> optionss;
//             optionss = FXCollections.observableArrayList(cps.getsouscategorie(id));
//             txtSousCategorie1.setItems(optionss);
             
         });
     } catch (SQLException ex) {
         Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
     }
         payer.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
         gratuit.setSelected(false);
  k= "false" ;
          prixtic.setVisible(true);
        prixtick.setVisible(true);
        labelplace.setVisible(true);
        txtnbrti.setVisible(true);
        }
         });
                  gratuit.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            
      payer.setSelected(false);
       prixtick.setText("0");
   k= "true" ;
          prixtic.setVisible(false);
        prixtick.setVisible(false);
        labelplace.setVisible(true);
        txtnbrti.setVisible(true);
        }
         });
        
//  if (payer.isSelected()) 
//  { 
//     k= false ;
//          prixtic.setVisible(true);
//        prixtick.setVisible(true);
//        labelplace.setVisible(true);
//        txtnbrti.setVisible(true);
//  
//  }
//  
//  
//   if (gratuit.isSelected()) 
//  { 
//     k= true ;
//          prixtic.setVisible(false);
//        prixtick.setVisible(false);
//        labelplace.setVisible(true);
//        txtnbrti.setVisible(true);
//  
//  }
     
    
      retour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficherEvenement.fxml"));
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
    
    
    
    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
  
         @FXML
 
     private void insertEve (ActionEvent event) throws ClassNotFoundException,SQLException{

         boolean isNomEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtNom, errnomeve, "Saisit nom evenement !!!");
     boolean isDescEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtDescription, errdesc, "Saisit description !!!");
     boolean isPaysEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtPays, errpays, "Saisit Pays !!!");
       boolean isRegionEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtPays, errregion, "Saisit region !!!");
         boolean isAdresseEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtPays, errpays, "Saisit adresse !!!");
                 LocalDate date1 =txtdatdeb.getValue() ;
    LocalDate date2 =txtdatdeb2.getValue() ;    
   LocalDate datenow=LocalDate.now​();
        boolean isDate2Validate= Validation.TextFieldValidation.isDateValable(date1, date2, prixtic, "Respecter date");
                boolean isDateValidate1= Validation.TextFieldValidation.isDateValable(datenow, date1,errdatefin, "date current n'est pas respecter");
                
if(isNomEmpty && isDescEmpty && isPaysEmpty && isRegionEmpty && isAdresseEmpty &&  isDateValidate1 && isDate2Validate  )
     {

         Utilisateur user = LoginFXMLController.CurrentUser;
     type_evenement c =(type_evenement) txttypeeve.getValue();
              Evenement ev = new Evenement(txtNom.getText(), txtPays.getText()
          ,txtRegion.getText(), txtAdresse.getText(), date1 , date2,  txtDescription.getText()
   ,Integer.parseInt(txtnbrti.getText()),Float.parseFloat(prixtick.getText()),ImgToDb,c.getIdtype(),user.getId(),k);
            EvenementService pdao = EvenementService.getInstance();
            pdao.insert(ev);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
                    String title = "Congratulations sir";
        String message = "You've successfully created your first Tray Notification";
        NotificationType notification = NotificationType.SUCCESS;
  
        TrayNotification tray = new TrayNotification();
         //  Image img = new Image("/image/bg.png");
        tray.setTitle(title);
        tray.setMessage(message);

        tray.setNotificationType(notification);
        //tray.showAndWait();
         tray.showAndDismiss(Duration.seconds(10));
        alert.show();
                txtNom.setText("");
                 txtDescription.setText("");
                     txtPays.setText("");
                         txtRegion.setText("");
                             txtAdresse.setText("");
                          //     txtnbrpart.setText("");
                                 txtnbrti.setText("");
                              
      
    }
     }
    
}
