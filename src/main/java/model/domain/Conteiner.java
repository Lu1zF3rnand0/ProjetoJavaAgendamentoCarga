package model.domain;

import exceptions.PortoInvalidoException;
import exceptions.TamanhoInvalidoException;

public class Conteiner extends Carga {

	private String numero;
	private int tamanho;
	private String status;

	@Override
	public String retornaNavio() {
		return "O navio do conteiner "+this.numero+" é o "+super.getNavio()+ "!";
	}

	public Conteiner(String navio, String documento, String porto) throws PortoInvalidoException {
		super(navio, documento, porto);
	}
	
	public Conteiner(String navio, String documento, String porto, String numero, int tamanho, String status) {
		this();
		this.numero = numero;
		this.tamanho = tamanho;
		this.status = status;
	}
	
	@Override
	public String toString() {
		String sb = ";" +
				this.numero +
				";" +
				this.tamanho +
				";" +
				this.status;
		return super.toString()+ sb;
	}

	public Conteiner() {
		// TODO Auto-generated constructor stub
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) throws TamanhoInvalidoException {
		
		if (tamanho != 40 && tamanho != 20) {
			throw new TamanhoInvalidoException("Tamanho do conteiner inválido!");
		}
		
		this.tamanho = tamanho;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
