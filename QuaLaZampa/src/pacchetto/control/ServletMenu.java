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

import pacchetto.model.ProdottiBean;
import pacchetto.model.ProdottiModelDM;


@WebServlet("/Menu")
public class ServletMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo= request.getParameter("tipo");
		ProdottiModelDM p= new ProdottiModelDM();
		try {
		if (tipo.equals("gatto")) {
			ArrayList<ProdottiBean> prod= p.cercaProdottoTipo(tipo);
			request.setAttribute("prodotti", prod);
		}
		
		if (tipo.equals("cane")) {
			ArrayList<ProdottiBean> prod= p.cercaProdottoTipo(tipo);
			request.setAttribute("prodotti", prod);
		}
		
		if (tipo.equals("animali piccola taglia")) {
			ArrayList<ProdottiBean> prod= p.cercaProdottoTipo(tipo);
			request.setAttribute("prodotti", prod);
		}
		
		if (tipo.equals("uccelli")) {
			ArrayList<ProdottiBean> prod= p.cercaProdottoTipo(tipo);
			request.setAttribute("prodotti", prod);
		}
		}
		catch (SQLException e) {
			System.out.println("Errore ServletMenu: " + e.getMessage());
		}
		
		RequestDispatcher dis= request.getRequestDispatcher("/ProdottiViewCategoria.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}