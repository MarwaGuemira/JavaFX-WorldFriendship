/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.wf.entity.Pays;
import com.wf.entity.Region;
import com.wf.util.ConnexionSingleton;

/**
 *
 * @author nermi
 */
public class PaysRegionDao {
    Connection cnx;

    public PaysRegionDao() {
        cnx= ConnexionSingleton.getInstance().getCnx();
    }
    
     public List<Pays> findPays()
     {
         List<Pays> listpays = new ArrayList<>();
          try {
            String req = "SELECT * FROM `countries`";
            PreparedStatement pstm = cnx.prepareStatement(req);
            
            ResultSet result=pstm.executeQuery();
            while(result.next()){
                Pays p = new Pays(result.getInt("id"), result.getString("name"), result.getString("phonecode"));
                listpays.add(p);
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(PaysRegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return listpays;
     }
      public List<Pays> findPaysById(String pays)
     {
         List<Pays> listpays = new ArrayList<>();
          try {
             String req = "SELECT * from countries c, fos_user u where c.name=?";
              
              PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setString(1, pays);
            ResultSet result=pstm.executeQuery();
            while(result.next()){
                Pays p = new Pays(result.getInt("id"), result.getString("name"), result.getString("phonecode"));
                listpays.add(p);
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(PaysRegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return listpays;
     }
     public List<Region> findRegionByCountry(int id)
     {
         List<Region> listregion = new ArrayList<>();
          try {
            String req = "SELECT * FROM `states` WHERE `country_id`=? ";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            ResultSet result=pstm.executeQuery();
            while(result.next()){
                Region r = new Region(result.getInt("id"), result.getString("name"), result.getInt("country_id"));
                listregion.add(r);
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(PaysRegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return listregion;
     }
     public List<String> findCityByRegion(int id)
     {
         List<String> listcities = new ArrayList<>();
          try {
            String req = "SELECT * FROM `cities` WHERE `state_id`=? ";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            ResultSet result=pstm.executeQuery();
            while(result.next()){
               // Region r = new Region(result.getInt("id"), , result.getInt("state_id"));
                listcities.add(result.getString("name"));
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(PaysRegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return listcities;
     }
    /* public String findCodePhone(int id)
     {
     String phonecode="";
          try {
            String req = "SELECT phonecode FROM `countries` where id=?";
            PreparedStatement pstm = cnx.prepareStatement(req);
                pstm.setInt(1, id);
            
            ResultSet result=pstm.executeQuery();
            Pays p = new Pays(result.getString("phonecode"));
            phonecode=p.getPhonecode();
           
          } catch (SQLException ex) {
            Logger.getLogger(PaysRegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return phonecode;
     }*/
        public List<String> findCodePhone(int id)
     {
         List<String> phonecode = new ArrayList<>();
          try {
            String req = "SELECT phonecode FROM `countries` where `id`=? ";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            ResultSet result=pstm.executeQuery();
            while(result.next()){
               // Region r = new Region(result.getInt("id"), , result.getInt("state_id"));
                phonecode.add(result.getString("phonecode"));
            }
           
          } catch (SQLException ex) {
            Logger.getLogger(PaysRegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          return phonecode;
     }
}
