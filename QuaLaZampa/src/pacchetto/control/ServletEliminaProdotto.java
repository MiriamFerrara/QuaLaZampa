package pacchetto.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pacchetto.model.Carrello;
import pacchetto.model.ProdottiBean;


@WebServlet("/EliminaProdotto")
public class ServletEliminaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletEliminaProdotto() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrello car= (Carrello) request.getSession().getAttribute("carrello");
		int id=Integer.parseInt(request.getParameter("nascosto2"));
		ProdottiBean bean= car.prendiProdotto(id);
		car.deleteProduct(bean);
		request.getSession().setAttribute("carrello", car);
		RequestDispatcher req= request.getRequestDispatcher("ProdottiCarrello.jsp");
		req.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
