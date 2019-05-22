/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.entity.ProfitePub;
import com.wf.entity.Pub;
import com.wf.entity.Utilisateur;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public class ProfitePubService implements IService<ProfitePub> {
   private static ProfitePubService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public ProfitePubService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ProfitePub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static ProfitePubService getInstance() {
         if(instance==null) 
            instance = new ProfitePubService();
        return instance;
     }
    @Override
    public void insert(ProfitePub o) {
   String req="insert into profitepub (pub_id,user_id) values ('"+o.getP1().getIdpublicite()+"','"+o.getU1().getId()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void delete(ProfitePub o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProfitePub> displayAll() {
        String req="select * from profitepub";
        ObservableList<ProfitePub> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
//                Utilisateur u1 = new Utilisateur();
//                Pub p1=new Pub();
                ProfitePub p=new ProfitePub();
//                p1.setIdpublicite(rs.getInt(1));
//                u1.setId(rs.getInt(1));
                p.setP1(rs.getInt("pub_id"));
                p.setU1(rs.getInt("user_id"));
//                p.setP1(p1.setIdpublicite(rs.getInt(1)));
//                p.setU1(rs.getString("nomevenement"));
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   }

    @Override
    public ProfitePub displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProfitePub os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public List<ProfitePub>  displayAll1(int id){
        String req="select * from profitepub where user_id ="+id+"";
        List<ProfitePub> list=new ArrayList<>();

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
//                Utilisateur u1 = new Utilisateur();
//                Pub p1=new Pub();
                ProfitePub p=new ProfitePub();
//                p1.setIdpublicite(rs.getInt(1));
//                u1.setId(rs.getInt(1));
                p.setP1(rs.getInt("pub_id"));
                p.setU1(rs.getInt("user_id"));
//                p.setP1(p1.setIdpublicite(rs.getInt(1)));
//                p.setU1(rs.getString("nomevenement"));
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   }
    
    
    
}
