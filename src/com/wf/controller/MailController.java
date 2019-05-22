/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.I;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MailController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private TextField sujet;
    @FXML
    private TextArea message;
    @FXML
    private Button btnEnvoyer;
String address;
String Sujet;
String messag;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        // TODO
    }   
    @FXML
    public void sendmail(){
//    String fromm;
//        fromm = address=mail.getText();

        System.out.println(message.getText());
        System.out.println(sujet.getText());
        System.out.println(mail.getText());
        
        try{
            String host ="smtp.gmail.com" ;
            String user = "worldfriendship.esprit@gmail.com";
            String pass = "123456abc++";
    //          String user = "jardetna@gmail.com";
//          String pass = "AZERTY789";
            
            String to = "worldfriendship.esprit@gmail.com";
            String from = mail.getText();
            String subject =sujet.getText() ;
            String messageText =message.getText();
            boolean sessionDebug = false;
Properties props = System.getProperties();
 props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port","587");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls.required","true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            //msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
           
           
           
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Envoi Email");
            alert.setContentText("L'email a été bien envoyé" );
            alert.setHeaderText(null);
            alert.showAndWait();
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
        
//    public void sendMail() throws AddressException, MessagingException
//    {         Sujet=sujet.getText();
//                 address=mail.getText();
//                 messag=message.getText();
//
//     btnEnvoyer.setOnMouseClicked((MouseEvent event) -> {
//         
//     
//        String from="houssem.bouzrati@esprit.tn";
//        String passwd="183JMT3312";
//        
//        String[] to ={address};
//        String host="smtp.gmail.com";
//        
//        Properties prop=System.getProperties();
//        prop.put("mail.smtp.startls.enable","true");
//        prop.put("mail.smtp.host",host);
//        prop.put("mail.smtp.user",from);
//        prop.put("mail.smtp.password",passwd);
//        prop.put("mail.smtp.port","587");
//        prop.put("mail.smtp.auth","true");
//        
//        Session session=Session.getDefaultInstance(prop);
//        MimeMessage msg= new MimeMessage(session);
//         try {
//             msg.setFrom(new InternetAddress(from));
//         } catch (AddressException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (MessagingException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//InternetAddress[] toaddresses=new InternetAddress[to.length];
//for(int i=0;i<to.length;i++)
//{
//            try {
//                toaddresses[1]=new InternetAddress(to[i]);
//            } catch (AddressException ex) {
//                Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//}
//for(int i=0;i<toaddresses.length;i++)
//{
//            try {
//                msg.setRecipient(Message.RecipientType.TO, toaddresses[i]);
//            } catch (MessagingException ex) {
//                Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//}
//         try {
//             msg.setSubject(Sujet);
//         } catch (MessagingException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         try {
//             msg.setContent(messag,"text/html; charset=utf-8");
//         } catch (MessagingException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//        Transport transport = null;
//         try {
//             transport = session.getTransport("smtp");
//         } catch (NoSuchProviderException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         try {
//             transport.connect(host, from, passwd);
//         } catch (MessagingException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         try {
//             transport.sendMessage(msg, msg.getAllRecipients());
//         } catch (MessagingException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         try {
//             transport.close();
//         } catch (MessagingException ex) {
//             Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//        System.out.println("message send successfully");
//    
//    });
//             }
//    
}
