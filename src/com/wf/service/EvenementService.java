/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.util.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marwa
 */
public class EvenementService implements IService<Evenement>  {

   

   private static EvenementService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public EvenementService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static EvenementService getInstance() {
         if(instance==null) 
            instance = new EvenementService();
        return instance;
     }

    @Override
    public void insert(Evenement o) {
        String req="insert into evenement (nomevenement,pays,region,adresse,datedebut,datefin,descriptionevenement,nbrplacestotal,prixtickets,nomimage,typeevenement_id,user_id,gratuit) values ('"+o.getNomevenement()+"','"+o.getPays()+"','"+o.getRegion()+"','"+o.getAdresse()+"','"+o.getDatedebut()+"','"+o.getDatefin()+"','"+o.getDescriptionevenement()+"','"+o.getNbrplacestotal()+"','"+o.getPrixtickets()+"','"+o.getNomimage()+"','"+o.getTypeevenement_id()+"','"+o.getUser_id()+"','"+o.getGratuit()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void delete(Evenement o) {
       String req="DELETE from evenement where idevenement="+o.getIdevenement();

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public List<Evenement> displayAll() {
      String req="select * from Evenement";
        ObservableList<Evenement> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                    
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                     p.setNomimage(rs.getString("nomimage"));
                       p.setDatedebut(LocalDate.parse(rs.getString("datedebut"), DateTimeFormatter.ISO_DATE) );
                         p.setNbsignal(rs.getInt("nbsignal"));
                       p.setDatedebut(LocalDate.parse(rs.getString("datefin"), DateTimeFormatter.ISO_DATE) );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

      public List<Evenement> displayAllList() {
        String req="select * from Evenement";
        List<Evenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                 
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                      p.setNomimage(rs.getString("nomimage"));
                        p.setNbsignal(rs.getInt("nbsignal"));
//                      p.setDatedebut(LocalDate.parse(rs.getString("datedebut"), DateTimeFormatter.ISO_DATE) );
//                       p.setDatedebut(LocalDate.parse(rs.getString("datefin"), DateTimeFormatter.ISO_DATE) );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 

      
      public List<Evenement> displayAllListbyorganisateur(int id) {
        String req="select * from Evenement where user_id =  " +id+ "";
            ObservableList<Evenement> list=FXCollections.observableArrayList();   
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                      p.setNomimage(rs.getString("nomimage"));
                        p.setNbsignal(rs.getInt("nbsignal"));
                              p.setDatedebut(LocalDate.parse(rs.getString("datedebut"), DateTimeFormatter.ISO_DATE) );
                list.add(p);
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      
        
      public List<Evenement> displayAllListbyi(int id) {
        String req="select * from Evenement where idevenement =  " +id+ "";
            ObservableList<Evenement> list=FXCollections.observableArrayList();   
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                      p.setNomimage(rs.getString("nomimage"));
                        p.setNbsignal(rs.getInt("nbsignal"));
                list.add(p);
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      

    @Override
    public Evenement displayById(int id) {
  {       
        String req="select * from Evenement where idevenement =  " +id+ "";
           Evenement p=new Evenement();  
         try {
            rs=st.executeQuery(req);    
            while(rs.next()){
                
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
//                   p.setDatedebut(LocalDate.parse(rs.getString("datedebut"), DateTimeFormatter.ISO_DATE_TIME) );
   //p.getNbrtickets(rs.getInt("nbrtickets"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrplacestotal(rs.getInt("nbrplacestotal"));
                      p.setNomimage(rs.getString("nomimage"));
                     p.setNbrlikes(rs.getInt("nbrlikes"));
                     p.setNbrdislikes(rs.getInt("nbrdislikes"));
                       p.setNbsignal(rs.getInt("nbsignal"));
                     
               //      p.setDatefin(LocalDate.parse(rs.getString("datefin"), DateTimeFormatter.ISO_DATE) );
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }}
public Evenement displayByName(String name) {
  {       
        String req="select * from Evenement where nomevenement = "+name+"";
       
           Evenement p=new Evenement();  
         try {
            rs=st.executeQuery(req);    
            while(rs.next()){
                
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                           //            p.setDatedebut(LocalDate.parse(rs.getString("datedebut"), DateTimeFormatter.ISO_DATE) );
//
//                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
//                     p.setNbrplacestotal(rs.getInt("nbrplacestotal"));
//                      p.setNomimage(rs.getString("nomimage"));
//                     p.setNbrlikes(rs.getInt("nbrlikes"));
//                     p.setNbrdislikes(rs.getInt("nbrdislikes"));
//                     
                   //  p.setDatefin(LocalDate.parse(rs.getString("datefin"), DateTimeFormatter.ISO_DATE) );
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }}
    @Override
    public boolean update(Evenement os) {
        String qry = "UPDATE evenement SET nomevenement = '"+os.getNomevenement()+"', descriptionevenement = '"+os.getDescriptionevenement()+"', pays = '"+os.getPays()+"', region = '"+os.getAdresse()+"', adresse = '"+os.getAdresse()+"', nbrtickets = '"+os.getNbrtickets()+"' WHERE idevenement= "+os.getIdevenement();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
    
    public boolean updatenbpar(Evenement os) {
        String qry = "UPDATE evenement SET  nbrparticipants = '"+os.getNbrparticipants()+"' WHERE idevenement= "+os.getIdevenement();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
      public boolean updatenblike(Evenement os) {
        String qry = "UPDATE evenement SET  nbrlikes = '"+os.getNbrlikes()+"' WHERE idevenement= "+os.getIdevenement();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
      
      
        public boolean updatenbdislike(Evenement os) {
        String qry = "UPDATE evenement SET  nbrdislikes = '"+os.getNbrdislikes()+ "' ,nbrlikes = '"+os.getNbrlikes()+"' WHERE idevenement= "+os.getIdevenement();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
  
      public void afficherEvent() {
           String req="select * from Evenement";
        try {
           rs=st.executeQuery(req);
            while(rs.next()){
                 
                System.out.println("Evenement{ id:" + rs.getInt(1) + ", nomevenement: " + rs.getString("nomevenement")+ ", descriptionevenement: " + rs.getString("descriptionevenement") + "}");
            }
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
        }
             
        
        
    }
        public ResultSet afficherEvent1() {
                ResultSet rs = null;
                 String req="select * from Evenement";
        try {
             rs=st.executeQuery(req);
    
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
        }
            return rs;
    }
        
        
         public boolean updatenbsig(Evenement os) {
        String qry = "UPDATE evenement SET  nbsignal = '"+os.getNbsignal()+ "' ,nomevenement = '"+os.getNomevenement()+"' WHERE idevenement= "+os.getIdevenement();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
}
