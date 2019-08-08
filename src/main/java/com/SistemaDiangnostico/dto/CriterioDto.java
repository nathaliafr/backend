package com.SistemaDiangnostico.dto;

import com.SistemaDiangnostico.model.Criterio;

public class CriterioDto {

	private Long idCriterio;
	private String texto;
	
	
    
	public CriterioDto(Criterio criterio) {
		 this.idCriterio = criterio.getIdCriterio();
		 this.texto =  criterio.getTexto();
	}
	public Long getIdCriterio() {
		return idCriterio;
	}
	public void setIdCriterio(Long idCriterio) {
		this.idCriterio = idCriterio;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
