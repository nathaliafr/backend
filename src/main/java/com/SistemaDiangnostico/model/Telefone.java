package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
public class Telefone {

	@Id
	private Long idTelefone;
	private int numero;
	private String tipo;

	public Long getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
