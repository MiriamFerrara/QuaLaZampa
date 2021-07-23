package pacchetto.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.Carrello;
import pacchetto.model.ClienteBean;
import pacchetto.model.OrdiniModelDM;
import pacchetto.model.UtentiModelDM;


@WebServlet("/Pagamento")
public class ServletPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date dat= new Date(System.currentTimeMillis());
		
		ClienteBean cerca= (ClienteBean) request.getSession().getAttribute("accedi");
		
		int idCliente= cerca.getId();
		
		
		OrdiniModelDM ord= new OrdiniModelDM();
		
		UtentiModelDM dm= new UtentiModelDM();
		
		try {
		request.setAttribute("telefono", dm.cercadati(idCliente));
		request.setAttribute("indirizzo", dm.cercaIndirizzo(idCliente));
		
		ord.effettuaPagamento(idCliente, "Il pagamento è avvenuto tramite carta", dat, "La spedizione è gratuita");
		Carrello car= (Carrello) request.getSession().getAttribute("carrello");
		car.delete();
		request.getSession().setAttribute("carrello", car);
		}
		catch (SQLException e) {
			System.out.println ("Errore servletpagamento: " + e.getMessage());
		}
		
		RequestDispatcher dis= request.getRequestDispatcher("/ProdottiCheckout.jsp");
		dis.forward(request, response);
	}
}