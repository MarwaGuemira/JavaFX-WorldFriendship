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
public class commentaireproduit {
    private int idcommentaire;
    private int id_produit;
    private Utilisateur user_id;
    private String contenu;

    public commentaireproduit(int idcommentaire, int id_produit, int user_id, String contenu) {
        this.idcommentaire = idcommentaire;
        this.id_produit = id_produit;
        this.user_id =new Utilisateur(user_id);
        this.contenu = contenu;
    }

    public commentaireproduit(int id_produit, int user_id, String contenu) {
        this.id_produit = id_produit;
            this.user_id =new Utilisateur(user_id);

        this.contenu = contenu;
    }

    public commentaireproduit() {
    }

    public commentaireproduit(String contenu) {
        this.contenu = contenu;
    }
    

    public int getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(int idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
             this.user_id =new Utilisateur(user_id);

    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return  contenu ;
    }
    
    

    
    
}
