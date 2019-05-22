/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ihebm
 */
public class Feedback {
    
    private int idfeedback;
    private Utilisateur user_id;
    public int note;
    public String descfeedback;
    public LocalDate datefeedback;

    public Feedback() {
    }

    public Feedback(int user_id, int note, String descfeedback) {
        this.user_id = new Utilisateur( user_id);
        this.note = note;
        this.descfeedback = descfeedback;
    }

    public Feedback(int idfeedback, int user_id, int note, String descfeedback, LocalDate datefeedback) {
        this.idfeedback = idfeedback;
        this.user_id = new Utilisateur(user_id);
        this.note = note;
        this.descfeedback = descfeedback;
        this.datefeedback = datefeedback;
    }

    public int getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(int idfeedback) {
        this.idfeedback = idfeedback;
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = new Utilisateur(user_id);;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getDescfeedback() {
        return descfeedback;
    }

    public void setDescfeedback(String descfeedback) {
        this.descfeedback = descfeedback;
    }

    public LocalDate getDatefeedback() {
        return datefeedback;
    }

    public void setDatefeedback(LocalDate datefeedback) {
        this.datefeedback = datefeedback;
    }

    @Override
    public String toString() {
        return "Feedback{" + "idfeedback=" + idfeedback + ", user_id=" + user_id + ", note=" + note + ", descfeedback=" + descfeedback + ", datefeedback=" + datefeedback + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idfeedback;
        hash = 53 * hash + Objects.hashCode(this.user_id);
        hash = 53 * hash + this.note;
        hash = 53 * hash + Objects.hashCode(this.descfeedback);
        hash = 53 * hash + Objects.hashCode(this.datefeedback);
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
        final Feedback other = (Feedback) obj;
        if (this.idfeedback != other.idfeedback) {
            return false;
        }
        if (this.note != other.note) {
            return false;
        }
        if (!Objects.equals(this.descfeedback, other.descfeedback)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.datefeedback, other.datefeedback)) {
            return false;
        }
        return true;
    }
    
    
}
