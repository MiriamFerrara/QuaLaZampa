package pacchetto.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ClienteBean;

@WebServlet("/ControlloAdmin")
public class ServletControlloAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String azione= request.getParameter("azione");
		ClienteBean cerca= (ClienteBean) request.getSession().getAttribute("accedi");
		request.setAttribute("admin", cerca);
		
		if (azione!=null && azione.equalsIgnoreCase("controllo")) {
			RequestDispatcher dis= request.getRequestDispatcher("/PageAmministratore.jsp");
			dis.forward(request, response);
		}
		
		if (azione!=null && azione.equalsIgnoreCase("ordiniNominativo")) {
			RequestDispatcher dis= request.getRequestDispatcher("/ControlloOrdiniAdmin.jsp");
			dis.forward(request, response);
		}
		
		if (azione!=null && azione.equalsIgnoreCase("ordiniData")) {
			RequestDispatcher dis= request.getRequestDispatcher("/ControlloOrdiniDataAdmin.jsp");
			dis.forward(request, response);
		}
		
		if (azione == null) {
		RequestDispatcher dis= request.getRequestDispatcher("/ControlloAmministratore.jsp");
		dis.forward(request, response);
	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
