package com.SistemaDiangnostico.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	private Long id;
	@Column
	private String tipo;
	
	@ManyToMany
	@JoinTable(name="menu_has_funcionalidade", joinColumns = {
			@JoinColumn(name="menu_id")}, inverseJoinColumns = {
					@JoinColumn(name="funcionalidade_id")})
	private List funcionalidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List getFuncionalidade() {
		return funcionalidade;
	}
	public void setFuncionalidade(List funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

}
