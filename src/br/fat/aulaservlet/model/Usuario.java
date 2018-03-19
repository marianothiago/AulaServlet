package br.fat.aulaservlet.model;

public class Usuario {

	private String user, senha;
	
	public Usuario(String user, String senha) {
		this.user = user;
		this.senha = senha;
	}
	public String getUsuario() {
		return this.user;
	}
	public String getSenha() {
		return this.senha;
	}
}
