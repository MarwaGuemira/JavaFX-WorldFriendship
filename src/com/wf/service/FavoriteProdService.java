/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.FavoriteProduit;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class FavoriteProdService implements IService<FavoriteProduit> {
     private static FavoriteProdService instance;
      private Statement ste;
   // private PreparedStatement pst;
    private ResultSet rs ;
     public FavoriteProdService()  {
ConnectionDB cs=ConnectionDB.getInstance();     
try {
            ste=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public static FavoriteProdService getInstance(){
        if(instance==null) 
            instance=new  FavoriteProdService() ;
        return instance;
    }

    @Override
    public void insert(FavoriteProduit o) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req= "insert into FavoriteProduit (id_user,id_produit) values('"+o.getId_user()+"','"
                     +o.getProduit()+"')";
        try {
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FavoriteProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Ajouter(int iduser,int idproduit)
    {
         String req= "insert into FavoriteProduit (id_user,id_produit) values('"+iduser+"','"
                     +idproduit+"')";
        try {
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FavoriteProdService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(FavoriteProduit o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    }
    public void Effacer(int idproduit, int iduser) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  String req="DELETE FROM FavoriteProduit WHERE id_produit='"+idproduit+"' and id_user='"+iduser+"' ";
        try {
          
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FavoriteProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    @Override
    public List<FavoriteProduit> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FavoriteProduit displayById(int id) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    String req="SELECT * FROM Produit WHERE idproduit ="+id;
//         ObservableList<FavoriteProduit>list =FXCollections.observableArrayList();
//      FavoriteProduit fp =new FavoriteProduit();
//        try {
//        rs= ste.executeQuery(req);
//            while(rs.next()){
//                
////            
//  
//                    }
//        } catch (SQLException ex) {
//            Logger.getLogger(FavoriteProduit.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return fp;
//    
    }
     public boolean proddisplayById(int id,int userid) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="SELECT * FROM FavoriteProduit WHERE id_Produit ='"+id+"' and id_user='"+userid+"' ";
         //ObservableList<FavoriteProduit>list =FXCollections.observableArrayList();
      FavoriteProduit fp =new FavoriteProduit();
        try {
        rs= ste.executeQuery(req);
        
            while(rs.next()){
               return true;
                }
        } catch (SQLException ex) {
            Logger.getLogger(FavoriteProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }

    @Override
    public boolean update(FavoriteProduit os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
