package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pacote.Pais;
import service.PaisService;
/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		long pPopulacao = Long.valueOf(request.getParameter("populacao"));
		double pArea = Double.valueOf(request.getParameter("area"));
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		
		//instanciar o service
		PaisService pa = new PaisService();
		pa.criar(pais);
		pais = pa.carregar(pais.getId());
		
		request.setAttribute("pais", pais);
		RequestDispatcher view =
		request.getRequestDispatcher("Pais.jsp");
		view.forward(request, response);
		
	}


}

