package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {

	@Id
	@GeneratedValue
	private Long idDiagnostico;
	
 
	private Long idQuestionario;
	 
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

	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public Long getIdQuestionario() {
		return idQuestionario;
	}

	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}

	 

}
