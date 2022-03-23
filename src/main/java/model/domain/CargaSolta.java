package model.domain;

import exceptions.MercadoriaInvalidaException;
import exceptions.PortoInvalidoException;

public class CargaSolta extends Carga {

	private String mercadoria;
	private boolean imo;
	private boolean oog;
	
	@Override
	public String retornaNavio() {
		return "O navio da mercadoria "+this.mercadoria+" é o "+super.getNavio()+ "!";
	}
	
	public CargaSolta(String navio, String documento, String porto) throws PortoInvalidoException {
		super(navio, documento, porto);
	}
	
	public CargaSolta(String mercadoria, boolean imo, boolean oog) {
		this();
		this.mercadoria = mercadoria;
		this.imo = imo;
		this.oog = oog;
	}
	
	@Override
	public String toString() {
		String sb = ";" +
				this.mercadoria +
				";" +
				this.imo +
				";" +
				this.oog;
		return super.toString()+ sb;
	}
	
	
	public CargaSolta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getMercadoria() {
		return mercadoria;
	}
	
	public void setMercadoria(String mercadoria) throws MercadoriaInvalidaException {
		
		if (mercadoria.length() > 20) {
			throw new MercadoriaInvalidaException("A mercadoria não pode conteiner mais de 20 caracteres!");
		}
		
		this.mercadoria = mercadoria;
	}
	
	public boolean isImo() {
		return imo;
	}
	public void setImo(boolean imo) {
		this.imo = imo;
	}
	public boolean isOog() {
		return oog;
	}
	public void setOog(boolean oog) {
		this.oog = oog;
	}
	
	
}
