package com.SistemaDiangnostico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Criterio_Doenca")
public class CriterioDoenca {
	
	@Id
	@GeneratedValue
	private Long idCriterioDoenca;
		
	@Column
	private Long idCriterio;
	
	@Column 
	private Long idDoenca;

	public Long getIdCriterioDoenca() {
		return idCriterioDoenca;
	}

	public void setIdCriterioDoenca(Long idCriterioDoenca) {
		this.idCriterioDoenca = idCriterioDoenca;
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
