package Serv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlleur.Base;
import Controlleur.entreectrl;
import Controlleur.prodtcntrl;
import Model.Entree;
import Model.Produit;

/**
 * Servlet implementation class prduit
 */
@WebServlet("/produit")
public class produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produit entr = new Produit();
				prodtcntrl entcl = new prodtcntrl();
		
		request.setAttribute("listeCate", entcl.ListeCategorie());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/produit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
	    	String dat = request.getParameter("date_expiration");
	    	String categorie = request.getParameter("categorie");
	    	  String posologie = request.getParameter("posologie");
	    	  
	    	  Produit produit =  new Produit();
	    	  prodtcntrl prdc= new  prodtcntrl();
	    	  
	    	  produit.setNom_produit(nom);
	    	  produit.setCategorie(categorie);
	    	  produit.setPosologie(posologie);
	    	  
	    	  prdc.enregistreprdt(produit);
	   
	    	  request.setAttribute("message", "Produit ajoute avec succès");
	    	  Produit entr = new Produit();
	    	  prodtcntrl entcl = new prodtcntrl();
	    	  request.setAttribute("listeCate", entcl.ListeCategorie());
	      	  request.setAttribute("message", "Produit enregistré avec succès");
	    	  this.getServletContext().getRequestDispatcher("/WEB-INF/produit.jsp").forward(request, response);
	
	}
	 
}
