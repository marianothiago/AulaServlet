package br.fat.aulaservlet.model;

public class Aluno {
	
	private String nome, matricula, email, tel;

	public Aluno(String nome, String mat, String email, String tel)
	{
		
		this.nome = nome;
		this.matricula = mat;
		this.email = email;
		this.tel = tel;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	

}
