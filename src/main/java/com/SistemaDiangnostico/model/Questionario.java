package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionario")
public class Questionario {

	@Id
	@GeneratedValue
	private Long idQuestionario;
	@OneToOne
	@JoinColumn(name = "idCrianca")
	private Crianca criança;
	@OneToOne
	@JoinColumn(name = "idDoenca")
	private Doenca doenca;

	@OneToOne
	@JoinColumn(name = "idPergunta")
	private Pergunta pergunta;
	@OneToOne
	@JoinColumn(name = "idResposta")
	private Resposta resposta;

	
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

	public Crianca getCriança() {
		return criança;
	}

	public void setCriança(Crianca criança) {
		this.criança = criança;
	}

	public Long getIdQuestionario() {
		return idQuestionario;
	}

	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}

	 
}
