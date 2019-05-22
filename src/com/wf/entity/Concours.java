/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.sql.Date;

/**
 *
 * @author sfaxidorra
 */
public class Concours {
    protected int idconcours;	
    protected int categorie_id;	
    protected String nomconcours;
    protected Date datedebut;
    protected Date datefin;
    protected String descriptionconcours;
    protected String prixgagnant;

    public Concours() {
    }

    public Concours(int idconcours, int categorie_id, String nomconcours, Date datedebut, Date datefin, String descriptionconcours, String prixgagnant) {
        this.idconcours = idconcours;
        this.categorie_id = categorie_id;
        this.nomconcours = nomconcours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.descriptionconcours = descriptionconcours;
        this.prixgagnant = prixgagnant;
    }

    public Concours(int categorie_id, String nomconcours, Date datedebut, Date datefin, 
            String descriptionconcours, String prixgagnant) {
        this.categorie_id = categorie_id;
        this.nomconcours = nomconcours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.descriptionconcours = descriptionconcours;
        this.prixgagnant = prixgagnant;
    }

    @Override
    public String toString() {
        return nomconcours ;
    }
    

    public int getIdconcours() {
        return idconcours;
    }

    public void setIdconcours(int idconcours) {
        this.idconcours = idconcours;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getNomconcours() {
        return nomconcours;
    }

    public void setNomconcours(String nomconcours) {
        this.nomconcours = nomconcours;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getDescriptionconcours() {
        return descriptionconcours;
    }

    public void setDescriptionconcours(String descriptionconcours) {
        this.descriptionconcours = descriptionconcours;
    }

    public String getPrixgagnant() {
        return prixgagnant;
    }

    public void setPrixgagnant(String prixgagnant) {
        this.prixgagnant = prixgagnant;
    }

    public int getIdcategorie() {
      return this.categorie_id;
    }
    

    
}
