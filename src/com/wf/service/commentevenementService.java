/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.commentevenement;
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
public class commentevenementService implements IService<commentevenement>{

    
    private static commentevenementService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public commentevenementService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static commentevenementService getInstance() {
         if(instance==null) 
            instance = new commentevenementService();
        return instance;
     }

    @Override
    public void insert(commentevenement o) {
        
 String req="insert into commentevenement (user_id,even_id,comment) values ('"+o.getUser_id().getId()+"','"+o.getEven_id().getIdevenement()+"','"+o.getComment()+"')";

        try {
            st.executeUpdate(req);
       } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }     }

    @Override
    public void delete(commentevenement o) {
     String req="DELETE from commentevenement where idComment="+o.getIdcomment();

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }  
   }

    @Override
    public List<commentevenement> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public commentevenement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(commentevenement os) {
        
    String qry = "UPDATE commentevenement SET  comment = '"+os.getComment()+"' where  idComment ="+os.getIdcomment()+" ";
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    
    }
     
//    public List<commentevenement> affcom(int id , int id1) {
//         
//      
//        String req="select * from  commentevenement where user_id =  " +id+ " , even_id = "+id1+"";
//                List<commentevenement> list=new ArrayList<>();
//
//         try {
//            rs=st.executeQuery(req);
//            while(rs.next()){
//               commentevenement p = new commentevenement();
//                p.setEven_id(rs.getInt("even_id"));
//                p.setUser_id(rs.getInt("user_id"));
//                p.setComment(rs.getString("comment"));
//            
//        list.add(p);
//                
//            }     
//        } catch (SQLException ex) {
//            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    
//    }
    
    public List<commentevenement> affcom(int id ) {
         
      
        String req="select * from  commentevenement where  even_id = "+id+"";
                List<commentevenement> list=new ArrayList<>();

         try {
            rs=st.executeQuery(req);
            while(rs.next()){
               commentevenement p = new commentevenement();
                p.setEven_id(rs.getInt("even_id"));
                p.setUser_id(rs.getInt("user_id"));
                p.setComment(rs.getString("comment"));
                      p.setIdcomment(rs.getInt("idComment"));
            
        list.add(p);
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
    
}
