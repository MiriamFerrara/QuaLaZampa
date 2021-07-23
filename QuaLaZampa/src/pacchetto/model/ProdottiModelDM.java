package pacchetto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottiModelDM implements ProdottiModel {
	
	private static final String NAME_TABLE= "prodotti";

	@Override
	public void doSave(ProdottiBean bean, String tipo) throws SQLException {
		
		Connection con= null;
		PreparedStatement prep= null;
		PreparedStatement prep2= null;
		PreparedStatement prep3= null;
		String query= "INSERT INTO " + ProdottiModelDM.NAME_TABLE + " (nome, disponibilita, quantita, descrizione, prezzo_base, pat) VALUES (?, ?, ?, ?, ?, ?)";
		String query2= "SELECT id_prodotto, descrizione, quantita FROM prodotti WHERE nome= ?";
		String query3= "INSERT INTO catalogo (id_prodotto_catalogo, informazioni, categoria, quantita_prodotto) VALUES (?, ?, ?, ?)";
		ProdottiBean pr= new ProdottiBean();
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setString(1, bean.getNome());
			prep.setString(2, bean.getDisponibilita());
			prep.setInt(3, bean.getQuantita());
			prep.setString(4, bean.getDescrizione());
			prep.setFloat(5, bean.getPrezzo());
			prep.setString(6, bean.getPat());
			
			prep.executeUpdate();
			
			con.commit();
			
			prep2= con.prepareStatement(query2);
			prep2.setString(1, bean.getNome());
			ResultSet res= prep2.executeQuery();
			
			while (res.next()) {
				pr.setId(res.getInt("id_prodotto"));
				pr.setDescrizione(res.getString("descrizione"));
				pr.setQuantita(res.getInt("quantita"));
			}
			
			prep3= con.prepareStatement(query3);
			prep3.setInt(1, pr.getId());
			prep3.setString(2, pr.getDescrizione());
			prep3.setString(3, tipo);
			prep3.setInt(4, pr.getQuantita());
			
			prep3.executeUpdate();
			
			con.commit();
		}
		finally {
			try {
				if ((prep != null) && (prep2 != null) && (prep3 != null))
					prep.close();
					prep2.close();
					prep3.close();
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}

	}

	@Override
	public ProdottiBean doRetriveByKey(int code) throws SQLException {
		
		Connection con= null;
		PreparedStatement prep= null;
		ProdottiBean bean= new ProdottiBean ();
		
		String query= "SELECT * FROM " + ProdottiModelDM.NAME_TABLE + " WHERE id_prodotto=?";
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setInt(1, code);
			
			ResultSet res= prep.executeQuery();
			
			while (res.next()) {
				bean.setId(res.getInt("id_prodotto"));
				bean.setNome(res.getString("nome"));
				bean.setDisponibilita(res.getString("disponibilita"));
				bean.setQuantita(res.getInt("quantita"));
				bean.setIva(res.getFloat("iva_prodotti"));
				bean.setDescrizione(res.getString("descrizione"));
				bean.setPrezzo(res.getFloat("prezzo_base"));
				bean.setPat(res.getString("pat"));
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
		
		return bean;
	}

	@Override
	public ArrayList<ProdottiBean> doRetriveAll() throws SQLException {
		
		Connection con= null;
		PreparedStatement prep= null;
		ArrayList<ProdottiBean> prod= new ArrayList<ProdottiBean>();
		String query= "SELECT * FROM " + ProdottiModelDM.NAME_TABLE;
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			ResultSet res= prep.executeQuery();
			
			while (res.next()) {
				ProdottiBean pr= new ProdottiBean();
				
				pr.setId(res.getInt("id_prodotto"));
				pr.setNome(res.getString("nome"));
				pr.setDisponibilita(res.getString("disponibilita"));
				pr.setQuantita(res.getInt("quantita"));
				pr.setIva(res.getFloat("iva_prodotti"));
				pr.setDescrizione(res.getString("descrizione"));
				pr.setPrezzo(res.getFloat("prezzo_base"));
				pr.setPat(res.getString("pat"));
				
				prod.add(pr);
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
		
		return prod;
	}
	
	public void ModificaProdotto (int cod, String nome, String disponibilita, int quantita, float iva_prodotti, String descrizione, float prezzo_base) throws SQLException{
		
		Connection con= null;
		PreparedStatement prep= null;
		
		String query= "UPDATE prodotti SET nome=?, disponibilita=?, quantita=?, iva_prodotti=?, descrizione=?, prezzo_base=?"
				+ " WHERE id_prodotto=?";
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setString(1, nome);
			prep.setString(2, disponibilita);
			prep.setInt(3, quantita);
			prep.setFloat(4, iva_prodotti);
			prep.setString(5, descrizione);
			prep.setFloat(6, prezzo_base);
			prep.setInt(7, cod);
			
			prep.executeUpdate();
			
			con.commit();
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
		
	}
	
	public synchronized void doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			
		String deleteSQL = "DELETE FROM " + NAME_TABLE + " WHERE id_prodotto = ?";

		try {
			connection = ConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

		preparedStatement.executeUpdate();
		connection.commit();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				ConnectionPool.relaseConnection(connection);
			}
		}
	}
	
	public ArrayList<ProdottiBean> cercaProdottoTipo (String tipo) throws SQLException {
		
		Connection con= null;
		PreparedStatement prep= null;
		PreparedStatement prep2= null;
		String query= "SELECT id_prodotto_catalogo FROM catalogo WHERE categoria= ?";
		ArrayList<Integer> id= new ArrayList<Integer>();
		String query2= "SELECT * FROM prodotti WHERE id_prodotto= ?";
		ArrayList<ProdottiBean> prod= new ArrayList<ProdottiBean>();
		
		try {
			con= ConnectionPool.getConnection();
			prep= con.prepareStatement(query);
			prep.setString(1, tipo);
			ResultSet res= prep.executeQuery();
			
			while (res.next()) {
				id.add(res.getInt("id_prodotto_catalogo"));
			}
			
			prep2= con.prepareStatement(query2);
			
			for (int i= 0; i < id.size(); i++) {
				ProdottiBean pr= new ProdottiBean();
				prep2.setInt(1, id.get(i));
				ResultSet res2= prep2.executeQuery();
				
				while(res2.next()) {
					ProdottiBean p= new ProdottiBean();
					p.setId(res2.getInt("id_prodotto"));
					p.setNome(res2.getString("nome"));
					p.setDisponibilita(res2.getString("disponibilita"));
					p.setQuantita(res2.getInt("quantita"));
					p.setIva(res2.getFloat("iva_prodotti"));
					p.setDescrizione(res2.getString("descrizione"));
					p.setPrezzo(res2.getFloat("prezzo_base"));
					p.setPat(res2.getString("pat"));
					
					prod.add(p);
				}
			}
		}
		finally {
			try {
				if ((prep != null) && (prep2 != null)) {
					prep.close();
					prep2.close();
				}
			}
			finally{
				ConnectionPool.relaseConnection(con);
			}
		}
		
		return prod;
	}
	
}
