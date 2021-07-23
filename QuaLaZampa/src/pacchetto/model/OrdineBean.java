package pacchetto.model;

import java.sql.Date;

public class OrdineBean {

	int idOrdine;
	float prezzoTot;
	String statoOrdine;
	Date dataOrdine;
	
	public OrdineBean() {
		idOrdine=-1;
		prezzoTot=0;
		statoOrdine="";
		dataOrdine=null;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public float getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(float prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public String getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(String statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	
}
