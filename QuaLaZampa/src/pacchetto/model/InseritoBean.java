package pacchetto.model;

public class InseritoBean {

	float iva;
	int quantita;
	float prezzo;
	int idProdotto;
	int idOrdine;
	
	public InseritoBean() {
		iva=(float)0.22;
		quantita=0;
		prezzo=0;
		idProdotto=-1;
		idOrdine=-1;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	
}
