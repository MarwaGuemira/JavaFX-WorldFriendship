/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.likeevenement;
import com.wf.entity.participation_evenement;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marwa
 */
public class likeevenementService implements IService<likeevenement>{
 private static likeevenementService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public likeevenementService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static likeevenementService getInstance() {
         if(instance==null) 
            instance = new likeevenementService();
        return instance;
     }
    @Override
    public void insert(likeevenement o) {
 String req="insert into likeevenement (user_id, even_id,comment ) values ('"+o.getUser_id()+"','"+o.getEven_id()+"','"+o.getComment()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }   

    }

    @Override
    public void delete(likeevenement o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<likeevenement> displayAll() {
    String req="select * from likeevenement";
        List<likeevenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                likeevenement p = new likeevenement();
                
                p.setUser_id(rs.getInt("user_id"));
            
                p.setEven_id(rs.getInt("even_id"));
                p.setComment(rs.getString("comment"));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
         
    }

    @Override
    public likeevenement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(likeevenement os) {
        String qry = "UPDATE likeevenement SET  comment = '"+os.getComment()+"' where  even_id ="+os.getEven_id()+" AND user_id ="+os.getUser_id()+"";
        
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
