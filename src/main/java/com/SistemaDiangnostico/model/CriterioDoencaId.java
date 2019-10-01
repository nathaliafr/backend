package com.SistemaDiangnostico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CriterioDoencaId implements Serializable {
	 
 
	private static final long serialVersionUID = -3246068066612797705L;

	@Column
	private Long idCriterio;
	
	@Column 
	private Long idDoenca;

	
	
	public CriterioDoencaId(Long idCriterio, Long idDoenca) {
		super();
		this.idCriterio = idCriterio;
		this.idDoenca = idDoenca;
	}

	public Long getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Long idCriterio) {
		this.idCriterio = idCriterio;
	}

	public Long getIdDoenca() {
		return idDoenca;
	}

	public void setIdDoenca(Long idDoenca) {
		this.idDoenca = idDoenca;
	}
 
	 
	
	
}
