package pacchetto.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProdottiModel {
	
	public void doSave (ProdottiBean bean, String tipo) throws SQLException;
	
	public ProdottiBean doRetriveByKey (int code) throws SQLException;
	
	public ArrayList<ProdottiBean> doRetriveAll () throws SQLException;
	
	public void ModificaProdotto (int cod, String nome, String disponibilita, int quantita, float iva_prodotti, String descrizione, float prezzo_base) throws SQLException;
	
	public void doDelete(int id) throws SQLException;

	public ArrayList<ProdottiBean> cercaProdottoTipo (String tipo) throws SQLException;
	
}