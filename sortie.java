package Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlleur.entreectrl;
import Controlleur.sortiectrl;
import Model.Entree;
import Model.Sortie;

/**
 * Servlet implementation class sortie
 */
@WebServlet("/sortie")
public class sortie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sortie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Sortie sortie = new Sortie();
		sortiectrl sortiectrl = new sortiectrl();
		request.setAttribute("listesortie", sortiectrl.ListeSortie());
		request.setAttribute("listeproduit", sortiectrl.ListeProduit());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/sortie.jsp").forward(request, response);
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
    	 Sortie sortie =  new Sortie();
   	 
        	 
      		sortiectrl sortiectrl = new sortiectrl();
      		request.setAttribute("listesortie", sortiectrl.ListeSortie());
      		request.setAttribute("listeproduit", sortiectrl.ListeProduit());
      		 if(quantit>sortiectrl.quantiteProduit(nom)) {
       		  request.setAttribute("echec", "Echec: stock non disponible.");
       		  
       		  this.getServletContext().getRequestDispatcher("/WEB-INF/sortie.jsp").forward(request, response);
       	  }
      		else {
      		 sortie.setNom_produit(nom);
       	  sortie.setDate(dat);
       	  sortie.setQuantite(quantit);
       	  sortie.setUser_name(username);
       	sortiectrl.enregistreSortie(sortie);
       	sortiectrl.updateSQuantite(nom, quantit);
       	  request.setAttribute("message", "Sortie enregistré avec succès");

        	sortiectrl.quantiteProduit(nom);
        	  this.getServletContext().getRequestDispatcher("/WEB-INF/sortie.jsp").forward(request, response);
    	  }
	}

}
