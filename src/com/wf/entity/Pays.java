/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

/**
 *
 * @author nermi
 */
public class Pays {
    private int id;
    private String name;
    private String phonecode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    public Pays(int id, String name, String phonecode) {
        this.id = id;
        this.name = name;
        this.phonecode = phonecode;
    }
    public Pays( String name, String phonecode) {
       
        this.name = name;
        this.phonecode = phonecode;
    } 

    @Override
    public String toString() {
        return  name ;
    }

    public Pays(String phonecode) {
        this.phonecode = phonecode;
    }
    
    public String toStringphone() {
        return  phonecode ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final Pays other = (Pays) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
