package com.SistemaDiangnostico.dto;

import java.io.Serializable;

import com.SistemaDiangnostico.model.Doenca;

public class DoencaDto implements Serializable {

	private static final long serialVersionUID = -7322330394386401838L;

	private Long idDoenca;
	private String nome;

	public DoencaDto(Doenca doenca) {
		this.idDoenca = doenca.getIdDoenca();
		this.nome = doenca.getNome();
	}

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
