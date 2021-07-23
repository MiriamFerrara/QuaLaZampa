package pacchetto.model;

public class DatiAnagraficiBean {

	String nome;
	String cognome;
	String telefono;
	String cf;
	int id;
	
	public DatiAnagraficiBean() {
		nome="";
		cognome="";
		telefono="";
		cf="";
		id=-1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
