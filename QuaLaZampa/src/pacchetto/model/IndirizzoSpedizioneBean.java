package pacchetto.model;

public class IndirizzoSpedizioneBean {

	String via;
	String citt�;
	String provincia;
	String cap;
	int idCliente;
	int idSpedizione;
	
	public IndirizzoSpedizioneBean() {
		via="";
		citt�="";
		provincia="";
		cap="";
		idCliente=-1;
		idSpedizione=-1;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitt�() {
		return citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdSpedizione() {
		return idSpedizione;
	}

	public void setIdSpedizione(int idSpedizione) {
		this.idSpedizione = idSpedizione;
	}
	
	
}
