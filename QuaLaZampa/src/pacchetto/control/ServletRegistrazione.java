package pacchetto.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ClienteBean;
import pacchetto.model.UtentiModelDM;


@WebServlet("/Registrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtentiModelDM user = new UtentiModelDM();
    
    public ServletRegistrazione() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String username= request.getParameter("username");
		String email= request.getParameter("email");
		String newPassword= request.getParameter("password");
		String ripPassword= request.getParameter("ripPassword");
		String telefono= request.getParameter("telefono");
		String cf =request.getParameter("codice");
		String provincia= request.getParameter("provincia");
		String cap= request.getParameter("cap");
		String citta= request.getParameter("citta");
		String via= request.getParameter("via");
		PrintWriter out= response.getWriter();
		
		if (newPassword.equals(ripPassword)) {
		try {
			user.registraUtente(nome, cognome, username, email, ripPassword, telefono, cf, via, citta, provincia, cap);
			ClienteBean client = user.cercaUtente(email, ripPassword) ;
			request.getSession().setAttribute("accedi", client);
			out.print("ProdottiView.jsp");
		} catch (SQLException e) {
			System.out.println ("Errore nella registrazione: " + e.getMessage());
		}
		}
		else {
			request.getSession().setAttribute("accedi", false);
		}
		
	}

}
