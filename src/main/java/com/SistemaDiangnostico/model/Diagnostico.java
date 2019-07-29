package com.SistemaDiangnostico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {

	@Id
	@GeneratedValue
	private Long idDiagnostico;

	@OneToMany
	@JoinColumn(name = "idQuestionario")
	private List<Questionario> questionarios;
	@OneToMany
	@JoinColumn(name = "idResposta")
	private List<Resposta> respostas;

	
	
	public List<Questionario> getQuestionarios() {
		return questionarios;
	}

	public void setQuestionarios(List<Questionario> questionarios) {
		this.questionarios = questionarios;
	}

	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	 

}
