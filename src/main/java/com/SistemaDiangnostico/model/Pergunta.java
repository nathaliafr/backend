package com.SistemaDiangnostico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta {

	@Id
	@GeneratedValue
	private Long idPergunta;
	private String texo;

	@OneToMany
	@JoinColumn(name = "IdPergunta")
	private List<Resposta> respostas;

	@OneToOne
	@JoinColumn(name = "idDoenca")
	private Doenca doenca;

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
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
