package Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlleur.entreectrl;
import Controlleur.fournisseurctrl;
import Model.Entree;
import Model.Fournisseur;

/**
 * Servlet implementation class fournisseur
 */
@WebServlet("/fournisseur")
public class fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fournisseur entr = new Fournisseur();
		fournisseurctrl entcl = new fournisseurctrl();
		//request.setAttribute("listent", entcl.ListeEntree());
		request.setAttribute("listeproduit", entcl.ListeProduit());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/fournisseur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fournisseur entr = new Fournisseur();
		fournisseurctrl entcl = new fournisseurctrl();
		//request.setAttribute("listent", entcl.ListeEntree());
		request.setAttribute("listeproduit", entcl.ListeProduit());
		
		
		String nom = request.getParameter("nom");
    	String contact = request.getParameter("contact");
    	String email =request.getParameter("email");
    	String produit =request.getParameter("produit");
    	
    	  
    	  Fournisseur fournisseur =  new Fournisseur();
    	  fournisseurctrl ctrl= new fournisseurctrl();
    	  
    	  fournisseur.setNom(nom);
    	  fournisseur.setContact(contact);
    	  fournisseur.setEmail(email);
    	  fournisseur.setProduit(produit);
    	  
    	  ctrl.enregistreFour(fournisseur);
    	  //ctrl.updateQuantite(nom, quantit);
    	  request.setAttribute("message", "Stock ajoute avec succès");
    	 // request.setAttribute("listent", ctrl.ListeEntree());
    	  this.getServletContext().getRequestDispatcher("/WEB-INF/fournisseur.jsp").forward(request, response);
	}

}
