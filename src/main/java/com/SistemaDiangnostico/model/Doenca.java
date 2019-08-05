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
@Table(name = "Doenca")
public class Doenca {
	
	@Id
	@GeneratedValue
	private Long idDoenca;
	private String nome;
	
    @ManyToMany
    @JoinTable(name="criterio_doenca", joinColumns=
    {@JoinColumn(name="idDoenca")}, inverseJoinColumns=
      {@JoinColumn(name="idCriterio")})
    private List<Criterio> criterio;
	
	public List<Criterio> getCriterio() {
		return criterio;
	}
	public void setCriterio(List<Criterio> criterio) {
		this.criterio = criterio;
	}
	public Long getIdDoenca() {
		return idDoenca;
	}
	public void setIdDoenca(Long idDoenca) {
		this.idDoenca = idDoenca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
