package com.SistemaDiangnostico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta {

	@Id
	@GeneratedValue
	private Long idPergunta;
	private String texo;
	private Long idQuestao;

	@OneToMany
	@JoinColumn(name = "idQuestao")
	private List<Resposta> respostas;


	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setResposta(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getTexo() {
		return texo;
	}

	public void setTexo(String texo) {
		this.texo = texo;
	}

}
