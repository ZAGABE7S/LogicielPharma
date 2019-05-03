package Controlleur;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class Base {
Connection connexion;
    
    public Base(){
        
       try{
          Class.forName("com.mysql.jdbc.Driver");
          // System.out.println("chargement pilote a reussi");
       
       }
        catch(ClassNotFoundException ex){
            System.out.println("erreur de chargement des pilotes"+ex.getMessage());
            
        }
    
    
     try{
            connexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmaciestock","root","");
            //System.out.println("la connexion a la base de donnee reussie");
   }
     catch(SQLException e){
    
                System.out.println("erreur de connection a la base de donnee"+e.getMessage());
            }
    }
    
    
    public Connection conn(){
      return connexion;
               }

}
