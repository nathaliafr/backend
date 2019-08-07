package com.SistemaDiangnostico.dto;

import java.io.Serializable;
import java.util.List;

public class GraficoResultadoDto implements Serializable{

	 
	private static final long serialVersionUID = 1601472354660260392L;
	
	private List<ValorDePorcentagemDoenca> graficoDados;

	public List<ValorDePorcentagemDoenca> getGraficoDados() {
		return graficoDados;
	}

	public void setGraficoDados(List<ValorDePorcentagemDoenca> graficoDados) {
		this.graficoDados = graficoDados;
	}
}
