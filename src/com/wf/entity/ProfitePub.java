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
public class ProfitePub {
   private Pub p1;
  private Utilisateur u1;

    public ProfitePub(int p1, int u1) {
        this.p1 = new Pub( p1);
        this.u1= new Utilisateur (u1);
    }

    public ProfitePub() {
    }

    public Pub getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = new Pub( p1) ;
    }

    public Utilisateur getU1() {
        return u1;
    }

    public void setU1(int u1) {
        this.u1 = new Utilisateur (u1);
    }

    @Override
    public String toString() {
        return "ProfitePub{" + "p1=" + p1.getIdpublicite() + ", u1=" + u1.getId() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.p1);
        hash = 59 * hash + Objects.hashCode(this.u1);
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
        final ProfitePub other = (ProfitePub) obj;
        if (!Objects.equals(this.p1, other.p1)) {
            return false;
        }
        if (!Objects.equals(this.u1, other.u1)) {
            return false;
        }
        return true;
    }
  
}
