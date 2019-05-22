/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.util.Objects;

/**
 *
 * @author Marwa
 */
public class typereclamation {
    
    
private int id;
private String nomreclamation;

    public typereclamation() {
    }

    public typereclamation(int id) {
        this.id = id;
    }

    public typereclamation(String nomreclamation) {
        this.nomreclamation = nomreclamation;
    }

    public typereclamation(int id, String nomreclamation) {
        this.id = id;
        this.nomreclamation = nomreclamation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomreclamation() {
        return nomreclamation;
    }

    public void setNomreclamation(String nomreclamation) {
        this.nomreclamation = nomreclamation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nomreclamation);
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
        final typereclamation other = (typereclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomreclamation, other.nomreclamation)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return  nomreclamation ;
    }

 

}
