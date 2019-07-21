package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doenca")
public class Doenca {
	
	@Id
	@GeneratedValue
	private Long idDoenca;
	private String nome;
	
	public Long getIdDoenca() {
		return idDoenca;
	}
	public void setIdDoenca(Long idDoenca) {
		this.idDoenca = idDoenca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
