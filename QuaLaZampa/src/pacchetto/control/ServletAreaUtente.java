package pacchetto.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ClienteBean;
import pacchetto.model.DatiAnagraficiBean;
import pacchetto.model.IndirizzoSpedizioneBean;
import pacchetto.model.UtentiModelDM;

@WebServlet("/AreaUtente")
public class ServletAreaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ClienteBean cliente = (ClienteBean)request.getSession().getAttribute("accedi");
	
	int idCliente= cliente.getId();
	
	UtentiModelDM utenti = new UtentiModelDM();
	
	try {
		IndirizzoSpedizioneBean  utentibean = utenti.cercaIndirizzo(idCliente); 
		DatiAnagraficiBean dati  = utenti.cercadati(idCliente); 

			request.setAttribute("indirizzo", dati); 

			request.setAttribute("telefono", utentibean); 
			
			request.setAttribute("email", cliente.getEmail());
			
	}catch(Exception e) {
		System.out.println("Error ServletAreaUtente: " + e.getMessage());	
		}
	
	RequestDispatcher dis =  request.getRequestDispatcher("/AreaUtente.jsp");
	dis.forward(request, response);
	}
}
