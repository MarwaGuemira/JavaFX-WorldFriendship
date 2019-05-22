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
public class Region {
    private int id;
    private String name;
    private int country_id;

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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public Region(String name, int country_id) {
        this.name = name;
        this.country_id = country_id;
    }

    public Region(int id, String name, int country_id) {
        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
