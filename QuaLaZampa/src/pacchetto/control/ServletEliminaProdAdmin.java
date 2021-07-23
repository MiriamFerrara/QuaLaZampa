package pacchetto.control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.ProdottiModelDM;


@WebServlet("/EliminaProdAdmin")
public class ServletEliminaProdAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		ProdottiModelDM prod= new ProdottiModelDM();
		
		try {
			File fil= new File (prod.doRetriveByKey(id).getPat());
			fil.delete();
			prod.doDelete(id);
			RequestDispatcher dis= request.getRequestDispatcher("/PageAmministratore.jsp");
			dis.forward(request, response);
		}
		catch (SQLException e) {
			System.out.println ("Errore ServletEliminaProdAdmin: " + e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
