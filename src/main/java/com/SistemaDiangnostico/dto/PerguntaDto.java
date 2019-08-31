package com.SistemaDiangnostico.dto;

import java.util.ArrayList;
import java.util.List;

import com.SistemaDiangnostico.model.Pergunta;
import com.SistemaDiangnostico.model.Resposta;

public class PerguntaDto {

	private Long idPergunta;
	private String texto;

	private List<RespostaDto> respostas;
	private DoencaDto doenca;

	private CriterioDto criterio;

	public PerguntaDto(Pergunta pergunta) {
		this.idPergunta = pergunta.getIdPergunta();
		this.texto = pergunta.getTexo();
		if (pergunta.getDoenca() != null) {
			this.doenca = new DoencaDto(pergunta.getDoenca());
		}
		this.criterio = new CriterioDto(pergunta.getCriterio());
		this.respostas = new ArrayList<RespostaDto>();

		for (Resposta resp : pergunta.getRespostas()) {
			respostas.add(new RespostaDto(resp));
		}

	}

	public PerguntaDto() {

	}

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

	public CriterioDto getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioDto criterio) {
		this.criterio = criterio;
	}

}
