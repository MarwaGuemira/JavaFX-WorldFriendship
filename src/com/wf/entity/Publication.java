/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.util.Date;

/**
 *
 * @author nermi
 */
public class Publication {
      private int id;
    private int user_id;
    private int categorie_id;
    private String titre;
    private String contenue;
   private String nomimage;
  
   private int nbrlike;
   private Date datepublication;
   private int visibilite;
   private int nbrdislike;
public Publication()
{
    
}
    public Publication(int user_id, int categorie_id, String contenue, String nomimage, String titre, int visibilite) {
     this.user_id=user_id;
     this.categorie_id=categorie_id;
     this.contenue=contenue;
     this.nomimage=nomimage;
     this.titre=titre;
     this.visibilite=visibilite;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", user_id=" + user_id + ", categorie_id=" + categorie_id + ", titre=" + titre + ", contenue=" + contenue + ", nomimage=" + nomimage + ", nbrlike=" + nbrlike + ", datepublication=" + datepublication + ", visibilite=" + visibilite + ", nbrdislike=" + nbrdislike + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public int getNbrlike() {
        return nbrlike;
    }

    public void setNbrlike(int nbrlike) {
        this.nbrlike = nbrlike;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public int getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(int visibilite) {
        this.visibilite = visibilite;
    }

    public int getNbrdislike() {
        return nbrdislike;
    }

    public void setNbrdislike(int nbrdislike) {
        this.nbrdislike = nbrdislike;
    }

    public Publication(int user_id, int categorie_id, String titre, String contenue, String nomimage, int nbrlike, Date datepublication, int visibilite, int nbrdislike) {
        this.user_id = user_id;
        this.categorie_id = categorie_id;
        this.titre = titre;
        this.contenue = contenue;
        this.nomimage = nomimage;
        this.nbrlike = nbrlike;
        this.datepublication = datepublication;
        this.visibilite = visibilite;
        this.nbrdislike = nbrdislike;
    }

  public Publication(int id, int user_id, int categorie_id, String titre, String contenue, String nomimage, int nbrlike, Date datepublication, int visibilite, int nbrdislike) {
        this.id = id;
        this.user_id = user_id;
        this.categorie_id = categorie_id;
        this.titre = titre;
        this.contenue = contenue;
        this.nomimage = nomimage;
     
        this.nbrlike = nbrlike;
        this.datepublication = datepublication;
        this.visibilite = visibilite;
        this.nbrdislike = nbrdislike;
    }

  /*  public Publication(int user_id, int categorie_id, String contenue, String nomimage) {

        this.user_id = user_id;
        this.categorie_id = categorie_id;
        this.contenue = contenue;
        this.nomimage = nomimage;
    }*/
   
}
