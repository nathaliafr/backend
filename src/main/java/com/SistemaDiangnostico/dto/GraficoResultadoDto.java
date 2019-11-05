package com.SistemaDiangnostico.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GraficoResultadoDto implements Serializable{

	 
	private static final long serialVersionUID = 1601472354660260392L;
	
	private List<ValorDePorcentagemDoenca> graficoDados;
	private List<String> labels;
	private List<Double> data;
	private String taxaDeConfianca;
	
	 

	public List<ValorDePorcentagemDoenca> getGraficoDados() {
		return graficoDados;
	}

	public void setGraficoDados(List<ValorDePorcentagemDoenca> graficoDados) {
		this.labels =  new ArrayList<>();
		this.data =  new ArrayList<>();
		for (ValorDePorcentagemDoenca valorDePorcentagemDoenca : graficoDados) {
			labels.add(valorDePorcentagemDoenca.getDoenca().getNome());
			data.add(valorDePorcentagemDoenca.getPorcentagem());
		}
		
		this.graficoDados = graficoDados;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}

	public String getTaxaDeConfianca() {
		return taxaDeConfianca;
	}

	public void setTaxaDeConfianca(String taxaDeConfianca) {
		this.taxaDeConfianca = taxaDeConfianca;
	}
	
	
	
}
