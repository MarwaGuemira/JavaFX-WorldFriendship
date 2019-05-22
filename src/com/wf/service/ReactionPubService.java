/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Pub;
import com.wf.entity.ReactionPub;
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
public class ReactionPubService implements IService<ReactionPub> {

       private static ReactionPubService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public ReactionPubService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReactionPubService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static ReactionPubService getInstance() {
         if(instance==null) 
            instance = new ReactionPubService();
        return instance;
     }
    @Override
    public void insert(ReactionPub o) {
   String req="insert into reactionpub (pub_id,user_id,reaction) values ('"+o.getPub_id().getIdpublicite()+"','"+o.getUser_id().getId()+"','"+o.getReaction()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void delete(ReactionPub o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReactionPub> displayAll() {
      String req="select * from reactionpub";
       List<ReactionPub> list= new ArrayList<>();

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                ReactionPub p=new ReactionPub();
                p.setPub_id(rs.getInt("pub_id"));
                p.setUser_id(rs.getInt("user_id"));
                p.setReaction(rs.getString("reaction"));

                    
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ReactionPub displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ReactionPub os) {
       String qry = "UPDATE reactionpub SET  reaction = '"+os.getReaction()+"' where  pub_id ="+os.getPub_id()+" AND user_id ="+os.getUser_id()+"";
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
        }
    
}
