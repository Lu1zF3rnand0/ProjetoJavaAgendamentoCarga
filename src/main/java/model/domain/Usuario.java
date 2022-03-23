package model.domain;

public class Usuario {

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;

	public Usuario() {
	}
	
	@Override
	public String toString() {
		return String.format("Olá, %s (%s) %s", this.nome, this.email, this.admin ? "*" : "");
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}