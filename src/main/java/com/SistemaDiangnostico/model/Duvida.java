package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="duvida")
public class Duvida {
	
	@Id
	@GeneratedValue
	private Long idDuvida;
	private String texto;
	
	public Long getIdDuvida() {
		return idDuvida;
	}
	public void setIdDuvida(Long idDuvida) {
		this.idDuvida = idDuvida;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
