package com.SistemaDiangnostico.dto;

import java.util.List;

public class PerguntaDto {

	private Long idPergunta;
	private String texto;

 
	private List<RespostaDto> respostas;
 	private DoencaDto doenca;

// 	private CriterioDto criterio;
	  
	public Long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}

	 

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaDto> respostas) {
		this.respostas = respostas;
	}

	public DoencaDto getDoenca() {
		return doenca;
	}

	public void setDoenca(DoencaDto doenca) {
		this.doenca = doenca;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

/*	public CriterioDto getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioDto criterio) {
		this.criterio = criterio;
	}
*/
}
