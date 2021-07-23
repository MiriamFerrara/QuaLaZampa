package pacchetto.control;

import java.io.IOException;

import javax.servlet.*;

import javax.servlet.annotation.*;
import javax.servlet.http.*;


import pacchetto.model.Carrello;
import pacchetto.model.ProdottiBean;
import pacchetto.model.ProdottiModelDM;


@WebServlet("/Controllo")
public class ServletProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static ProdottiModelDM prod= new ProdottiModelDM();
	
	public ServletProdotti () {
		super ();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession();
		Carrello car= (Carrello) session.getAttribute("carrello");
		if (car == null) {
			car= new Carrello();
			session.setAttribute("carrello", car);
		}
		
		synchronized (session) {
		try {
			request.setAttribute("prodotti", prod.doRetriveAll());
			request.setAttribute("descrizione", prod.doRetriveByKey(Integer.parseInt(request.getParameter("id"))));
			request.setAttribute("identificativo", Integer.parseInt(request.getParameter("id")));
			session.setAttribute("carrello", car);
		
		String azione= request.getParameter("action");
			
		if (azione != null && azione.equalsIgnoreCase("dettagli")) {
			
			RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiDescrizione.jsp");
			dis.forward(request, response);
		}
		
		if (azione != null && azione.equalsIgnoreCase("aggiungi")) {
			ProdottiBean pr= (ProdottiBean) request.getAttribute("descrizione");
			if (!car.searchProdotto(pr.getId())) {
			car.addCarrello(pr);
			}
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiCarrello.jsp");
				dis.forward(request, response);
			}
		
		if (Integer.parseInt(request.getParameter("scelta")) >= 1) {
			RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiCarrello.jsp");
			dis.forward(request, response);
		}
		
		}
		catch (Exception e) {
			System.out.println ("Error: " + e.getMessage());
		}
		
		}
		
		RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiView.jsp");
		dis.forward(request, response);
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
