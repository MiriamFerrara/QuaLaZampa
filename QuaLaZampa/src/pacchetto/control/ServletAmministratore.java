package pacchetto.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ClienteBean;
import pacchetto.model.ProdottiBean;
import pacchetto.model.ProdottiModelDM;

@WebServlet("/Amministratore")
public class ServletAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottiModelDM prod= new ProdottiModelDM();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("prodotti", prod.doRetriveAll());
			ClienteBean cerca= (ClienteBean) request.getSession().getAttribute("accedi");
			request.setAttribute("admin", cerca);
			
			String azione= request.getParameter("action");
			if (azione != null && azione.equalsIgnoreCase("dettagli")) {
			request.setAttribute("des", prod.doRetriveByKey(Integer.parseInt(request.getParameter("id"))));	
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiDesAmministratore.jsp");
				dis.forward(request, response);
			}
			
			if (azione != null && azione.equalsIgnoreCase("modifica")) {
				request.setAttribute("modifica", prod.doRetriveByKey(Integer.parseInt(request.getParameter("id"))));	
				
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/ModificaAmministratore.jsp");
				dis.forward(request, response);		
			}
			
			if (azione != null && azione.equalsIgnoreCase("aggiungi")) {
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/AggiungiProdAdmin.jsp");
				dis.forward(request, response);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dis= getServletContext().getRequestDispatcher("/PageAmministratore.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
