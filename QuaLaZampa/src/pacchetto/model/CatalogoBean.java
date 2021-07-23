package pacchetto.model;

public class CatalogoBean {

	private int id_catalogo;
	private String categoria;
	private int id_prodotto_catalogo;
	private String informazioni;
	private int quantita_prodotto;
	
	public CatalogoBean() {
		id_catalogo=-1;
		id_prodotto_catalogo=-1;
		quantita_prodotto=0;
		categoria="";
		informazioni="";
	}

	public int getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(int id_catalogo) {
		this.id_catalogo = id_catalogo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId_prodotto_catalogo() {
		return id_prodotto_catalogo;
	}

	public void setId_prodotto_catalogo(int id_prodotto_catalogo) {
		this.id_prodotto_catalogo = id_prodotto_catalogo;
	}

	public String getInformazioni() {
		return informazioni;
	}

	public void setInformazioni(String informazioni) {
		this.informazioni = informazioni;
	}

	public int getQuantita_prodotto() {
		return quantita_prodotto;
	}

	public void setQuantita_prodotto(int quantita_prodotto) {
		this.quantita_prodotto = quantita_prodotto;
	}
	
	
	
}
