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

import pacchetto.model.Carrello;
import pacchetto.model.ClienteBean;
import pacchetto.model.DatiAnagraficiBean;
import pacchetto.model.IndirizzoSpedizioneBean;
import pacchetto.model.OrdineBean;
import pacchetto.model.OrdiniModelDM;
import pacchetto.model.UtentiModelDM;


@WebServlet("/Ordini")
public class ServletOrdini extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletOrdini() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getSession().getAttribute("accedi")== null) {
    		RequestDispatcher dis= request.getRequestDispatcher("PageLogin.jsp");
			dis.forward(request, response);
		}
		Carrello car= (Carrello) request.getSession().getAttribute("carrello");
		
		ClienteBean bean=(ClienteBean) request.getSession().getAttribute("accedi");
		
		UtentiModelDM utenti = new UtentiModelDM();
		
		OrdiniModelDM ordini= new OrdiniModelDM();
		Date data= new Date(System.currentTimeMillis());
		String azione= request.getParameter("action");
		
		if (azione.equals("effettuaPagamento")) {
		try {
			
			
			for(int i = 0; i<car.getDimensione(); i++) {
		ordini.registraOrdine(bean.getId(), car.getCarrello().get(i).getId(), car.getCarrello().get(i).getTotPrezzo(), "acquistato", data, car.getCarrello().get(i).getQuantitaDesiderata(), car.getCarrello().get(i).getPrezzo());
			}
		}
		catch (SQLException e){
		System.out.println("Error Pagamento Ordine " + e.getMessage());
		}
		
		
		RequestDispatcher dis= request.getRequestDispatcher("Pagamento.jsp");
		dis.forward(request, response);
		}
		
		if (azione.equals("ordiniEffettuati")) {
			
			try {
				
				ArrayList<OrdineBean> ord= ordini.cercaOrdine(bean.getId());
				request.setAttribute("ordiniEffettuati", ord);
				RequestDispatcher dis= request.getRequestDispatcher("OrdiniEffettuati.jsp");
				dis.forward(request, response);
			
			}
			catch (SQLException e) {
				System.out.println ("Errore Visualizzazione Ordini Effettuati: " + e.getMessage());
			}
			
			
		}
    	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		}
}
