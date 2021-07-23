package pacchetto.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.OrdiniModelDM;
import pacchetto.model.ProdottiBean;


@WebServlet("/InformazioniProdotto")
public class ServletInformazioniProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletInformazioniProdotto() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id= Integer.parseInt(request.getParameter("id"));
		OrdiniModelDM ordini= new OrdiniModelDM();
		try {
			ProdottiBean bean= ordini.ricercaInformazioniProdotto(id);
			request.setAttribute("informazioni prodotto", bean);
			
			int quant= ordini.ricercaQuantitaProdotto(id);
			request.setAttribute("quantit", quant);
			
			
		} catch (SQLException e) {
			System.out.println("Errore nella servlet InformazioniProdotto " + e.getMessage());
			
		}
		RequestDispatcher dis= request.getRequestDispatcher("InformazioneProdotto.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
