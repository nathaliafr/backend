package com.SistemaDiangnostico.dto;


public class LoginDto {
	
	private String email;
	private String senha;
	
	 
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
