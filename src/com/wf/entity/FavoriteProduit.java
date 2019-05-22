/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

/**
 *
 * @author Lenovo
 */
public class FavoriteProduit {
    public int id_user;
    public int id_favorite;
    public int produit;

    public FavoriteProduit(int id_user, int id_favorite, int produit) {
        this.id_user = id_user;
        this.id_favorite = id_favorite;
        this.produit = produit;
    }
    public FavoriteProduit(int id_user,int produit) {
        this.id_user = id_user;
   
        this.produit = produit;
    }

    public FavoriteProduit() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_favorite() {
        return id_favorite;
    }

    public void setId_favorite(int id_favorite) {
        this.id_favorite = id_favorite;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "FavoriteProduit{" + "id_user=" + id_user + ", id_favorite=" + id_favorite + ", produit=" + produit + '}';
    }
    
    
}
