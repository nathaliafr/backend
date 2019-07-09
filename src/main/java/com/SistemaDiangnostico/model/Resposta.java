package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta {

	@Id
	@GeneratedValue
	private Long id;
	private String texto;
	private Long idQuestao;
	private Long idDiagnostico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public Long getIdResposta() {
		return id;
	}

	public void setIdResposta(Long idResposta) {
		this.id = idResposta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

}
