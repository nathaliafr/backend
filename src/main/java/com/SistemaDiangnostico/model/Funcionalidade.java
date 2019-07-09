package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionalidade")
public class Funcionalidade {
	
	@Id
	@GeneratedValue
	private Long idFuncionalidade;
	private String nome;
	
	public Long getIdFuncionalidade() {
		return idFuncionalidade;
	}
	public void setIdFuncionalidade(Long idFuncionalidade) {
		this.idFuncionalidade = idFuncionalidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
