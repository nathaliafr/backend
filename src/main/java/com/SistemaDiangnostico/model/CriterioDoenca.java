package com.SistemaDiangnostico.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

 
@Entity
@Table(name="Criterio_Doenca")
public class CriterioDoenca {
	
  
	@EmbeddedId
	private CriterioDoencaId id;

	public CriterioDoencaId getId() {
		return id;
	}

	public void setId(CriterioDoencaId id) {
		this.id = id;
	}
	
}
