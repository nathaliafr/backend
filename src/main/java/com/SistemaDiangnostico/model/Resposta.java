package com.SistemaDiangnostico.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta {

	@Id
	@GeneratedValue
	private Long idResposta;
	private String texto;
   
	@OneToOne
	@JoinColumn(name = "idDoenca")
	private Doenca doenca;
 	
 

	public Doenca getDoenca() {
		return doenca;
	}

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}
  

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	 

	 

}
