package com.SistemaDiangnostico.dto;

import java.io.Serializable;


public class ValorDePorcentagemDoenca implements Serializable {
	 
	private static final long serialVersionUID = 2897871891950144809L;
	private DoencaDto doenca;
	private Double porcentagem;

	public Double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public DoencaDto getDoenca() {
		return doenca;
	}

	public void setDoenca(DoencaDto doenca) {
		this.doenca = doenca;
	}

	 

}
