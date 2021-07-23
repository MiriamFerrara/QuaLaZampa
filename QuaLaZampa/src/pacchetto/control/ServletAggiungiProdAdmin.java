package pacchetto.control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import pacchetto.model.ProdottiBean;
import pacchetto.model.ProdottiModelDM;


@WebServlet("/AggiungiProdAdmin")
@MultipartConfig (fileSizeThreshold= 1024 * 1024 * 2, maxFileSize= 1024 * 1024 * 10, maxRequestSize= 1024 * 1024 * 50)
public class ServletAggiungiProdAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String extractFileName (Part pa) {
		String context= pa.getHeader("content-disposition");
		String[] item= context.split(";");
		for (String s : item) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2, s.length() - 1);
			}
		}
		return "";
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part part= request.getPart("fileProd");
		String fileName= extractFileName (part);
		
		//Alfonso
		String savePath= "C:\\Users\\utente\\Desktop\\TSW progetto\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\" + fileName;
		
		//Miriam
		//String savePath= "C:\\Users\\Utente\\git\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\" + fileName;
		
		//Sabrina
		//String savePath= "C:\\Users\\Utente\\git\\QuaLaZampa\\Esercizio_Ferrara_Schettino_Ceccarelli\\WebContent\\image\\" + fileName;
		
		part.write(savePath + File.separator);
		
		String nomeProd= request.getParameter("nomeProd");
		String disponibilitaProd= request.getParameter("disponibilitaProd");
		int quantitaProd= Integer.parseInt(request.getParameter("quantitaProd"));
		float ivaProd= Float.parseFloat(request.getParameter("ivaProd"));
		String descrizioneProd= request.getParameter("descrizioneProd");
		float prezzoBaseProd= Float.parseFloat(request.getParameter("prezzoBaseProd"));
		String tipologia= request.getParameter("tipologia");
				
		ProdottiBean prod= new ProdottiBean ();
		
		prod.setNome(nomeProd);
		prod.setDisponibilita(disponibilitaProd);
		prod.setQuantita(quantitaProd);
		prod.setIva(ivaProd);
		prod.setDescrizione(descrizioneProd);
		prod.setPrezzo(prezzoBaseProd);
		prod.setPat(savePath);
		
		ProdottiModelDM prodotti= new ProdottiModelDM ();
		
		try {
			prodotti.doSave(prod, tipologia);
			
			RequestDispatcher dis= request.getRequestDispatcher("PageAmministratore.jsp");
			dis.forward(request, response);
		}
		catch (SQLException e) {
			System.out.println ("Errore nella ServletAggiungiProdAdmin: " + e.getMessage());
		}
		
	}

}