package model.domain;

import exceptions.ChassiInvalidoException;
import exceptions.PortoInvalidoException;

public class Veiculo extends Carga {
	

	private String chassi;
	private String montadora;
	private String modelo;
	
	@Override
	public String retornaNavio() {
		return "O navio do veiculo "+this.chassi+" é o "+super.getNavio()+ "!";
	}
	
	public Veiculo(String navio, String documento, String porto) throws PortoInvalidoException {
		super(navio, documento, porto);

	}
		
	
	public Veiculo(String navio, String documento, String porto, String chassi, String montadora, String modelo) {
		this();
		this.chassi = chassi;
		this.montadora = montadora;
		this.modelo = modelo;
	}
	
	
	@Override
	public String toString() {
		String sb = ";" +
				this.chassi +
				";" +
				this.montadora +
				";" +
				this.modelo;
		return super.toString()+ sb;
	}
	

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) throws ChassiInvalidoException {
			
		if (chassi.length() != 17) {
			throw new ChassiInvalidoException("Chassi inválido!");
		}
		
		this.chassi = chassi;
	}
	
	
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	
	

}
