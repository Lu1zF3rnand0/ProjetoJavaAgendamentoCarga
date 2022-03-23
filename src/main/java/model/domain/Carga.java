package model.domain;

import exceptions.PortoInvalidoException;

public abstract class Carga {
	private final Integer id;
	private String navio;
	private String documento;
	private String porto;

	protected static int cont = 1;

	public Carga(String navio, String documento, String porto) throws PortoInvalidoException {
		this();
		this.navio = navio;
		this.documento = documento;
		this.porto = porto;

		if (porto.length() != 5) {
			throw new PortoInvalidoException("Código do porto inválido!");
		}
	}

	public Carga() {
		this.id = cont++;
	}

	@Override
	public String toString() {
		return this.navio +
				";" +
				this.documento +
				";" +
				this.porto;
	}

	public abstract String retornaNavio();

	public Integer getId() {
		return id;
	}

	public String getNavio() {
		return navio;
	}

	public String getDocumento() {
		return documento;
	}

	public String getPorto() {
		return porto;
	}

}
