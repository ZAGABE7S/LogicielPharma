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
 * Servlet implementation class listeSortie
 */
@WebServlet("/listeSortie")
public class listeSortie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listeSortie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sortie entr = new Sortie();
		sortiectrl entcl = new sortiectrl();
		request.setAttribute("listesortie", entcl.ListeSortie());
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeSortie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
