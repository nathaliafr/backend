package com.SistemaDiangnostico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Criterio")
public class Criterio {

	@Id
	@GeneratedValue
	private Long idCriterio;
	private String texto;
	
	
    @ManyToMany
    @JoinTable(name="criterio_doenca", joinColumns=
    {@JoinColumn(name="idCriterio")}, inverseJoinColumns=
      {@JoinColumn(name="idDoenca")})
    private List<Doenca> doenca;
	
	public List<Doenca> getDoenca() {
		return doenca;
	}
	public void setDoenca(List<Doenca> doenca) {
		this.doenca = doenca;
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
