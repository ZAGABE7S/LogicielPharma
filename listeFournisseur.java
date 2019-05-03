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
 * Servlet implementation class listeFournisseur
 */
@WebServlet("/listeFournisseur")
public class listeFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listeFournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String produit =request.getParameter("nom");
    	//int i  = Integer.parseInt(id);
		Fournisseur entr = new Fournisseur();
		fournisseurctrl entcl = new fournisseurctrl();
		//entcl.deleteFour(produit);
		request.setAttribute("listent", entcl.ListeFournisseur());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listefournisseur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom =request.getParameter("nom");
    	//int i  = Integer.parseInt(nom);
    	Fournisseur entr = new Fournisseur();
		fournisseurctrl entcl = new fournisseurctrl();
		
    	                        entcl.deleteFour(nom);
    	System.out.println(  nom);
    	//request.setAttribute("listent", entcl.ListeFournisseur());
		//this.getServletContext().getRequestDispatcher("/WEB-INF/listefournisseur.jsp").forward(request, response);
    	response.sendRedirect("listeFournisseur");
	}

}
