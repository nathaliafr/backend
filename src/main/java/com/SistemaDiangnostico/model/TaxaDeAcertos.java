package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxaDeAcertos")
public class TaxaDeAcertos {
	
	@Id
	@GeneratedValue
	private Long idTaxaDeAcerto;
	private Long acertos;
	private Long erros;
	
	public Long getIdTaxaDeAcerto() {
		return idTaxaDeAcerto;
	}
	public void setIdTaxaDeAcerto(Long idTaxaDeAcerto) {
		this.idTaxaDeAcerto = idTaxaDeAcerto;
	}
	public Long getAcertos() {
		return acertos;
	}
	public void setAcertos(Long acertos) {
		this.acertos = acertos;
	}
	public Long getErros() {
		return erros;
	}
	public void setErros(Long erros) {
		this.erros = erros;
	}
	
}
