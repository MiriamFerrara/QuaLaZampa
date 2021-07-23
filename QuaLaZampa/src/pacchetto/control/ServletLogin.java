package pacchetto.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ClienteBean;
import pacchetto.model.UtentiModelDM;


@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  public ServletLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtentiModelDM user = new UtentiModelDM();
		String email = request.getParameter("email");
		String pw = request.getParameter("password");
		PrintWriter out= response.getWriter();
		
		try{
				ClienteBean cerca = user.cercaUtente(email, pw);
				
				if(cerca.getId() == -1) {
					out.print("Nulla");
				}
					
				if((cerca.getId() != -1) && (user.cercaAmministratore(email, pw))) {
					request.getSession().setAttribute("accedi", cerca);
					out.print("Admin");
					}
				if((cerca.getId() != -1) && !(user.cercaAmministratore(email, pw))) {
					request.getSession().setAttribute("accedi", cerca);
					out.print("Utente");
				}
				
			}
		catch(Exception e) {
			System.out.println("Error ServletLogin: " + e.getMessage());	
			}
	}
}
