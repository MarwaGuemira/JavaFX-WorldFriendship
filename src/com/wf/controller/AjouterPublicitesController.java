/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.wf.entity.Evenement;
import com.wf.entity.Pub;
import com.wf.entity.Utilisateur;
import com.wf.entity.offre;
import com.wf.entity.type_evenement;
import com.wf.service.EvenementService;
import com.wf.service.OffreService;

import com.wf.service.PubService;
import com.wf.service.TypeevenementService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.UUID;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class AjouterPublicitesController implements Initializable{
 @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDescription;
      @FXML
    private TextField txtPays;
    @FXML
    private TextField txtRegion;
      @FXML
    private TextField txtAdresse;
          @FXML
    private TextField txtpoint;
    @FXML
    private TextField txtprixpr;
        @FXML
    private TextField txtpource;
//            @FXML
//    private TextField txtprixfinal;

     @FXML
    private JFXDatePicker txtdatdeb;
      @FXML
    private JFXDatePicker txtdatfin;
 
        @FXML
    private ImageView imageView;
//     @FXML
//   private JFXComboBox<offre> txttypepub;
//   
        private String ImgToDb;
    @FXML
    private Label errnom;
    @FXML
    private Label errdesc;
    @FXML
    private Label errpays;
    @FXML
    private JFXButton onbt2;
    @FXML
    private Label errprix;
        @FXML
    private Label errprix1;
      @FXML
    private Label errdate;  
     @FXML
  private void insertpub (ActionEvent event) throws ClassNotFoundException,SQLException, FileNotFoundException, DocumentException{
     boolean isNomEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtNom, errnom, "Saisit Nom !!!");
     boolean isDescEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtDescription, errdesc, "Saisit Nom !!!");
     boolean isPaysEmpty= Validation.TextFieldValidation.isTexteFieldNoEmpty(txtPays, errpays, "Saisit Nom !!!");
     boolean isPrixNumber= Validation.TextFieldValidation.isTexteFieldTypeNumber(txtprixpr, errprix, "Uniquement des nums");
          boolean isPrixNumberPositif= Validation.TextFieldValidation.isTexteFieldTypeNumberPositif(txtprixpr, errprix1, "Positif Number");

   LocalDate date1 =txtdatdeb.getValue() ;
   LocalDate date2 =txtdatfin.getValue() ;
   LocalDate datenow=LocalDate.now​();
        boolean isDateValidate= Validation.TextFieldValidation.isDateValable(date1, date2,errdate, "Respecter date");
                boolean isDateValidate1= Validation.TextFieldValidation.isDateValable(datenow, date1,errdate, "date current n'est pas respecter");
                
    int i= AffichageOffreController.idp;
//         System.out.println(i);
//    OffreService a = OffreService.getInstance();
//    offre o1 = new offre();
//  o1=  a.displayById(i);
//         System.out.println(o1);
//         System.out.println(o1.getIdoffre());
  
   //  offre o =(offre) txttypepub.getValue();
     //  int i= AffichageOffreController.idp;
 
     if(isNomEmpty && isNomEmpty && isPaysEmpty && isPrixNumber && isDateValidate && isDateValidate1 )
     {
                 System.out.println(i);
    OffreService a = new OffreService();
   offre o1 = new offre(i);
       PubService pdao = PubService.getInstance();
           Float k=(Float.parseFloat(txtprixpr.getText())*(100-Float.parseFloat(txtpource.getText())))/100;
            System.out.println(k);
       //     pb.setPrixremise(k);
 Utilisateur user = LoginFXMLController.CurrentUser;
              Pub pb = new Pub(txtNom.getText(), txtPays.getText(),
                      txtRegion.getText(), txtAdresse.getText(),
                      date1 , date2 ,  txtDescription.getText(),
                      Integer.parseInt( txtpoint.getText()),  Float.parseFloat(txtprixpr.getText()),
                      Float.parseFloat(txtpource.getText()),k,ImgToDb,o1.getIdoffre(),user.getId());
        
            pdao.insert(pb);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);

            UUID uuid = UUID.randomUUID();

            PdfWriter.getInstance(document, new FileOutputStream("C:\\xampp\\htdocs\\PIDev_WorldFriendship\\web\\images\\pdf\\" + uuid.toString() + ".pdf"));
            document.open();
            java.sql.Date sysdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());


            String text = String.valueOf("Date :  " + sysdate + "\n Iheb Minsi");

             String text1 = String.valueOf("Nom Pub :  " + txtNom.getText() + "\n \n ");

            String text2 = String.valueOf("Pays:  " + txtPays.getText() + "\n \n ");
            String text3 = String.valueOf("Region :  " + txtRegion.getText() + "\n \n ");

          

            String text6 = String.valueOf("Date Debut :  " + date1 + "\n \n ");
            String text7 = String.valueOf("Date fin :  " + date2 + "\n \n ");
        

            document.add(new Paragraph(text));
             document.add(new Paragraph(text1));
            document.add(new Paragraph(text2));
            document.add(new Paragraph(text3));

         //   document.add(new Paragraph(text4));
           // document.add(new Paragraph(text5));
            document.add(new Paragraph(text6));
            document.add(new Paragraph(text7));
            //document.add(new Paragraph(text8));
           

            document.close();

            Alert alertPDF = new Alert(Alert.AlertType.INFORMATION);
            alertPDF.setTitle("Success");
            alertPDF.setContentText("Votre PDF a été généré avec succés");
            alertPDF.showAndWait();
                txtNom.setText("");
                 txtDescription.setText("");
                     txtPays.setText("");
                         txtRegion.setText("");
                             txtAdresse.setText("");
                               txtprixpr.setText("");
                                 txtpource.setText("");
                                     
     
     
     }
   
                                          
                              
      
    }
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
        
        int i= AffichageOffreController.idp;
         System.out.println(i);
    OffreService a = new OffreService();
   offre o1 = new offre(i);
   // offre o2 = new offre(i);
 //a.
 
         System.out.println(o1);
         System.out.println(o1.getIdoffre());
        onbt2.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficherPub.fxml"));
                Scene scene = new Scene(page1,1000,1000);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } 
            catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
//     try {
//         OffreService Tpoff = new OffreService();
//         
//         ObservableList<offre> options = FXCollections.observableArrayList(Tpoff.getcategorieparent());
//        txttypepub.setItems(options);
////         
// txttypepub.setOnAction((event)->{
//int id = txttypepub.getSelectionModel().getSelectedItem().getIdoffre();
////             ObservableList<type_evenement> optionss;
////             optionss = FXCollections.observableArrayList(cps.getsouscategorie(id));
////             txtSousCategorie1.setItems(optionss);
//             
//      } );
//     } catch (SQLException ex) {
//         Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
//     }
}
}
