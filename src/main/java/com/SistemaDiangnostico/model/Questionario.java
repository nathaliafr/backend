package com.SistemaDiangnostico.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
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
	
	@Column
	private LocalDateTime data;
	
	@OneToMany
	@JoinColumn(name = "idQuestionario")
	private List<Diagnostico> diagnostico;
	
	@OneToOne
	@JoinColumn(name = "idDoenca")
	private Doenca doenca;

	
	
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

	public List<Diagnostico> getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(List<Diagnostico> diagnostico) {
		this.diagnostico = diagnostico;
	}
 
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	 

	 
}
