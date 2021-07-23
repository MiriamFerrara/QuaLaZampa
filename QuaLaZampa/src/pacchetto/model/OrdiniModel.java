package pacchetto.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public interface OrdiniModel {
	
	public void registraOrdine (int id_cliente, int id_prodotto, float prezzoTotale, String statoOrdine, Date data, int quantit, float prezzo) throws SQLException;
	
	public ArrayList<OrdineBean> cercaOrdine (int id_cliente) throws SQLException;

	public ProdottiBean ricercaInformazioniProdotto (int id_ordine) throws SQLException;
	
	public int ricercaQuantitaProdotto (int code) throws SQLException;
	
	public void effettuaPagamento (int idCliente, String metodoPagamento, Date data, String infoMetodoSpedizione) throws SQLException;
	
	public ArrayList<OrdineBean> cercaOrdineData (Date data1, Date data2) throws SQLException;
	
}