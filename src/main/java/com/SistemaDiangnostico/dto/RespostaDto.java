package com.SistemaDiangnostico.dto;

import com.SistemaDiangnostico.model.Resposta;

public class RespostaDto {

	private Long idResposta;
	private String texto;

	private CriterioDto criterio;

	public RespostaDto(Resposta resp) {
		this.idResposta = resp.getIdResposta();
		this.texto = resp.getTexto();
		this.criterio = new CriterioDto(resp.getCriterio());
	}

	public RespostaDto() {

	}

	public CriterioDto getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioDto criterio) {
		this.criterio = criterio;
	}

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
