/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.time.LocalDate;

/**
 *
 * @author Marwa
 */
public class Evenement {
    
    
    private int idevenement;
   // private User  user_id;
    // private Categorie categorie_id;
     // private Typeevenement typeevenement_id;

    private  String nomevenement ;
     private  String pays;
    private  String region;
     private String adresse;
     private LocalDate  datedebut;
    private  LocalDate  datefin ;
    private  String descriptionevenement ;
    private int nbrparticipants ;
    private int nbrplacestotal ;
     private  int payment ;
    private int nbrtickets;
    private float  prixtickets;
    private  String nomimage;
    private  int nbrlikes;
    private int nbrdislikes ;
   private  int nbsignal ;
   private int typeevenement_id;
   private  int user_id;
   private String gratuit ;

    public Evenement() {
        
        
        
    }

    public Evenement(String nomevenement, String pays, String region, String adresse, String descriptionevenement, int nbrtickets) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.descriptionevenement = descriptionevenement;
        this.nbrtickets = nbrtickets;
    }

    public Evenement(int idevenement, String nomevenement, String descriptionevenement) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
    }

    public Evenement(int idevenement) {
        this.idevenement = idevenement;
    }

    public Evenement(int idevenement, String nomevenement, String pays, String region, String adresse, LocalDate datedebut, LocalDate  datefin, String descriptionevenement, int nbrparticipants, int nbrplacestotal, int payment, int nbrtickets, float prixtickets, String nomimage, int nbrlikes, int nbrdislikes, int nbsignal) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.descriptionevenement = descriptionevenement;
        this.nbrparticipants = nbrparticipants;
        this.nbrplacestotal = nbrplacestotal;
        this.payment = payment;
        this.nbrtickets = nbrtickets;
        this.prixtickets = prixtickets;
        this.nomimage = nomimage;
        this.nbrlikes = nbrlikes;
        this.nbrdislikes = nbrdislikes;
        this.nbsignal = nbsignal;
    }

    public Evenement(String nomevenement, String descriptionevenement, String nomimage) {
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
        this.nomimage = nomimage;
    }

  

    public Evenement(String nomevenement, String pays, String region, String adresse, String descriptionevenement, String nomimage) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.descriptionevenement = descriptionevenement;
        this.nomimage = nomimage;
    }

    public Evenement(String nomevenement, String pays, String region, String adresse, String descriptionevenement, int nbrparticipants, int nbrtickets, String nomimage) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.descriptionevenement = descriptionevenement;
        this.nbrparticipants = nbrparticipants;
        this.nbrtickets = nbrtickets;
        this.nomimage = nomimage;
    }
    
    

    public Evenement(String nomevenement, String pays, String region, String adresse, LocalDate datedebut, String descriptionevenement, int nbrparticipants, float prixtickets, String nomimage) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datedebut = datedebut;
        this.descriptionevenement = descriptionevenement;
        this.nbrparticipants = nbrparticipants;
        this.prixtickets = prixtickets;
        this.nomimage = nomimage;
    }

    public Evenement(String nomevenement, String pays, String region, String adresse, LocalDate datedebut, String descriptionevenement, int nbrparticipants, int nbrtickets, String nomimage, int typeevenement_id) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datedebut = datedebut;
        this.descriptionevenement = descriptionevenement;
        this.nbrparticipants = nbrparticipants;
        this.nbrtickets = nbrtickets;
        this.nomimage = nomimage;
        this.typeevenement_id = typeevenement_id;
    }

    public Evenement(int idevenement, int nbrparticipants) {
        this.idevenement = idevenement;
        this.nbrparticipants = nbrparticipants;
    }

    public Evenement(int idevenement, int nbrlikes, int nbrdislikes) {
        this.idevenement = idevenement;
        this.nbrlikes = nbrlikes;
        this.nbrdislikes = nbrdislikes;
    }
    
    
     

    public Evenement(String nomevenement, String pays, String region, String adresse, LocalDate datedebut, LocalDate datefin, String descriptionevenement, int nbrtickets, int nbrplacestotal, String nomimage, int typeevenement_id) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.descriptionevenement = descriptionevenement;
           this.nbrtickets = nbrtickets;
        this.nbrplacestotal = nbrplacestotal;
        this.nomimage = nomimage;
       this.typeevenement_id = typeevenement_id;
    }

    public Evenement(String nomevenement, String pays, String region, String adresse, LocalDate datedebut, LocalDate datefin, String descriptionevenement, int nbrplacestotal, int nbrtickets, String nomimage, int typeevenement_id, int user_id) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.descriptionevenement = descriptionevenement;
        this.nbrplacestotal = nbrplacestotal;
        this.nbrtickets = nbrtickets;
          this.nomimage = nomimage;
        this.typeevenement_id = typeevenement_id;
        this.user_id = user_id;
    }

    public Evenement(int idevenement, String nomevenement, int nbsignal) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
        this.nbsignal = nbsignal;
    }

    public Evenement(String nomevenement, String pays, String region, String adresse, LocalDate datedebut, LocalDate datefin, String descriptionevenement, int nbrplacestotal, float prixtickets, String nomimage, int typeevenement_id, int user_id , String gratuit) {
        this.nomevenement = nomevenement;
        this.pays = pays;
        this.region = region;
        this.adresse = adresse;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.descriptionevenement = descriptionevenement;
        this.nbrplacestotal = nbrplacestotal;
        this.prixtickets = prixtickets;
        this.nomimage = nomimage;
        this.typeevenement_id = typeevenement_id;
          this.user_id = user_id;
        this.gratuit = gratuit;
    }

    public String getGratuit() {
        return gratuit;
    }

    public void setGratuit(String gratuit) {
        this.gratuit = gratuit;
    }



    
    

    public int getTypeevenement_id() {
        return typeevenement_id;
    }

    public void setTypeevenement_id(int typeevenement_id) {
        this.typeevenement_id = typeevenement_id;
    }

    public int getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(int idevenement) {
        this.idevenement = idevenement;
    }

    public String getNomevenement() {
        return nomevenement;
    }

    public void setNomevenement(String nomevenement) {
        this.nomevenement = nomevenement;
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

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public String getDescriptionevenement() {
        return descriptionevenement;
    }

    public void setDescriptionevenement(String descriptionevenement) {
        this.descriptionevenement = descriptionevenement;
    }

    public int getNbrparticipants() {
        return nbrparticipants;
    }

    public void setNbrparticipants(int nbrparticipants) {
        this.nbrparticipants = nbrparticipants;
    }

    public int getNbrplacestotal() {
        return nbrplacestotal;
    }

    public void setNbrplacestotal(int nbrplacestotal) {
        this.nbrplacestotal = nbrplacestotal;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getNbrtickets() {
        return nbrtickets;
    }

    public void setNbrtickets(int nbrtickets) {
        this.nbrtickets = nbrtickets;
    }

    public float getPrixtickets() {
        return prixtickets;
    }

    public void setPrixtickets(float prixtickets) {
        this.prixtickets = prixtickets;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
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

    public int getNbsignal() {
        return nbsignal;
    }

    public void setNbsignal(int nbsignal) {
        this.nbsignal = nbsignal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idevenement;
        return hash;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        final Evenement other = (Evenement) obj;
        if (this.idevenement != other.idevenement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idevenement=" + idevenement + ", nomevenement=" + nomevenement + ", pays=" + pays + ", region=" + region + ", adresse=" + adresse + ", datedebut=" + datedebut + ", datefin=" + datefin + ", descriptionevenement=" + descriptionevenement + ", nbrparticipants=" + nbrparticipants + ", nbrplacestotal=" + nbrplacestotal + ", payment=" + payment + ", nbrtickets=" + nbrtickets + ", prixtickets=" + prixtickets + ", nomimage=" + nomimage + ", nbrlikes=" + nbrlikes + ", nbrdislikes=" + nbrdislikes + ", nbsignal=" + nbsignal + '}';
    }
                                
    
}
