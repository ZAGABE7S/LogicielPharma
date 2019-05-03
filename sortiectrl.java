package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Entree;
import Model.Sortie;

public class sortiectrl {
	static Base bdd;
	static Connection connc;
	ResultSet resultat;
	Statement stat;
	public int q;
		public sortiectrl()
		{
			bdd = new Base();
		}
		public void updateSQuantite(String nom,int quantite) {
			 try{
				 bdd = new Base();
                 stat = bdd.conn().createStatement();
                 resultat = stat.executeQuery("select quantite from produit where nom_produit = '"+nom+"'");
                 if(resultat.next())
                     q = resultat.getInt("quantite");
                 System.out.println(q);
                 	 q= q-quantite;
                 	System.out.println(q);
                 	System.out.println(q-quantite);
                 stat = bdd.conn().createStatement();
                 stat.executeUpdate("update  produit set quantite='"+q+"' where nom_produit = '"+nom+"'");
           
           } catch(SQLException e){
           
                  System.out.println("erreur base de donne nom_produit "+e.getMessage());
           }
		 }
		
	
	 public void enregistreSortie(Sortie sortie)
	 
	 {     
		 connc = bdd.conn();
		 try 
		 {
		    PreparedStatement ps =  connc.prepareStatement("insert into sortie(nom_produit,date,username,quantite) VALUES (?,?,?,?)");
		    ps.setString(1, sortie.getNom_produit());
		    ps.setString(2,sortie.getDate());
		    ps.setString(3, sortie.getUser_name());
		    ps.setInt(4, sortie.getQuantite());
		    ps.executeUpdate();
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d enregistr"+ex.getMessage());
		 	}
	 }
	 
public static int quantiteProduit(String  nomProduit)
	 
	 {     
		 connc = bdd.conn();
		 ResultSet resultat;
		 int quantite=0;
		 try 
		 {
		    PreparedStatement ps =  connc.prepareStatement("select quantite from produit where nom_produit=?");
		    ps.setString(1, nomProduit);
		   resultat= ps.executeQuery();
		 if(resultat.next()) {
			 quantite = resultat.getInt("quantite");
		 }
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d enregistr"+ex.getMessage());
		 	}
		 System.out.println(quantite+ "ok");
		 return quantite;
		 
	 }
	 
	 
	 public ArrayList<Sortie> ListeSortie(){
		 ArrayList<Sortie> listeSortie= new ArrayList<Sortie>();
		 try{
			 
			 bdd = new Base();
             stat = bdd.conn().createStatement();
             resultat = stat.executeQuery("select * from sortie ");
            while(resultat.next()) {
            	Sortie sortie = new Sortie();
            	sortie.setNom_produit(resultat.getString("nom_produit"));
            	sortie.setDate(resultat.getString("date"));
            	sortie.setQuantite(resultat.getInt("quantite"));
            	sortie.setUser_name(resultat.getString("username"));
            	listeSortie.add(sortie);
            }
             //return listeEntree;  
       
       } catch(SQLException e){
       
              System.out.println("erreur base de donnée nom_produit "+e.getMessage());
              
       }
		 return listeSortie; 
	 }
	 
	 public ArrayList<String> ListeProduit() {
		 ArrayList<String> listep=new ArrayList<String>();
		 try{
			 
			 bdd = new Base();
             stat = bdd.conn().createStatement();
             resultat = stat.executeQuery("select nom_produit from produit");
             while(resultat.next()) {
            	 listep.add(resultat.getString("nom_produit")) ;
             }       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
       }
		 //System.out.println(listep);
		 return listep;
	 }
	
	 
}


