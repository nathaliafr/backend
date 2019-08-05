package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Criterio_Doenca")
public class CriterioDoenca {
	
	@Id
	private Long idCriterio;
	
	private Long idDoenca;
	
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
