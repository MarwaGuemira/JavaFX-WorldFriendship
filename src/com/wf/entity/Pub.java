/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Marwa
 */
public class Pub {
       private int idpublicite;
     private  String nompublicite ;
     private  String pays;
    private  String region;
     private String adresse;
     private LocalDate  datepublicite;
    private  LocalDate  datepublicitefin ;
    private  String contenupublicte ;
    private int point ;
    private float prixproduit ;
     private  float pourcentage ;
    private float prixremise;

    private  String nomimage;
    private  int nbrprofit;
    private int offre_id;
        private int user_id;
    private int nbrlikes;
    private int nbrdislikes;

    public Pub() {
    }

    public Pub(int idpublicite) {
        this.idpublicite = idpublicite;
    }

    public Pub(int idpublicite, int nbrprofit) {
        this.idpublicite = idpublicite;
        this.nbrprofit = nbrprofit;
    }

    public Pub(int idpublicite, String nompublicite, String contenupublicte) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.contenupublicte = contenupublicte;
    }

    public Pub(String nompublicite, String pays, String region, String adresse, LocalDate datepublicitefin, String contenupublicte, int point, float prixproduit, float pourcentage, float prixremise, String nomimage) {
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.point = point;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        this.prixremise = prixremise;
        this.nomimage = nomimage;
    }

    public Pub(int idpublicite, int point, int nbrprofit) {
        this.idpublicite = idpublicite;
        this.point = point;
        this.nbrprofit = nbrprofit;
    }

    public Pub(int idpublicite, String nompublicite, String pays, String region, String adresse, LocalDate datepublicitefin, String contenupublicte, float prixproduit, float prixremise) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.prixproduit = prixproduit;
        this.prixremise = prixremise;
    }
    


    public Pub(String nompublicite, String pays, String region, String adresse, LocalDate datepublicite, LocalDate datepublicitefin, String contenupublicte, float prixproduit, float pourcentage, float prixremise, String nomimage) {
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        this.prixremise = prixremise;
        this.nomimage = nomimage;
    }

//    

    public Pub(String nompublicite, String pays, String region, String adresse, LocalDate datepublicite, LocalDate datepublicitefin, String contenupublicte, int point, float prixproduit, float pourcentage, float prixremise, String nomimage, int user_id) {
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.point = point;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        this.prixremise = prixremise;
        this.nomimage = nomimage;
        this.user_id = user_id;
    }
    
    
    
      public Pub(String nompublicite, String pays, String region, String adresse, LocalDate datepublicite, LocalDate datepublicitefin, String contenupublicte, int point, float prixproduit, float pourcentage, float prixremise, String nomimage, int offre_id, int user_id) {
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.point = point;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        this.prixremise = prixremise;
        this.nomimage = nomimage;
        this.offre_id = offre_id;
        this.user_id = user_id;
    }
    
   public Pub(String nompublicite, String pays, String region, String adresse, LocalDate datepublicite, LocalDate datepublicitefin, String contenupublicte, int point, float prixproduit, float pourcentage, float prixremise, String nomimage) {
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.point = point;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        this.prixremise = prixremise;
        this.nomimage = nomimage;
     
    }

    public Pub(int idpublicite, String nompublicite, int nbrlikes, int nbrdislikes) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.nbrlikes = nbrlikes;
        this.nbrdislikes = nbrdislikes;
    }
   
//           Pub pb = new Pub(txtNom.getText(), txtPays.getText()
//          ,txtRegion.getText(), txtAdresse.getText(), date1 , date2 ,  txtDescription.getText(), Integer.parseInt( txtpoint.getText()) ,
//                      Float.parseFloat(txtprixpr.getText()),Float.parseFloat(txtpource.getText()),ImgToDb,o.getIdoffre(),user.getId());

    public Pub(String nompublicite, String pays, String region, String adresse, LocalDate datepublicite, LocalDate datepublicitefin, String contenupublicte, int point, float prixproduit, float pourcentage, String nomimage, int offre_id, int user_id) {
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.point = point;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        
        this.nomimage = nomimage;
        this.offre_id = offre_id;
        this.user_id = user_id;
    }



    public Pub(int idpublicite, String nompublicite, String pays, String region, String adresse, LocalDate datepublicite, LocalDate datepublicitefin, String contenupublicte, int point, float prixproduit, float pourcentage, String nomimage, int user_id) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
        this.contenupublicte = contenupublicte;
        this.point = point;
        this.prixproduit = prixproduit;
        this.pourcentage = pourcentage;
        this.nomimage = nomimage;
        this.user_id = user_id;
    }
    
  
    
    
   

    public int getNbrlikes() {
        return nbrlikes;
    }

    public void setNbrlikes(int nbrlikes) {
        this.nbrlikes = nbrlikes;
    }

    public int getNbrdislikes() {
        return nbrdislikes;
    }

    public void setNbrdislikes(int nbrdislikes) {
        this.nbrdislikes = nbrdislikes;
    }
    
    public int getOffre_id() {
        return offre_id;
    }

    public void setOffre_id(int offre_id) {
        this.offre_id = offre_id;
    }
    

    public int getIdpublicite() {
        return idpublicite;
    }

    public void setIdpublicite(int idpublicite) {
        this.idpublicite = idpublicite;
    }

    public String getNompublicite() {
        return nompublicite;
    }

    public void setNompublicite(String nompublicite) {
        this.nompublicite = nompublicite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDatepublicite() {
        return datepublicite;
    }

    public void setDatepublicite(LocalDate datepublicite) {
        this.datepublicite = datepublicite;
    }

    public LocalDate getDatepublicitefin() {
        return datepublicitefin;
    }

    public void setDatepublicitefin(LocalDate datepublicitefin) {
        this.datepublicitefin = datepublicitefin;
    }

    public String getContenupublicte() {
        return contenupublicte;
    }

    public void setContenupublicte(String contenupublicte) {
        this.contenupublicte = contenupublicte;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public float getPrixproduit() {
        return prixproduit;
    }

    public void setPrixproduit(float prixproduit) {
        this.prixproduit = prixproduit;
    }

    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public float getPrixremise() {
        return prixremise;
    }

    public void setPrixremise(float prixremise) {
        this.prixremise = prixremise;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

   

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public int getNbrprofit() {
        return nbrprofit;
    }

    public void setNbrprofit(int nbrprofit) {
        this.nbrprofit = nbrprofit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idpublicite;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pub other = (Pub) obj;
        if (this.idpublicite != other.idpublicite) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pub{" + "idpublicite=" + idpublicite + ", nompublicite=" + nompublicite + ", pays=" + pays + ", region=" + region + ", adresse=" + adresse + ", datepublicite=" + datepublicite + ", datepublicitefin=" + datepublicitefin + ", contenupublicte=" + contenupublicte + ", point=" + point + ", prixproduit=" + prixproduit + ", pourcentage=" + pourcentage + ", prixremise=" + prixremise + ", nomimage=" + nomimage + ", nbrprofit=" + nbrprofit + '}';
    }



    
}
