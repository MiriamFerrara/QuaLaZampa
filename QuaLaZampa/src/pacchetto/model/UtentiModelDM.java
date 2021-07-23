package pacchetto.model;


import java.sql.*;

public class UtentiModelDM implements UtentiDao {
private static String TABELLA_NAME = "cliente"; 

	public ClienteBean cercaUtente(String email, String password) throws SQLException {
	Connection con = null;
	PreparedStatement prep = null;
	String query = "SELECT * FROM " + TABELLA_NAME + " WHERE e_mail = ? AND password = ? " ;
	ClienteBean cliente = new ClienteBean();
	try {
		con = ConnectionPool.getConnection(); 
		prep = con.prepareStatement(query);
		prep.setString(1, email);
		prep.setString(2, password);
		
		ResultSet res  = prep.executeQuery();
		
			while(res.next()) {
			cliente.setEmail(res.getString("e_mail"));
			cliente.setPassword(res.getString("password"));
			cliente.setUsername(res.getString("username"));
			cliente.setId(res.getInt("id_cliente"));
			cliente.setAmministratore(res.getString("amministratore"));	
		}
	}finally {
		try {
			if (prep != null)
				prep.close();
		}
		finally {
			ConnectionPool.relaseConnection(con);
		}
	}
		return cliente;
	}


	public void registraUtente(String nome, String cognome, String username, String email, String password, String telefono, String cf, String via, String citta, String provincia, String cap) throws SQLException {
	Connection con =null;
	PreparedStatement pre= null;
	PreparedStatement prep= null;
	PreparedStatement prep1= null;
	String query = "INSERT INTO " + UtentiModelDM.TABELLA_NAME +" (username, e_mail, password, amministratore) VALUES (?, ?, ?, ?)";
	String query1 = "INSERT INTO dati_anagrafici (nome, cognome, telefono, cf, id_cliente_dati) VALUES (?, ?, ?, ?, (SELECT id_cliente FROM cliente WHERE id_cliente= ?))";
	String query2= "INSERT INTO indirizzo_spedizione (via, citta, provincia, cap, id_cliente_indirizzo) VALUE (?, ?, ?, ?, ?)";
	
	try {
		con = ConnectionPool.getConnection();
		pre = con.prepareStatement(query);
		pre.setString(1, username);
		pre.setString(2, email);
		pre.setString(3, password);
		pre.setString(4, "NO");
	
		pre.executeUpdate();
		
		con.commit();
		
		ClienteBean clientenew = cercaUtente(email, password); 
		prep = con.prepareStatement(query1);
		prep.setString(1, nome);
		prep.setString(2, cognome);
		prep.setString(3, telefono);
		prep.setString(4, cf);
		prep.setInt(5, clientenew.getId());
	
		prep.executeUpdate();
		
		con.commit();
		
		prep1 = con.prepareStatement(query2);
		
		prep1.setString(1, via);
		prep1.setString(2, citta);
		prep1.setString(3, provincia);
		prep1.setString(4, cap);
		prep1.setInt(5,  clientenew.getId());
		
		prep1.executeUpdate();
		
		con.commit();
		
	}finally {
		try {
			if (pre != null && prep != null && prep1 != null)
				pre.close();
				prep.close();
				prep1.close();
		}
		finally {
			ConnectionPool.relaseConnection(con);
		}
			}	
				}
	
	

	public IndirizzoSpedizioneBean cercaIndirizzo(int idcliente) throws SQLException{
		Connection con = null;
		PreparedStatement prep = null;
		String query = "SELECT * FROM indirizzo_spedizione WHERE id_cliente_indirizzo = ?  " ;
		IndirizzoSpedizioneBean indirizzo = new IndirizzoSpedizioneBean();
		try {
			con = ConnectionPool.getConnection(); 
			prep = con.prepareStatement(query);
			prep.setInt(1, idcliente);
			ResultSet res  = prep.executeQuery();
			
			while(res.next()) {
			indirizzo.setIdCliente(res.getInt("id_cliente_indirizzo"));
			indirizzo.setVia(res.getString("via"));
			indirizzo.setCittà(res.getString("citta"));
			indirizzo.setCap(res.getString("cap"));
			indirizzo.setProvincia(res.getString("provincia"));
			indirizzo.setIdSpedizione(res.getInt("id_spedizione"));
			}
			
		}finally {
				try {
					if (prep != null)
						prep.close();
				}
				finally {
					ConnectionPool.relaseConnection(con);
				}	
	}
		return indirizzo;
	}
	
	
	public DatiAnagraficiBean cercadati(int idcli) throws SQLException{
		Connection con = null;
		PreparedStatement prep = null;
		String query = "SELECT * FROM dati_anagrafici WHERE id_cliente_dati = ?  " ;
		DatiAnagraficiBean  dati =  new DatiAnagraficiBean() ;
	
		try {
			con = ConnectionPool.getConnection(); 
			prep = con.prepareStatement(query);
			prep.setInt(1, idcli);
			
			ResultSet res = prep.executeQuery();
			
			while(res.next()) {
				dati.setNome(res.getString("nome"));
				dati.setCognome(res.getString("cognome"));
				dati.setTelefono(res.getString("telefono")) ;
			}
			
		}finally {
			try {
				if (prep != null)
					prep.close();
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}	
		}

		return dati;

	}
	
	public boolean cercaAmministratore(String email, String password) throws SQLException {
		Connection con = null;
		PreparedStatement prep = null;
		String query = "SELECT * FROM " + TABELLA_NAME + " WHERE e_mail = ? AND password = ? " ;
		boolean trovato = false;
		ClienteBean cliente = new ClienteBean();
		try {
			con = ConnectionPool.getConnection(); 
			prep = con.prepareStatement(query);
			prep.setString(1, email);
			prep.setString(2, password);
			
			ResultSet res  = prep.executeQuery();
			
				while(res.next()) {
				cliente.setEmail(res.getString("e_mail"));
				cliente.setPassword(res.getString("password"));
				cliente.setUsername(res.getString("username"));
				cliente.setId(res.getInt("id_cliente"));
				cliente.setAmministratore(res.getString("amministratore"));	
			}
				if(cliente.getAmministratore().equals("SI")){
					trovato = true;
				}
		}finally {
			try {
				if (prep != null)
					prep.close();
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}
			return trovato;
		}
	
	public int ricercaCliente(String nome) throws SQLException {
		Connection con = null;
		PreparedStatement prep = null;
		String query = "SELECT id_cliente FROM " + TABELLA_NAME + " WHERE username = ? " ;
		int id=0; 
	try {
		con = ConnectionPool.getConnection(); 
		prep = con.prepareStatement(query);
		prep.setString(1, nome);
		
		ResultSet result = prep.executeQuery();
		while(result.next()) {
			id= result.getInt("id_cliente");
		}
	}finally {
		try {
				if (prep != null)
					prep.close();
			}
			finally {
				ConnectionPool.relaseConnection(con);
			}
		}
			return id;
}
					}
