package model.domain;

public class Cliente {

	private Integer id;
	private String nome;
	private String cnpj;
	private String telefone;
	private String email;
	private Usuario usuario;
	
	protected static int cont;

	public Cliente() {
		this.id = cont++;
	}
	
	@Override
	public String toString() {
		return this.nome +
				';' +
				this.cnpj +
				';' +
				this.telefone +
				';' +
				this.email +
				';' +
				this.usuario.getNome();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
