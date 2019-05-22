/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

/**
 *
 * @author sfaxidorra
 */
public class Categorie {
    protected int idcategorie;	
    protected String nomcategorie;	
    protected int nbrabonnees;	
    protected String imgcatgorie;	
    protected String descriptioncategorie;

    public Categorie(int idcategorie, String nomcategorie, int nbrabonnees, String imgcatgorie, String descriptioncategorie) {
        this.idcategorie = idcategorie;
        this.nomcategorie = nomcategorie;
        this.nbrabonnees = nbrabonnees;
        this.imgcatgorie = imgcatgorie;
        this.descriptioncategorie = descriptioncategorie;
    }

    public Categorie() {
    }

    public Categorie(String ImagetoDB, int i, String ImagetoDB0, String ImagetoDB1) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Categorie(String nomcategorie, String imagecategorie, String descriptioncategorie) {
    this.nomcategorie=nomcategorie;
    this.imgcatgorie=imagecategorie;
    this.descriptioncategorie=descriptioncategorie;
    }

    @Override
    public String toString() {
        return nomcategorie ;
    }
    
    

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public int getNbrabonnees() {
        return nbrabonnees;
    }

    public void setNbrabonnees(int nbrabonnees) {
        this.nbrabonnees = nbrabonnees;
    }

    public String getImgcatgorie() {
        return imgcatgorie;
    }

    public void setImgcatgorie(String imgcatgorie) {
        this.imgcatgorie = imgcatgorie;
    }

    public String getDescriptioncategorie() {
        return descriptioncategorie;
    }

    public void setDescriptioncategorie(String descriptioncategorie) {
        this.descriptioncategorie = descriptioncategorie;
    }
    
    
    
    
}
