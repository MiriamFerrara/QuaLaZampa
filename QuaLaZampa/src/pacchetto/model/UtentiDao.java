package pacchetto.model;

import java.sql.SQLException;

public interface UtentiDao {

	public ClienteBean cercaUtente(String email, String password) throws SQLException;
	
	public void registraUtente(String nome, String cognome, String username, String email, String password, String telefono, String cf, String via, String citta, String provincia, String cap) throws SQLException;

	public IndirizzoSpedizioneBean cercaIndirizzo(int idcliente) throws SQLException;

	public DatiAnagraficiBean cercadati(int idcli) throws SQLException;
	
	public boolean cercaAmministratore(String email, String password) throws SQLException;

	public int ricercaCliente(String nome) throws SQLException;
}
