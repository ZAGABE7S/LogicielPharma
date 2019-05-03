package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Categorie;


public class categoriectrl {
	Base bdd;
	Connection connc;
	ResultSet resultat;
	public categoriectrl()
	{
		bdd = new Base();
	}
	 public void enregistreCate(Categorie categorie)
	 
	 {     
		
		 connc = bdd.conn();
		 try 
		 {
			 //System.out.println(categorie.getLibelle());
			 PreparedStatement ps =  connc.prepareStatement("insert into categorie(libelle,date_ca) VALUES (?,?)");
		    ps.setString(1, categorie.getLibelle());
		    ps.setString(2, categorie.getDate_ca());
		    ps.executeUpdate();
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d'enregistre"+ex.getMessage());
		 	}
	 }
}
