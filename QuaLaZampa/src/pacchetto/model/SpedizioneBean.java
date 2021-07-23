package pacchetto.model;

import java.util.Date;

public class SpedizioneBean {

	private int id_spedizione;
	private Date data_spedizione;
	private float spese;
	private String info_metodo;
	
	public SpedizioneBean() {
		id_spedizione=-1;
		data_spedizione=null;
		spese=0;
		info_metodo="";
		
	}

	public int getId_spedizione() {
		return id_spedizione;
	}

	public void setId_spedizione(int id_spedizione) {
		this.id_spedizione = id_spedizione;
	}

	public Date getData_spedizione() {
		return data_spedizione;
	}

	public void setData_spedizione(Date data_spedizione) {
		this.data_spedizione = data_spedizione;
	}

	public float getSpese() {
		return spese;
	}

	public void setSpese(float spese) {
		this.spese = spese;
	}

	public String getInfo_metodo() {
		return info_metodo;
	}

	public void setInfo_metodo(String info_metodo) {
		this.info_metodo = info_metodo;
	}
	
}
