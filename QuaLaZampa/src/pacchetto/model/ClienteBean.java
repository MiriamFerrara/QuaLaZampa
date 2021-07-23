package pacchetto.model;

public class ClienteBean {

	String username; 
	int id;
	String email;
	String password;
	String amministratore;
	
	public ClienteBean() {
		username="";
		id=-1;
		email="";
		password="";
		amministratore="";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(String amministratore) {
		this.amministratore = amministratore;
	}
	
	
	
	
}
