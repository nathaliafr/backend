package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pergunta")
public class Pergunta {

	@Id
	private Long id;
	private String texo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexo() {
		return texo;
	}
	public void setTexo(String texo) {
		this.texo = texo;
	}
	
}
