package Controlleur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import Model.Categorie;
import Model.Produit;
import Model.Sortie;

public class prodtcntrl {
	
	Base bdd;
	Connection connc;
	ResultSet resultat;
	
	Statement stat;
	
		public prodtcntrl()
		{
			bdd = new Base();
		}

	
	 public void enregistreprdt(Produit prdt)
	 
	 {     
		 bdd = new Base();
		 connc = bdd.conn();
		 try 
		 {
		    PreparedStatement ps =  connc.prepareStatement("insert into produit(nom_produit,categorie,posologie,quantite) VALUES (?,?,?,?)");
		    ps.setString(1, prdt.getNom_produit());
		    ps.setString(2, prdt.getCategorie());
		    ps.setString(3, prdt.getPosologie());
		    ps.setInt(4, prdt.getQuantite());
		    
		    ps.executeUpdate();
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d enregistr"+ex.getMessage());
		 	}
	 }
	 public boolean verificationProduit(String nom){
         Boolean verifie=false;
         try{
        	 bdd = new Base();
             stat = bdd.conn().createStatement();
                resultat = stat.executeQuery(" select * from produit where nom_produit = "+nom+"");
                if(resultat.next())
                    verifie = true;
                    else
                    verifie = false;
         
         }       catch(SQLException e){
             System.out.println(" erreur de verification client "+e.getMessage());
         
         }
           return verifie;
     }
	 
	 
	 public ArrayList<Produit> ListeProduit(){
		 ArrayList<Produit> listeProduit= new ArrayList<Produit>();
		 try{
			 
			 bdd = new Base();
             stat = bdd.conn().createStatement();
             resultat = stat.executeQuery("select * from produit ");
            while(resultat.next()) {
            	Produit produit = new Produit();
            	produit.setNom_produit(resultat.getString("nom_produit"));
            	produit.setPosologie(resultat.getString("posologie"));
            	produit.setQuantite(resultat.getInt("quantite"));
            	produit.setCategorie(resultat.getString("categorie"));
            	listeProduit.add(produit);
            }
             //return listeEntree;  
       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
              
       }
		 return listeProduit; 
	 } 
	 
	 
	 public ArrayList<Produit> RechercheCategorie(String categorie){
		 ArrayList<Produit> listeProduitC= new ArrayList<Produit>();
		 try{
			
			 bdd = new Base();
             stat = bdd.conn().createStatement();
             resultat = stat.executeQuery("select * from produit where categorie "+categorie+"");
            while(resultat.next()) {
            	Produit produit = new Produit();
            	produit.setNom_produit(resultat.getString("nom_produit"));
            	produit.setPosologie(resultat.getString("posologie"));
            	produit.setQuantite(resultat.getInt("quantite"));
            	produit.setCategorie(resultat.getString("categorie"));
            	listeProduitC.add(produit);
            }
             //return listeEntree;  
       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
              
       }
		 return listeProduitC; 
	 }
	 
	 
	 
	 public ArrayList<String> ListeCategorie(){
		 ArrayList<String> listeCate= new ArrayList<String>();
		 try{
			 
			 bdd = new Base();
             stat = bdd.conn().createStatement();
             resultat = stat.executeQuery("select libelle from categorie ");
             while(resultat.next()) {
            	 listeCate.add(resultat.getString("libelle")) ;
             }       
             //return listeEntree;  
       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
              
       }
		 return listeCate; 
	 } 
}
