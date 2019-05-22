/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.util.Objects;

/**
 *
 * @author ihebm
 */
public class ReactionPub {
    
    private Pub pub_id;
    private Utilisateur user_id;
    private String Reaction;

    public ReactionPub(int pub_id, int user_id, String Reaction) {
        this.pub_id = new Pub(pub_id);
        this.user_id = new Utilisateur(user_id);
        this.Reaction = Reaction;
    }

    public ReactionPub() {
    }

    public Pub getPub_id() {
        return pub_id;
    }

    public void setPub_id(int pub_id) {
        this.pub_id = new Pub(pub_id);
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = new Utilisateur(user_id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.pub_id);
        hash = 89 * hash + Objects.hashCode(this.user_id);
        hash = 89 * hash + Objects.hashCode(this.Reaction);
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
        final ReactionPub other = (ReactionPub) obj;
        if (!Objects.equals(this.Reaction, other.Reaction)) {
            return false;
        }
        if (!Objects.equals(this.pub_id, other.pub_id)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        return true;
    }

    public String getReaction() {
        return Reaction;
    }

    public void setReaction(String Reaction) {
        this.Reaction = Reaction;
    }

    @Override
    public String toString() {
        return "ReactionPub{" + "pub_id=" + pub_id + ", user_id=" + user_id + ", Reaction=" + Reaction + '}';
    }
   
    
    
}
