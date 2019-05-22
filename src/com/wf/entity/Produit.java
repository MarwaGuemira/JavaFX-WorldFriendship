/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 *
 * @author Houssem
 */
public class Produit {
    private int idproduit;
    private String nomproduit;
        private String nomimage;

    private LocalDateTime datemisevente;
    private float prix;
    private String categorie;
        private String AcptProd;

    public String getAcptProd() {
        return AcptProd;
    }

    public void setAcptProd(String AcptProd) {
        this.AcptProd = AcptProd;
    }

    public Produit(String AcptProd) {
        this.AcptProd = AcptProd;
    }

    private int nbrlike=0;
    private int nbrdislike=0;
    private String etat;
    private FileChooser image;
    private String descriptionproduit;
    private   int userid ;

    public Produit(int idproduit, String nomproduit, String nomimage, float prix, String categorie, String descriptionproduit) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.nomimage = nomimage;
        this.prix = prix;
        this.categorie = categorie;
        this.descriptionproduit = descriptionproduit;
    }

    public Produit() {
    }

    public Produit(String nomproduit,float prix,LocalDateTime datemisevente, String categorie, String descriptionproduit,String nomimage,int userid) {
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.datemisevente=datemisevente;
        this.categorie = categorie;
        this.descriptionproduit = descriptionproduit;
        this.nomimage=nomimage;
        this.userid=userid;
    }
    public Produit(String nomproduit,float prix, String descriptionproduit , String categorie ) {
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.descriptionproduit = descriptionproduit;
          this.categorie = categorie;
    }
//     public Produit(int idproduit,String nomproduit,float prix, String descriptionproduit , String categorie ) {
//       this.idproduit=idproduit;
//         this.nomproduit = nomproduit;
//        this.prix = prix;
//        this.descriptionproduit = descriptionproduit;
//          this.categorie = categorie;
//    }
     public Produit(int idproduit,String nomproduit,float prix,String categorie , String etat  ) {
       this.idproduit=idproduit;
         this.nomproduit = nomproduit;
        this.prix = prix;
        this.etat = etat;
          this.categorie = categorie;
    }
     public Produit(int idproduit,float prix,String nomproduit, String categorie,String descriptionproduit  ) {
        this.idproduit=idproduit;
         this.nomproduit = nomproduit;
        this.prix = prix;
          this.categorie = categorie;         
          this.descriptionproduit = descriptionproduit;

          
    }

    public Produit(int idproduit, String nomproduit, float prix,LocalDateTime datemisevente,  String categorie, String etat) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.datemisevente = datemisevente;
        this.prix = prix;
        this.categorie = categorie;
        this.etat = etat;
    }
    public Produit(String nomproduit,float prix, String categorie,String descriptionproduit,String nomimage,String etat,LocalDateTime datemisevente,String AcptProd) {
        
        //this.idproduit=idproduit;
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.categorie = categorie;
        this.descriptionproduit = descriptionproduit;

        this.nomimage=nomimage;
        this.etat=etat;
            this.datemisevente = datemisevente;
            this.AcptProd=AcptProd;

    }

  


    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
       
     
        
    
    
    
    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    
    public LocalDateTime getDatemisevente() {
        return datemisevente;
    }

    public void setDatemisevente(LocalDateTime datemisevente) {
        this.datemisevente = datemisevente;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNbrlike() {
        return nbrlike;
    }

    public void setNbrlike(int nbrlike) {
        this.nbrlike = nbrlike;
    }

    public int getNbrdislike() {
        return nbrdislike;
    }

    public void setNbrdislike(int nbrdislike) {
        this.nbrdislike = nbrdislike;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public FileChooser getImage() {
        return image;
    }

    public void setImage(FileChooser image) {
        this.image = image;
    }

    public String getDescriptionproduit() {
        return descriptionproduit;
    }

    public void setDescriptionproduit(String descriptionproduit) {
        this.descriptionproduit = descriptionproduit;
    }
    
    @Override
    public String toString() {
        return "Produit{" + " id=" + idproduit + " ,nomproduit=" + nomproduit + " ,Date Mise En Vente=" +datemisevente +" ,Prix = "+
                prix+" <Catégorie = "+categorie +""+etat+" ,Description = "+descriptionproduit+'}';
    }

    public void addEventHandler(EventType<MouseEvent> MOUSE_CLICKED, EventHandler<MouseEvent> eventHandler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    

    
}
