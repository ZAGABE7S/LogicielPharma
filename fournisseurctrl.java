package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Entree;
import Model.Fournisseur;

public class fournisseurctrl {
	Base bdd;
	Connection connc;
	ResultSet resultat;
	Statement stat;
	public int q;
		public fournisseurctrl()
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
		
	
	 public void enregistreFour(Fournisseur fournisseur)
	 
	 {     
		
		 connc = bdd.conn();
		 try 
		 {
		    PreparedStatement ps =  connc.prepareStatement("insert into fournisseur(nom,contact,email,produit) VALUES (?,?,?,?)");
		    ps.setString(1, fournisseur.getNom());
		    ps.setString(2,fournisseur.getContact());
		    ps.setString(3, fournisseur.getEmail());
		    ps.setString(4, fournisseur.getProduit());
		    ps.executeUpdate();
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d enregistr"+ex.getMessage());
		 	}
	 }
	 
public void updateFour(Fournisseur fournisseur)
	 
	 {     
		
		 connc = bdd.conn();
		 try 
		 {
		    PreparedStatement ps =  connc.prepareStatement("update into fournisseur(nom,contact,email,produit) VALUES (?,?,?,?)");
		    ps.setString(1, fournisseur.getNom());
		    ps.setString(2,fournisseur.getContact());
		    ps.setString(3, fournisseur.getEmail());
		    ps.setString(4, fournisseur.getProduit());
		    ps.executeUpdate();
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d enregistr"+ex.getMessage());
		 	}
	 }
	 
	 
	 
	 public ArrayList<Fournisseur> ListeFournisseur(){
		 
			 ArrayList<Fournisseur> listeFournisseur= new ArrayList<Fournisseur>();
			 try {
			             bdd = new Base();
                         stat = bdd.conn().createStatement();
                         resultat = stat.executeQuery("select * from fournisseur ");
                         while(resultat.next()) {
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setNom(resultat.getString("nom"));
                fournisseur.setContact(resultat.getString("contact"));
                fournisseur.setEmail(resultat.getString("email"));
                fournisseur.setProduit(resultat.getString("produit"));
                fournisseur.setId(resultat.getInt("id"));
                listeFournisseur.add(fournisseur);
            }
             //return listeEntree;  
       
       } catch(SQLException e){
       
              System.out.println("erreur base de donne nom_produit "+e.getMessage());
              
       }
		 return listeFournisseur; 
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
	 
public void deleteFour(String nom)
	 
	 {     
		
		 //connc = bdd.conn();
		 try 
		 {
			 //System.out.println("Delete  From fournisseur where produit = "+nom+" ");
			 bdd = new Base();
             //stat = bdd.conn().createStatement();
              PreparedStatement ps = bdd.conn().prepareStatement("DELETE from fournisseur");
            //  ps.setString(1, nom);
            int nombr =  ps.executeUpdate();
                     System.out.println("delete"+nombr);
         
             //stat.executeUpdate("Delete  From fournisseur where produit");		 
             
		    
		 }
		 
		 	       catch(SQLException ex) { 
		 		System.out.println("erreur d enregistr"+ex.getMessage());
		 	}
	 }
	 
}


