package pacchetto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class OrdiniModelDM implements OrdiniModel {

	
	public void registraOrdine(int id_cliente, int id_prodotto, float prezzoTotale, String statoOrdine, Date data, int quantit, float prezzo) throws SQLException {
		
		Connection con= null;
		PreparedStatement prep= null;
		PreparedStatement prep2= null;
		PreparedStatement prep3= null;
		PreparedStatement prep4= null;
		PreparedStatement prep5= null;
		String query= "INSERT INTO acquista VALUES (?, ?)";
		String query2= "INSERT INTO ordine (prezzo_totale, stato_ordine, data_ordine) VALUES (?, ?, ?)";
		String query3="SELECT id_ordine FROM ordine";
		String query4= "INSERT INTO inserito (quantita_inserito, prezzo_inserito, id_prodotto_inserito, id_ordine_inserito) VALUES (?, ?, ?, ?)";
		String query5= "INSERT INTO effettua (id_cliente_effettua, id_ordine_effettua) VALUES (?, ?)";
		int temp=0;
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setInt(1, id_cliente);
			prep.setInt(2, id_prodotto);
			
			prep.executeUpdate();
			con.commit();
			
			prep2= con.prepareStatement(query2);
			prep2.setFloat(1, prezzoTotale);
			prep2.setString(2, statoOrdine);
			prep2.setDate(3, data);
			
			prep2.executeUpdate();
			con.commit();
			
			prep3=con.prepareStatement(query3);
			ResultSet result= prep3.executeQuery();
			while(result.next()) {
				if(temp<result.getInt("id_ordine")) {
					temp=result.getInt("id_ordine");
				}
			}
			
			prep4= con.prepareStatement(query4);
			prep4.setInt(1, quantit);
			prep4.setFloat(2, prezzo);
			prep4.setInt(3, id_prodotto);
			prep4.setInt(4, temp);
			
			prep4.executeUpdate();
			con.commit();
			
			prep5= con.prepareStatement(query5);
			prep5.setInt(1, id_cliente);
			prep5.setInt(2, temp);
			
			prep5.executeUpdate();
			con.commit();
			
		}
		finally {
			try {
				if ((prep != null) && (prep2 != null) && (prep3 != null) && (prep4 != null) && (prep5 != null)) {
					prep.close();
					prep2.close();
					prep3.close();
					prep4.close();
					prep5.close();
				}
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}

	}

	
	public ArrayList<OrdineBean> cercaOrdine(int id_cliente) throws SQLException {
		
		Connection con= null;
		PreparedStatement prep= null;
		ArrayList<OrdineBean> order= new ArrayList<OrdineBean>();
		String query= "SELECT id_ordine, prezzo_totale, stato_ordine, data_ordine FROM effettua, ordine WHERE id_cliente_effettua= ? AND id_ordine_effettua=id_ordine";
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setInt(1, id_cliente);
			ResultSet res= prep.executeQuery();
			
			while (res.next()) {
				OrdineBean ordin= new OrdineBean();
				ordin.setIdOrdine(res.getInt("id_ordine"));
				ordin.setPrezzoTot(res.getFloat("prezzo_totale"));
				ordin.setStatoOrdine(res.getString("stato_ordine"));
				ordin.setDataOrdine(res.getDate("data_ordine"));
				
				order.add(ordin);
			}
		}
		finally {
			try {
				if (prep != null)
					prep.close();
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}
		
		return order;
	}

	
	public ProdottiBean ricercaInformazioniProdotto(int id_ordine) throws SQLException {
		Connection conn=null;
		PreparedStatement prep=null;
		String query= "SELECT id_prodotto, nome, iva_prodotti, descrizione, prezzo_base, pat FROM prodotti, inserito where id_ordine_inserito= ? AND id_prodotto=id_prodotto_inserito";
		ProdottiBean bean= new ProdottiBean();		
		ResultSet result= null;
		try {
			
			conn=ConnectionPool.getConnection();
			prep=conn.prepareStatement(query);
			prep.setInt(1, id_ordine);
			result= prep.executeQuery();
		while(result.next()) {
			bean.setId(result.getInt("id_prodotto"));
			bean.setNome(result.getString("nome"));
			bean.setIva(result.getFloat("iva_prodotti"));
			bean.setDescrizione(result.getString("descrizione"));
			bean.setPrezzo(result.getFloat("prezzo_base"));
			bean.setPat(result.getString("pat"));
		}
			
		}finally {
			try {
				if(prep!= null) {
					prep.close();
				}
			}finally {
				ConnectionPool.relaseConnection(conn);
			}
		}
		return bean;
	}
	
	public int ricercaQuantitaProdotto (int code) throws SQLException {
		
		int quan= 0;
		Connection con= null;
		PreparedStatement prep= null;
		String query= "select quantita_inserito from inserito where id_ordine_inserito= ?";
		ResultSet res= null;
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setInt(1, code);
			res= prep.executeQuery();
			
			while (res.next()) {
				quan= res.getInt("quantita_inserito");
			}
		}
		finally {
			
		}
		return quan;
		
	}
	
	public void effettuaPagamento (int idCliente, String metodoPagamento, Date data, String infoMetodoSpedizione) throws SQLException {
		
		Connection con= null;
		PreparedStatement prep1= null;
		PreparedStatement prep2= null;
		PreparedStatement prep3= null;
		PreparedStatement prep4= null;
		PreparedStatement prep5= null;
		PreparedStatement prep6= null;
		String query1= "SELECT id_ordine_effettua FROM effettua WHERE id_cliente_effettua=?";
		String query2= "SELECT id_ordine_pagamento FROM pagamento";
		String query3= "SELECT prezzo_totale FROM ordine WHERE id_ordine=?";
		String query4= "SELECT iva_inserito, quantita_inserito FROM inserito WHERE id_ordine_inserito=?";
		String query5= "INSERT INTO pagamento (iva_prodotto_pagamento, info_metodo, data_pagmento, importo, quantita_pagamento, id_ordine_pagamento) VALUES (?, ?, ?, ?, ?, ?)";
		String query6= "INSERT INTO spedizione (data_spedizione, spese, info_metodo, id_ordine_spedizione) VALUES (?, ?, ?, ?)";
		ArrayList<Integer> idOrdineEffettua= new ArrayList<Integer>();
		ArrayList<Integer> idOrdinePagamento= new ArrayList<Integer>();
		ArrayList<Float> prezzoTotaleOrdine= new ArrayList<Float>();
		ArrayList<Float> ivaInserito= new ArrayList<Float>();
		ArrayList<Integer> quantitaInserito= new ArrayList<Integer>();
		ArrayList<Integer> idOrdineTemporaneo= new ArrayList<Integer>();
		
		try {
			con= ConnectionPool.getConnection();
			prep1= con.prepareStatement(query1);
			prep1.setInt(1, idCliente);
			ResultSet residOrdineEffettua= prep1.executeQuery();
			
			while (residOrdineEffettua.next()) {
				idOrdineEffettua.add(residOrdineEffettua.getInt("id_ordine_effettua"));
			}
			
			prep2= con.prepareStatement(query2);
			ResultSet residOrdinePagamento= prep2.executeQuery();
			
			while (residOrdinePagamento.next()) {
				idOrdinePagamento.add(residOrdinePagamento.getInt("id_ordine_pagamento"));
			}
			
			
			if(idOrdinePagamento.size()==0) {
				for (int i= 0; i < idOrdineEffettua.size(); i++) {
					prep3= con.prepareStatement(query3);
					prep3.setInt(1, idOrdineEffettua.get(i));
					ResultSet resPrezzoTotale= prep3.executeQuery();
					
					while (resPrezzoTotale.next()) {
						prezzoTotaleOrdine.add(resPrezzoTotale.getFloat("prezzo_totale"));
					}
					
					prep4= con.prepareStatement(query4);
					prep4.setInt(1, idOrdineEffettua.get(i));
					ResultSet resIvaQuantit= prep4.executeQuery();
					
					while (resIvaQuantit.next()) {
						ivaInserito.add(resIvaQuantit.getFloat("iva_inserito"));
						quantitaInserito.add(resIvaQuantit.getInt("quantita_inserito"));
					}
				}
				
				for (int j= 0; j < ivaInserito.size(); j++) {
					prep5= con.prepareStatement(query5);
					prep5.setFloat(1, ivaInserito.get(j));
					prep5.setString(2, "Il pagamento è avvenuto tramite carta prepagata");
					prep5.setDate(3, data);
					prep5.setFloat(4, prezzoTotaleOrdine.get(j));
					prep5.setInt(5, quantitaInserito.get(j));
					prep5.setInt(6, idOrdineEffettua.get(j));
					
					prep5.executeUpdate();
					con.commit();
					
					prep6= con.prepareStatement(query6);
					prep6.setDate(1, data);
					prep6.setFloat(2, 0);
					prep6.setString(3, "La spedizione è gratuita poichè è un servizio offerto dall'attività");
					prep6.setInt(4, idOrdineEffettua.get(j));
					
					prep6.executeUpdate();
					con.commit();
				}
			}
			
			else {
				
				for(int i= 0; i < idOrdineEffettua.size(); i++) {
					boolean trovato= false;
						for (int j= 0; j < idOrdinePagamento.size(); j++) {
						if (idOrdineEffettua.get(i) == idOrdinePagamento.get(j)) {
							trovato= true;
						}
				}
					if(trovato==false) {
						idOrdineTemporaneo.add(idOrdineEffettua.get(i));
					}
					
				}
				
				
			for (int i= 0; i < idOrdineTemporaneo.size(); i++) {
					prep3= con.prepareStatement(query3);
					prep3.setInt(1, idOrdineTemporaneo.get(i));
					ResultSet resPrezzoTotale= prep3.executeQuery();
					
					while (resPrezzoTotale.next()) {
						prezzoTotaleOrdine.add(resPrezzoTotale.getFloat("prezzo_totale"));
					}
					
					prep4= con.prepareStatement(query4);
					prep4.setInt(1, idOrdineTemporaneo.get(i));
					ResultSet resIvaQuantit= prep4.executeQuery();
					
					while (resIvaQuantit.next()) {
						ivaInserito.add(resIvaQuantit.getFloat("iva_inserito"));
						quantitaInserito.add(resIvaQuantit.getInt("quantita_inserito"));
					}
				}
				
				for (int j= 0; j < ivaInserito.size(); j++) {
					prep5= con.prepareStatement(query5);
					prep5.setFloat(1, ivaInserito.get(j));
					prep5.setString(2, "Il pagamento è avvenuto tramite carta prepagata");
					prep5.setDate(3, data);
					prep5.setFloat(4, prezzoTotaleOrdine.get(j));
					prep5.setInt(5, quantitaInserito.get(j));
					prep5.setInt(6, idOrdineTemporaneo.get(j));
					
					prep5.executeUpdate();
					con.commit();
					
					prep6= con.prepareStatement(query6);
					prep6.setDate(1, data);
					prep6.setFloat(2, 0);
					prep6.setString(3, "La spedizione è gratuita poichè è un servizio offerto dall'attività");
					prep6.setInt(4, idOrdineTemporaneo.get(j));
					
					prep6.executeUpdate();
					con.commit();
				}
				
			}
		}
		finally {
			try {
				if ((prep1 != null) && (prep2 != null) && (prep3 != null) && (prep4 != null) && (prep5 != null) && (prep6 != null)) {
					prep1.close();
					prep2.close();
					prep3.close();
					prep4.close();
					prep5.close();
					prep6.close();
				}
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}
	}
	
	public ArrayList<OrdineBean> cercaOrdineData (Date data1, Date data2) throws SQLException {
	
		Connection con= null;
		PreparedStatement prep= null;
		String query= "SELECT * FROM ordine WHERE data_ordine >= ? AND data_ordine <= ?";
		ArrayList<OrdineBean> ordini= new ArrayList<OrdineBean>();
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setDate(1, data1);
			prep.setDate(2, data2);
			ResultSet res= prep.executeQuery();
			
			while (res.next()) {
				OrdineBean bean= new OrdineBean();
				bean.setIdOrdine(res.getInt("id_ordine"));
				bean.setPrezzoTot(res.getFloat("prezzo_totale"));
				bean.setStatoOrdine(res.getString("stato_ordine"));
				bean.setDataOrdine(res.getDate("data_ordine"));
				
				ordini.add(bean);
			}
		}
		finally {
			try {
				if (prep != null) {
					prep.close();
				}
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}
		
		return ordini;
		
	}

}
