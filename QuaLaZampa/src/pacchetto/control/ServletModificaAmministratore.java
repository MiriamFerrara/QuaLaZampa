package pacchetto.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ProdottiModelDM;

@WebServlet("/Modifica")
public class ServletModificaAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProdottiModelDM prod= new ProdottiModelDM();
	
    public ServletModificaAmministratore() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

		String nome= request.getParameter("nome");
		String disponibilita= request.getParameter("disponibilita");
		String descrizione = request.getParameter("descrizione");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		float iva = Float.parseFloat(request.getParameter("iva"));
		float prezzo= Float.parseFloat(request.getParameter("prezzo"));
		int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id  "+ id);
		prod.ModificaProdotto(id, nome, disponibilita, quantita, iva, descrizione, prezzo);
		}
		catch (Exception e) {
			e.getMessage();
		}
		RequestDispatcher dis= request.getRequestDispatcher("/PageAmministratore.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
