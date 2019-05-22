/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

/**
 *
 * @author Marwa
 */
public class offre {
      private  int idoffre;
    private String nomoffre;
    private int ordre;
    private int prix ;
    private String pays ;

    public offre() {
    }

    public offre(int idoffre) {
        this.idoffre = idoffre;
    }

    public offre(int idoffre, String nomoffre, int ordre, int prix, String pays) {
        this.idoffre = idoffre;
        this.nomoffre = nomoffre;
        this.ordre = ordre;
        this.prix = prix;
        this.pays = pays;
    }

    public offre(String nomoffre) {
        this.nomoffre = nomoffre;
    }

    public offre(int idoffre, String nomoffre) {
        this.idoffre = idoffre;
        this.nomoffre = nomoffre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idoffre;
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
        final offre other = (offre) obj;
        if (this.idoffre != other.idoffre) {
            return false;
        }
        return true;
    }

    public int getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(int idoffre) {
        this.idoffre = idoffre;
    }

    public String getNomoffre() {
        return nomoffre;
    }

    public void setNomoffre(String nomoffre) {
        this.nomoffre = nomoffre;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return  nomoffre;
    }
    
    
    
   
}
