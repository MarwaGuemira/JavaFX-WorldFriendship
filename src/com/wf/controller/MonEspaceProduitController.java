/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

//import static com.wf.controller.MonEspaceProduitController.returnprod;
import static com.wf.controller.EspaceProduitController.img;
import static com.wf.controller.EspaceProduitController.pathimage;
import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
//import static sun.net.www.http.HttpClient.New;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MonEspaceProduitController implements Initializable {
        ObservableList<String> idcatlist= FXCollections.observableArrayList("Musique","Sport","Camping");

    @FXML
    private ScrollPane images;
    private StackPane détails;
    int id;
     public static int i=0;
    @FXML
    private ImageView image;
    @FXML
    private Label idn;
    @FXML
    private Label idp;
    @FXML
    private Label idcat;
    @FXML
    private Label idd;
    @FXML
    private Label modif;
    @FXML
    private TextField newn;
    @FXML
    private TextField newp;
    @FXML
    private ComboBox<String> newCat;
    @FXML
    private TextArea newd;
    @FXML
    private Button btnModif;
    @FXML
    private Label idsupp;
    @FXML
    private Button btnsupp;
public  int idprod;
    @FXML
    private Label idpr;
    @FXML
    private Label n;
    private Label p;
    @FXML
    private Label c;
    @FXML
    private Label d;
    @FXML
    private Label nn;
    @FXML
    private Label np;
    @FXML
    private Label nc;
    @FXML
    private Label nd;
    @FXML
    private Label pp;
    @FXML
    private Label idpr1;
    @FXML
    private Button espacevente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         espacevente.setOnAction(event -> {

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
        
        idpr.setVisible(true);
                modif.setDisable(false);
                btnModif.setVisible(false);
                idn.setVisible(false);
                idp.setVisible(false);
                idcat.setVisible(false);
                idd.setVisible(false);
                modif.setVisible(false);
                newn.setVisible(false);
                newp.setVisible(false);
                newCat.setVisible(false);
                newd.setVisible(false);
                idsupp.setVisible(false);
                btnsupp.setVisible(false);
                d.setVisible(false);
                n.setVisible(false);
                c.setVisible(false);
                pp.setVisible(false);
                nn.setVisible(false);
                nc.setVisible(false);
                nd.setVisible(false);
                np.setVisible(false);

                                
                 
    newCat.setValue("Musique");
    newCat.setItems(idcatlist);

        try {
            // TODO
            ProduitService ps = new ProduitService();
            int iduu=1;
            ResultSet r =ps.Afficher_All_Produit_By_Uset(iduu);
            
            ObservableList<Produit>list =FXCollections.observableArrayList();
                            TilePane tp =new TilePane();
                            tp.setHgap(5);
                            tp.setVgap(5);
                            tp.setMaxWidth(20);
  List<Produit> ls=new ArrayList();
//ImageView im=new ImageView();
            while(r.next())
            {
                Produit p = new Produit();
             ProduitService pdao = ProduitService.getInstance();
                //u.setId_categorie(r.getInt("categorie_id_categorie"));
      p.setIdproduit(r.getInt("idproduit"));

        p.setNomproduit(r.getString("nomproduit"));
                p.setNomimage(r.getString("nomimage"));
                p.setCategorie(r.getString("categorie"));
                p.setDescriptionproduit(r.getString("descriptionproduit"));
                p.setPrix(r.getFloat("prix"));
                
                String path="http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                Image img=new Image(path);
                ImageView im=new ImageView();
                im.setImage(img);
                im.setFitHeight(200);
                im.setFitWidth(230);
                //im.setPreserveRatio(true);
                tp.getChildren().addAll(im);              
                id=p.getIdproduit();
               
                
im.setOnMouseClicked((MouseEvent event) -> {
     d.setVisible(true);
                n.setVisible(true);
                c.setVisible(true);
                pp.setVisible(true);
                 idsupp.setVisible(true);
                 modif.setVisible(true);
                 idn.setVisible(true);
                idp.setVisible(true);
                idcat.setVisible(true);
                idd.setVisible(true);
                idn.setText(p.getNomproduit());
                idp.setText(""+p.getPrix());
                idcat.setText(p.getCategorie());
                idd.setText(p.getDescriptionproduit());
     idprod=p.getIdproduit();
                String pathimage= "http://localhost/PIDev_WorldFriendship/web/images/"+p.getNomimage();
                Image addimg=new Image(pathimage);
                image.setImage(addimg);
                
                idpr.setText(""+p.getIdproduit());
                     
               
                
                
}
                );
                
 modif.setOnMouseClicked((event) -> {
     nn.setVisible(true);
                nc.setVisible(true);
                nd.setVisible(true);
                np.setVisible(true);
                
                newn.setVisible(true);
                newp.setVisible(true);
                newCat.setVisible(true);
                newd.setVisible(true);
                btnModif.setVisible(true);
                newn.setText(idn.getText());
                newp.setText(idp.getText());
                newCat.setValue(idcat.getText());
                newd.setText(idd.getText());
                
                });
                
idsupp.setOnMouseClicked((event) -> {
                       nn.setVisible(false);
                nc.setVisible(false);
                nd.setVisible(false);
                np.setVisible(false);
                newn.setVisible(false);
                newp.setVisible(false);
                newCat.setVisible(false);
                newd.setVisible(false);
                btnModif.setVisible(false);
                btnsupp.setVisible(true);
                ps.deleteByID(Integer.parseInt(idpr.getText()));
                
                });
btnModif.setOnMouseClicked((event) -> {
  
              Produit   p1=new Produit (id,
              Float.parseFloat(newp.getText()),
              newn.getText(),
              newd.getText(),
              newCat.getValue());
                       
            System.out.println(p1 +""+ idprod);
            pdao.Modifier(p1,Integer.parseInt(idpr.getText()));
            
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Produit modifié avec succés!");
        alert.show();
            idn.setText("");
            idp.setText("");
            idd.setText("");
              newn.setVisible(false);
                newp.setVisible(false);
                newCat.setVisible(false);
                newd.setVisible(false);
  btnModif.setVisible(false);
                
        System.out.println(id);
           
});
                
                        
images.setContent(tp);       
}}       catch (SQLException ex) {
            Logger.getLogger(MonEspaceProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void modifie(MouseEvent event) {
    }

    @FXML
    private void ModifierProd(ActionEvent event) {
       
    
    }

    @FXML
    private void SupprimerProd(MouseEvent event) {
    }


}