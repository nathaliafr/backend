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
@Table(name = "questionario")
public class Questionario {

	@Id
	@GeneratedValue
	private Long idQuestionario;
	
	@OneToOne
	@JoinColumn(name = "idCrianca")
	private Crianca criança;
	
	@OneToMany
	@JoinColumn(name = "idQuestionario")
	private List<Diagnostico> diagnostico;
	
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

	public List<Diagnostico> getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(List<Diagnostico> diagnostico) {
		this.diagnostico = diagnostico;
	}

	 

	 
}
