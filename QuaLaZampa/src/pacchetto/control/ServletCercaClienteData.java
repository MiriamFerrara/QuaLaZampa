package pacchetto.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.OrdineBean;
import pacchetto.model.OrdiniModelDM;

@WebServlet("/CercaClienteData")
public class ServletCercaClienteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String scelta= request.getParameter("dataInizio");
		String scelta2= request.getParameter("dataFine");
		Date data= Date.valueOf(scelta);
		Date data2= Date.valueOf(scelta2);
		OrdiniModelDM ordini= new OrdiniModelDM();
		ArrayList<OrdineBean> ricerca= new ArrayList<OrdineBean>();
		
		try {
			ricerca= ordini.cercaOrdineData(data, data2);
			request.setAttribute("ordine", ricerca);
			
		}
		catch (Exception e) {
			System.out.println ("Errore ServletCercaClienteData: " + e.getMessage());
		}
		
		RequestDispatcher dis= request.getRequestDispatcher("/AdminCercaClienteData.jsp");
		dis.forward(request, response);
		
		
	}

}
