package Serv;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlleur.entreectrl;
import Controlleur.prodtcntrl;
import Model.Entree;
import Model.Produit;

/**
 * Servlet implementation class entree
 */
@WebServlet("/entree")
public class entree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public entree() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Entree entr = new Entree();
		entreectrl entcl = new entreectrl();
		request.setAttribute("listent", entcl.ListeEntree());
		request.setAttribute("listeproduit", entcl.ListeProduit());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/entree.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
    	String dat = request.getParameter("date");
    	String quantite =request.getParameter("quantite");
    	int quantit  = Integer.parseInt(quantite);
    	String username = request.getParameter("username");
    	  
    	  Entree entree =  new Entree();
    	  entreectrl ctrl= new  entreectrl();
    	  
    	  entree.setNom_produit(nom);
    	  entree.setDate(dat);
    	  entree.setQuantite(quantit);
    	  entree.setUser_name(username);
    	  
    	  ctrl.enregistreEntr(entree);
    	  ctrl.updateQuantite(nom, quantit);
    	  request.setAttribute("message", "Stock ajouté avec succès");
    	  request.setAttribute("listent", ctrl.ListeEntree());
    	  request.setAttribute("listent", ctrl.ListeEntree());
  		request.setAttribute("listeproduit", ctrl.ListeProduit());
    	  this.getServletContext().getRequestDispatcher("/WEB-INF/entree.jsp").forward(request, response);
	}

}
