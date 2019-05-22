/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import java.util.List;
/**
 *
 * @author Lenovo
 */
import com.wf.entity.commentaireproduit;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 public class CommentaireService implements IService<commentaireproduit>{
private static CommentaireService instance;

 //    private Connection connection;
    private Statement ste;
   // private PreparedStatement pst;
    private ResultSet rs ;
    public CommentaireService() {
ConnectionDB cs=ConnectionDB.getInstance();     
try {
            ste=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CommentaireService getInstance(){
        if(instance==null) 
            instance=new CommentaireService();
        return instance;
    }
    @Override
    public void insert(commentaireproduit o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void AjouterComm(int idp,int iduser,String contenu)
    { String req= "insert into commentaire_produit(id_produit,user_id,contenu) values('"+idp+"','"
                     +iduser+"','"
                     +contenu+"')";
                 try {
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    public void ModifierComm(int idc,int iduser,String contenu)
    { String req= "UPDATE commentaire_produit SET contenu= '"+contenu+"' WHERE idcommentaire='"+idc+"' and user_id='"+iduser+"' ";
                 try {
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    public void delete(commentaireproduit o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<commentaireproduit> displayAll() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="SELECT * FROM commentaire_produit Order by datemisevente desc";
         ObservableList<commentaireproduit>list =FXCollections.observableArrayList();
        try {
           rs=ste.executeQuery(req);
            while(rs.next()){
            list.add(new commentaireproduit(
                            
                            
                     rs.getString("contenu")
                   
               //     rs.getString("nomimage")
                    ));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        public int idcommmmm(int idprod,int iduser,String txt) throws SQLException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="SELECT idcommentaire FROM commentaire_produit where  id_produit ='"+idprod+"'  and user_id='"+iduser+"' and user_id='"+txt+"' ";
         ObservableList<commentaireproduit>list =FXCollections.observableArrayList();
       
          return ste.executeQuery(req).getType();
           
           
            
            
         
    }


    public ResultSet AfficherAll(int idprod) throws SQLException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   String req="SELECT * FROM commentaireproduit where id_produit ='"+idprod+"' and user_id='"+iduser+"' ";
   String req="SELECT * FROM commentaire_produit where id_produit ='"+idprod+"' ";
     
//ObservableList<commentaire_produit>list =FXCollections.observableArrayList();
//        try {
         return  rs=ste.executeQuery(req);
////            while(rs.next()){
////            list.add(
////                    new commentaireproduit(
////                         rs.getInt("idcommentaire"),
////                            rs.getInt("id_produit"),
////                            rs.getInt("user_id"),
////                            
////                     rs.getString("contenu")
////                   
////               //     rs.getString("nomimage")
////                    ));
////                    }
////        } catch (SQLException ex) {
////            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        return list;
   // return null;
    }
    
    
    @Override
    public commentaireproduit displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(commentaireproduit os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}