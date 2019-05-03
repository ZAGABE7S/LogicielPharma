package Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlleur.categoriectrl;
import Controlleur.entreectrl;
import Model.Categorie;
import Model.Entree;

/**
 * Servlet implementation class categorie
 */
@WebServlet("/categorie")
public class categorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
		String date_ca = request.getParameter("date_ca"); 	  
    	  Categorie categorie =  new Categorie();
    	  categoriectrl ctrl= new  categoriectrl();
    	  
    	  categorie.setLibelle(libelle);
    	  categorie.setDate_ca(date_ca);
    	  ctrl.enregistreCate(categorie);
    	  
    	request.setAttribute("message", "Catégorie ajoute avec succès");
    	  
    	  this.getServletContext().getRequestDispatcher("/WEB-INF/categorie.jsp").forward(request, response);
	}
}
