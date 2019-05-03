package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import Model.Entree;
import Serv.entree;

public class entreectrl {
	Base bdd;
	Connection connc;
	ResultSet resultat;
	Statement stat;
	public int q;
		public entreectrl()
		{
			bdd = new Base();
		}
		public void updateQuantite(String nom,int quantite) {
			 try{
				 bdd = new Base();
                 stat = bdd.conn().createStatement();
                 resultat = stat.executeQuery("select quantite from produit where nom_produit = '"+nom+"'");
                 if(resultat.next())
                     q = resultat.getInt("quantite");
                 	 q= q+quantite;
                 	System.out.println(nom);
                 stat = bdd.conn().createStatement();
                 stat.executeUpdate("update  produit set quantite='"+q+"' where nom_produit = '"+nom+"'");
           
           } catch(SQLException e){
           
                  System.out.println("erreur base de donne nom_produit "+e.getMessage());
           }
		 }
		
	
	 public void enregistreEntr(Entree entree)
	 
	 {     
		
		 connc = bdd.conn();
		 try 
		 {
		    PreparedStatement ps =  connc.prepareStatement("insert into entree(nom_produit,date,username,quantite) VALUES (?,?,?,?)");
		    ps.setString(1, entree.getNom_produit());
		    ps.setString(2,entree.getDate());
		    ps.setString(3, entree.getUser_name());
		    ps.setInt(4, entree.getQuantite());
		    ps.executeUpdate();
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d'enregistr"+ex.getMessage());
		 	}
	 }
	 
	 public ArrayList<Entree> ListeEntree(){
		 
			 ArrayList<Entree> listeEntree= new ArrayList<Entree>();
			 try {
			             bdd = new Base();
                         stat = bdd.conn().createStatement();
                         resultat = stat.executeQuery("select * from entree ");
                         while(resultat.next()) {
            	Entree entree = new Entree();
            	entree.setNom_produit(resultat.getString("nom_produit"));
            	entree.setDate(resultat.getString("date"));
            	entree.setQuantite(resultat.getInt("quantite"));
            	entree.setUser_name(resultat.getString("username"));
            	listeEntree.add(entree);
            }
             //return listeEntree;  
       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
              
       }
		 return listeEntree; 
	 }
	 
	 public ArrayList<String> ListeProduit() {
		 ArrayList<String> liste=new ArrayList<String>();
		 try{
			 
			 bdd = new Base();
             stat = bdd.conn().createStatement();
             resultat = stat.executeQuery("select nom_produit from produit ");
             while(resultat.next()) {
            	 liste.add(resultat.getString("nom_produit")) ;
             }       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
       }
		 return liste;
	 }
	
	
	 
		 
}


