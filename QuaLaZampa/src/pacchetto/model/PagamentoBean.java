package pacchetto.model;

import java.util.Date;

public class PagamentoBean {
	
	private int id_pagamento;
	private float iva_prodotto_pagamento;
	private String info_metodo;
	private Date data_pagamento;
	private float importo;
	private int quantita_pagamento;
	
	public PagamentoBean() {
		id_pagamento=-1;
		iva_prodotto_pagamento=0;
		info_metodo="";
		data_pagamento=null;
		importo=0;
		quantita_pagamento=0;
	}

	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public float getIva_prodotto_pagamento() {
		return iva_prodotto_pagamento;
	}

	public void setIva_prodotto_pagamento(float iva_prodotto_pagamento) {
		this.iva_prodotto_pagamento = iva_prodotto_pagamento;
	}

	public String getInfo_metodo() {
		return info_metodo;
	}

	public void setInfo_metodo(String info_metodo) {
		this.info_metodo = info_metodo;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public int getQuantita_pagamento() {
		return quantita_pagamento;
	}

	public void setQuantita_pagamento(int quantita_pagamento) {
		this.quantita_pagamento = quantita_pagamento;
	}
}
