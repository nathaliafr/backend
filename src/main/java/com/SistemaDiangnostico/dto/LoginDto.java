package com.SistemaDiangnostico.dto;

import com.SistemaDiangnostico.model.Usuario;

public class LoginDto {
	
	private String email;
	private String senha;
	
	public LoginDto (Usuario usuario) {
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
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
