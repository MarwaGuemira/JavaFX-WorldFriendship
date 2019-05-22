/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author ihebm
 */
public class Reclamation {
    private int idreclam;
    private Utilisateur user_id;
    private int categorie_id;
    private String descriptionreclam;
    private String titrereclam;
    private LocalDate datereclam;
    private String etatreclam;
    private typereclamation type_id;


    public Reclamation() {
    }

       public Reclamation(String descriptionreclam, String titrereclam, LocalDate datereclam
       ) {
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.datereclam = datereclam;
      
     
    }
    
    
    public Reclamation(String descriptionreclam, String titrereclam, LocalDate datereclam, int user_id) {
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.datereclam = datereclam;
      
        this.user_id = new Utilisateur(user_id);
    }

    public Reclamation(int idreclam, String etatreclam) {
        this.idreclam = idreclam;
        this.etatreclam = etatreclam;
    }

    public Reclamation(String descriptionreclam,int type_id ) {
        this.descriptionreclam= descriptionreclam;
        this.type_id = new typereclamation(type_id);
    
    }

    public Reclamation(String descriptionreclam, String titrereclam, int type_id) {
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.type_id = new typereclamation(type_id);
    }
    
    
    

    public Reclamation(int user_id, String descriptionreclam, String titrereclam, LocalDate datereclam, String etatreclam) {
        this.user_id = new Utilisateur(user_id);
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.datereclam = datereclam;
        this.etatreclam = etatreclam;
    }

    public Reclamation(int idreclam, String descriptionreclam, String titrereclam, String etatreclam) {
        this.idreclam = idreclam;
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.etatreclam = etatreclam;
    }

    public Reclamation(String descriptionreclam) {
        this.descriptionreclam = descriptionreclam;
    }
    

    public Reclamation(int idreclam, int user_id, int categorie_id, String descriptionreclam, String titrereclam, LocalDate datereclaam, String etatreclam) {
        this.idreclam = idreclam;
        this.user_id = new Utilisateur(user_id);
        this.categorie_id = categorie_id;
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.datereclam = datereclam;
        this.etatreclam = etatreclam;
    }

    public Reclamation(int user_id, int categorie_id, String descriptionreclam, String titrereclam, LocalDate datereclam, String etatreclam) {
        this.user_id = new Utilisateur(user_id);
        this.categorie_id = categorie_id;
        this.descriptionreclam = descriptionreclam;
        this.titrereclam = titrereclam;
        this.datereclam = datereclam;
        this.etatreclam = etatreclam;
    }

    public Reclamation(int user_id, String descriptionreclam, int type_id) {
        this.user_id = new Utilisateur(user_id);
        this.descriptionreclam = descriptionreclam;
        this.type_id =  new typereclamation(type_id);
    }
    

    public int getIdreclam() {
        return idreclam;
    }

    public void setIdreclam(int idreclam) {
        this.idreclam = idreclam;
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = new Utilisateur(user_id);
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getDescriptionreclam() {
        return descriptionreclam;
    }

    public void setDescriptionreclam(String descriptionreclam) {
        this.descriptionreclam = descriptionreclam;
    }

    public String getTitrereclam() {
        return titrereclam;
    }

    public void setTitrereclam(String titrereclam) {
        this.titrereclam = titrereclam;
    }

    public LocalDate getDatereclam() {
        return datereclam;
    }

    public void setDatereclam(LocalDate datereclam) {
        this.datereclam = datereclam;
    }

    public String getEtatreclam() {
        return etatreclam;
    }

    public void setEtatreclam(String etatreclam) {
        this.etatreclam = etatreclam;
    }

    public typereclamation getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = new typereclamation(type_id);
    }


    
    @Override
    public String toString() {
        return "Reclamation{" + "idreclam=" + idreclam + ", user_id=" + user_id + ", categorie_id=" + categorie_id + ", descriptionreclam=" + descriptionreclam + ", titrereclam=" + titrereclam + ", datereclaam=" + datereclam + ", etatreclam=" + etatreclam +", type_id=" +type_id+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idreclam;
        hash = 37 * hash + Objects.hashCode(this.user_id);
        hash = 37 * hash + this.categorie_id;
        hash = 37 * hash + Objects.hashCode(this.descriptionreclam);
        hash = 37 * hash + Objects.hashCode(this.titrereclam);
        hash = 37 * hash + Objects.hashCode(this.datereclam);
        hash = 37 * hash + Objects.hashCode(this.etatreclam);
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
        final Reclamation other = (Reclamation) obj;
        if (this.idreclam != other.idreclam) {
            return false;
        }
        if (this.categorie_id != other.categorie_id) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.descriptionreclam, other.descriptionreclam)) {
            return false;
        }
        if (!Objects.equals(this.titrereclam, other.titrereclam)) {
            return false;
        }
        if (!Objects.equals(this.datereclam, other.datereclam)) {
            return false;
        }
        if (!Objects.equals(this.etatreclam, other.etatreclam)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
