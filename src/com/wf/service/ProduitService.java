/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;


import static com.oracle.nio.BufferSecrets.instance;
import com.wf.entity.Produit;
import com.wf.entity.fos_user;
import com.wf.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Houssem
 */
public class ProduitService implements IService<Produit> {
   //  Connection con = ConnectionDB.getInstance().getCnx();
    // ObservableList<Produit> oblist = FXCollections.observableArrayList();
    private static ProduitService instance;

 //    private Connection connection;
    private Statement ste;
   // private PreparedStatement pst;
    private ResultSet rs ;
    public ProduitService() {
ConnectionDB cs=ConnectionDB.getInstance();     
try {
            ste=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProduitService getInstance(){
        if(instance==null) 
            instance=new ProduitService();
        return instance;
    }
    @Override
    public void insert(Produit t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req= "insert into produit(nomproduit,prix,categorie,descriptionproduit,nomimage,etat,datemisevente,AcptProd) values('"+t.getNomproduit()+"','"
                     +t.getPrix()+"','"
                     +t.getCategorie()+"','"
                     //+t.getCategorie()+"','"
                     +t.getDescriptionproduit()+"','"
                     +t.getNomimage()+"','"
            +t.getEtat()+"','"+t.getDatemisevente()+"','"
            +t.getAcptProd()+"'  )";
        try {
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void afficherProduit() {
                 String req="select nomproduit,prix,nomimage,categorie from Produit";

        try {
          
           ResultSet rs=ste.executeQuery(req);
           while(rs.next()){
               //rs.get type de la colonne () l'index ou nom de la colonne 
              System.out.println(
                       "Nom  : "+rs.getString(1)
                      +"Prix : "+rs.getFloat(2)
                       +"Nom Image "+rs.getString(3)
                       +"categorie: "+rs.getString(4)
              );
           }
       } catch (SQLException ex) {
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     
    @Override
        public void delete(Produit t) {
     String req="DELETE FROM produit WHERE idproduit="+t.getIdproduit();
        try {
          
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void deleteByID(int id) {
     String req="DELETE FROM produit WHERE idproduit="+id;
        try {
          
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public List<Produit> displayAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="SELECT * FROM Produit Order by datemisevente desc";
         ObservableList<Produit>list =FXCollections.observableArrayList();
        try {
           rs=ste.executeQuery(req);
            while(rs.next()){
            list.add(
                    new Produit(
                            rs.getInt("idproduit"),
                            
                     rs.getString("nomproduit"),
                    rs.getFloat("prix"),
                    rs.getString("categorie"),
                    //rs.getString("descriptionproduit"),
                      rs.getString("etat")
         //   rs.getString(LocalDate.parse("datemisevente"))
               //     rs.getString("nomimage")
                    ));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
    public List<Produit> AfficherProdNonAcpt(String AcptProd) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="SELECT * FROM Produit WHERE AcptProd ='"+AcptProd+"'Order by datemisevente desc";
         ObservableList<Produit>list =FXCollections.observableArrayList();
        try {
           rs=ste.executeQuery(req);
            while(rs.next()){
            list.add(
                    new Produit(
                     rs.getInt("idproduit"),    
                     rs.getString("nomproduit"),
                    rs.getFloat("prix"),
                    rs.getString("categorie"),
                    //rs.getString("descriptionproduit"),
                      rs.getString("etat")
         //   rs.getString(LocalDate.parse("datemisevente"))
               //     rs.getString("nomimage")
                    ));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public Produit displayById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
   String req="SELECT * FROM Produit WHERE idproduit ="+id;
         ObservableList<Produit>list =FXCollections.observableArrayList();
      Produit p =new Produit();
        try {
        rs= ste.executeQuery(req);
            while(rs.next()){
                p.setNomproduit(rs.getString("nomproduit"));
                p.setIdproduit(rs.getInt("idproduit"));
                p.setPrix(rs.getFloat("prix"));
                p.setCategorie(rs.getString("categorie"));
               p.setDescriptionproduit(rs.getString("Descriptionproduit"));
                p.setNomimage(rs.getString("nomimage"));
                p.setEtat(rs.getString("etat"));
                
                p.setDatemisevente(rs.getTimestamp("datemisevente").toLocalDateTime());
  
                    }
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }
     public Produit displayByName(String n) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
   String req="SELECT * FROM Produit WHERE nomproduit ='"+n+"'";
      
      Produit p =new Produit();
        try {
        rs= ste.executeQuery(req);
            while(rs.next()){
                p.setIdproduit(rs.getInt("idproduit"));
                p.setPrix(rs.getFloat("prix"));
                p.setCategorie(rs.getString("categorie"));
//                p.setDescriptionproduit(rs.getString("description"));
                p.setNomimage(rs.getString("nomimage"));
  
                    }
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }
   

     @Override
    public boolean update(Produit t) {
   String req="UPDATE Produit SET nomproduit= '"+t.getNomproduit()+"',descriptionproduit= '"+t.getDescriptionproduit()+"',prix='"+t.getPrix()+"',categorie='"+t.getCategorie()+"' WHERE idproduit="+t.getIdproduit();
     try {
            if (ste.executeUpdate(req) > 0) {
                System.out.println("effacer");
                return true;
                
            }
     }
            catch (SQLException ex) {
         Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
     }
         return false;
    }
    
    
        public boolean ModifAdmin( int idp,String t) {
   String req="UPDATE Produit SET AcptProd= '"+t+"' WHERE idproduit='"+idp+"'       ";
     try {
            if (ste.executeUpdate(req) > 0) {
                System.out.println("effacer");
                return true;
                
            }
     }
            catch (SQLException ex) {
         Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
     }
         return false;
    }
    
    
     public boolean Modifierprix(int i ,float t) {
   String req="UPDATE Produit SET prix= '"+t+"' where idproduit='"+i+"' ";
      try {
            if (ste.executeUpdate(req) > 0) {
                System.out.println("effacer");
                return true;
                
            }
     }
            catch (SQLException ex) {
         Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
     }
         return false;
    }
     
     
     public boolean Modifier(Produit t,int id) {
   String req="UPDATE Produit SET nomproduit= '"+t.getNomproduit()+"',descriptionproduit= '"+t.getDescriptionproduit()+"',prix='"+t.getPrix()+"',categorie='"+t.getCategorie()+"' WHERE idproduit='"+id+"' ";
     try {
            if (ste.executeUpdate(req) > 0) {
                System.out.println("effacer");
                return true;
                
            }
     }
            catch (SQLException ex) {
         Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
     }
         return false;
    }
    
        
        
    public ResultSet Afficher_All_Produit(String AcptProd ) throws SQLException{
  
               ObservableList<Produit>list =FXCollections.observableArrayList();

           String req="SELECT * FROM Produit Where AcptProd ='"+AcptProd+"'order by datemisevente desc";
           return rs=ste.executeQuery(req);
        
  }
    
    public List<Produit> AfficherMyFavoriteProduit(int iduser)
    {    ObservableList<Produit>list =FXCollections.observableArrayList(); 
 String req=  "SELECT * From produit INNER join favoriteproduit ON produit.idproduit = favoriteproduit.id_produit and produit.userid =favoriteproduit.id_user='"+iduser+"' ";
   //  String req=  "SELECT * From produit INNER LEFT OUTER join favoriteproduit ON produit.userid =favoriteproduit.id_user='"+iduser+"' ";
  
  try {
           rs=ste.executeQuery(req);
            while(rs.next()){
            list.add(
                    new Produit(
                            rs.getInt("idproduit"),    
                     rs.getString("nomproduit"),
                    rs.getFloat("prix"),
                    rs.getString("categorie"),
                    rs.getString("descriptionproduit")
               //     rs.getString("nomimage")
                    ));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
    
    
    public ResultSet Afficher_All_Produit_By_Uset(int idu) throws SQLException{
 
               ObservableList<Produit>list =FXCollections.observableArrayList();

           String req="SELECT * FROM Produit where userid ='"+idu+"' ";
           return rs=ste.executeQuery(req);

  }
    

    
   


}