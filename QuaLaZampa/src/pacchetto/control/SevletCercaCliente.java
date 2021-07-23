package pacchetto.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.DatiAnagraficiBean;
import pacchetto.model.OrdineBean;
import pacchetto.model.OrdiniModelDM;
import pacchetto.model.UtentiModelDM;


@WebServlet("/CercaCliente")
public class SevletCercaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nome = request.getParameter("nome");
	OrdiniModelDM id_ordine = new OrdiniModelDM();
	UtentiModelDM id_cliente = new UtentiModelDM();
	try{
		int id= id_cliente.ricercaCliente(nome);
		DatiAnagraficiBean dati= id_cliente.cercadati(id);
		ArrayList<OrdineBean> ordini = id_ordine.cercaOrdine(id);
		request.setAttribute("dati", dati);
		request.setAttribute("nome", ordini);
		RequestDispatcher dis= request.getRequestDispatcher("/AdminCercaCliente.jsp");
		dis.forward(request, response);
		
	}catch(SQLException e) {
		System.out.println("Error Servlet Cerca Cliente: " + e.getMessage());
	}
	}

}
