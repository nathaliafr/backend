package com.SistemaDiangnostico.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questionario")
public class Questionario {

	@Id
	private Long id;
	
}
