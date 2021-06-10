package com.generation.redeSocialG2.model;



public class UserLoginModel 
{
	//atributos 
	
	//Aqui n colocamos annotation @NotNull porque devolvemos dados ao usuario ja armazenados.
	private String nomeCompleto;
	
	private String email;
	
	private String senha;
	
	private String token;
	
	//encapsulamento
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	
}
