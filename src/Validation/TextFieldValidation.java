/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.time.LocalDate;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Marwa
 */
public class TextFieldValidation {
    public static boolean isTexteFieldNoEmpty(TextField tf){
    boolean b = false ;
    if (tf.getText().length() != 0 || !tf.getText().isEmpty())
        b = true ;
    return b ;
    }
    
    
    public static boolean isTexteFieldNoEmpty(TextField tf , Label lb , String errorMessage){
    boolean b = true ;
    String msg = null ;
    
    if ( !isTexteFieldNoEmpty(tf)) { 
    b = false ;
    msg = errorMessage;
    }
    lb.setText(msg);
  return b ;
    }
      public static boolean isTexteFieldTypeNumber(TextField tf){
    boolean b = false ;
    if (tf.getText().matches("([0-9]+(\\.[0-9]+)?)+"))
        b = true ;
    return b ;
    } 
          public static boolean isTexteFieldTypeNumber(TextField tf , Label lb , String errorMessage){
    boolean b = true ;
    String msg = null ;
    
    if ( !isTexteFieldTypeNumber(tf)) { 
    b = false ;
    msg = errorMessage;
    }
    lb.setText(msg);
  return b ;
    }
          

              public static boolean isDateValable(LocalDate d1,LocalDate d2){
    boolean b = false ;
    if (d1.isBefore(d2))
        b = true ;
    return b ;
    }
    
    
    public static boolean isDateValable(LocalDate d1,LocalDate d2, Label lb , String errorMessage){
    boolean b = true ;
    String msg = null ;
    
    if ( !isDateValable(d1,d2)) { 
    b = false ;
    msg = errorMessage;
    }
    lb.setText(msg);
  return b ;
    }
    
    
        public static boolean isTexteFieldTypeNumberPositif(TextField tf){
    boolean b = false ;
    if (tf.getText().matches("([0-9]+(\\.[0-9]+)?)+") && Integer.parseInt(tf.getText())>0)
        b = true ;
    return b ;
    } 
          public static boolean isTexteFieldTypeNumberPositif(TextField tf , Label lb , String errorMessage){
    boolean b = true ;
    String msg = null ;
    
    if ( !isTexteFieldTypeNumberPositif(tf)) { 
    b = false ;
    msg = errorMessage;
    }
    lb.setText(msg);
  return b ;
    }
}
