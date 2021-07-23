package pacchetto.model;

public class ProdottiBean {
	
	int id;
	String nome;
	String disponibilita;
	int quantita;
	float iva;
	String descrizione;
	float prezzo;
	float prezzotot;
	int quantdesiderata;
	String pat;
	
	public ProdottiBean () {
		id= -1;
		nome= "";
		disponibilita= "";
		quantita= 0;
		iva= 0;
		descrizione= "";
		prezzo= 0;
		prezzotot = 0;
		quantdesiderata=0;
		pat= "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(String disponibilita) {
		this.disponibilita = disponibilita;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public float getTotPrezzo() {
		return prezzotot;
	}
	
	public void setTotPrezzo(float prezzotot) {
		this.prezzotot = prezzotot;
	}
	
	public int getQuantitaDesiderata() {
		return quantdesiderata;
	}
	
	public void setQuantitaDesiderata(int q) {
	this.quantdesiderata= q ;
	}
	
	public String getPat () {
		return pat;
	}
	
	public void setPat (String pat) {
		this.pat= pat;
	}
	
	public String toString () {
		return id + " " + nome + " " + disponibilita + " " + quantita + " " + iva + " " + descrizione + " " + prezzo;
	}

}